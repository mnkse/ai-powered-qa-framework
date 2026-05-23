package utils;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class OpenAiFailureAnalyzer {

    public static String analyzeFailure(
            Scenario scenario,
            String errorMessage
    ) {

        if (!scenario.isFailed()) {
            return "";
        }

        try {

            String apiKey =
                    System.getenv("OPENAI_API_KEY");

            if (apiKey == null || apiKey.isEmpty()) {
                System.out.println("OPENAI_API_KEY is not defined.");
                return "";
            }

            String prompt =
                    "You are a senior QA automation engineer.\n\n" +
                            "Analyze this failed automated test scenario.\n\n" +
                            "Scenario Name: " + scenario.getName() + "\n" +
                            "Error Message: " + errorMessage + "\n\n" +
                            "Return the answer in clean Markdown format with these sections:\n" +
                            "## Root Cause\n" +
                            "## Possible Fixes\n" +
                            "## Stability Improvements\n" +
                            "## CI/CD Recommendations";

            String escapedPrompt =
                    prompt
                            .replace("\\", "\\\\")
                            .replace("\"", "\\\"")
                            .replace("\n", "\\n")
                            .replace("\r", "\\r");

            String requestBody =
                    """
                    {
                      "model": "gpt-4o-mini",
                      "messages": [
                        {
                          "role": "user",
                          "content": "%s"
                        }
                      ],
                      "max_tokens": 500
                    }
                    """.formatted(escapedPrompt);

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(
                                    URI.create(
                                            "https://api.openai.com/v1/chat/completions"
                                    )
                            )
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .header(
                                    "Authorization",
                                    "Bearer " + apiKey
                            )
                            .POST(
                                    HttpRequest.BodyPublishers.ofString(
                                            requestBody
                                    )
                            )
                            .build();

            HttpClient client =
                    HttpClient.newHttpClient();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            String cleanResponse =
                    extractContentFromResponse(
                            response.body()
                    );

            File directory =
                    new File("target/ai-analysis");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File report =
                    new File(
                            directory,
                            "ai-failure-analysis.md"
                    );

            try (FileWriter writer =
                         new FileWriter(report, true)) {

                writer.write("# AI Failure Analysis\n\n");
                writer.write("Time: " + LocalDateTime.now() + "\n\n");
                writer.write("Scenario: " + scenario.getName() + "\n\n");
                writer.write("Error Message: " + errorMessage + "\n\n");
                writer.write(cleanResponse);
                writer.write("\n\n--------------------------\n\n");
            }

            return cleanResponse;

        } catch (IOException e) {

            System.out.println("AI analysis report could not be written.");
            return "";

        } catch (Exception e) {

            System.out.println("OpenAI analysis failed.");
            System.out.println(e.getMessage());
            return "";
        }
    }

    private static String extractContentFromResponse(
            String responseBody
    ) {

        try {

            int contentIndex =
                    responseBody.indexOf("\"content\":");

            if (contentIndex == -1) {
                return responseBody;
            }

            int start =
                    responseBody.indexOf(
                            "\"",
                            contentIndex + 10
                    ) + 1;

            int end =
                    responseBody.indexOf(
                            "\",",
                            start
                    );

            if (end == -1) {
                return responseBody;
            }

            String content =
                    responseBody.substring(
                            start,
                            end
                    );

            return content
                    .replace("\\n", "\n")
                    .replace("\\\"", "\"")
                    .replace("\\/", "/");

        } catch (Exception e) {

            return responseBody;
        }
    }
}