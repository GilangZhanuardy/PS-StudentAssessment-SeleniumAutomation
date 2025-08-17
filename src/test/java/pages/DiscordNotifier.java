package pages;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DiscordNotifier {
    public static void sendToDiscord(String webhookUrl, String message) {
        System.out.println("DiscordNotifier dipanggil!");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(webhookUrl);

            // Format payload Discord (JSON)
            String jsonPayload = String.format("{\"content\": \"%s\"}", message);
            httpPost.setEntity(new StringEntity(jsonPayload,"UTF-8"));
            httpPost.setHeader("Content-Type", "application/json");

            System.out.println(jsonPayload);

            // Eksekusi request
            httpClient.execute(httpPost);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

