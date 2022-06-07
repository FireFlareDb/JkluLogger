import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class jklulogger {

    private static String username = "YOUR_USERNAME";
    private static String password = "YOUR_PASSWORD";

    public static void donow() throws IOException {
        URL url = new URL("http://172.16.1.1:8090/login.xml");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "*/*");
        http.setRequestProperty("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
        http.setRequestProperty("Connection", "keep-alive");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setRequestProperty("DNT", "1");
        http.setRequestProperty("Sec-GPC", "1");
        http.setRequestProperty("User-Agent",
                "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36");

        String data = String.format("mode=191&username=%s&password=%s&a=1653625623569&producttype=0", username, password);

        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();

    }

    public static void main(String[] args) {
        try {
            donow();
        } catch (IOException e) {
            System.out.println("eeeeeeee");
            System.out.println(e);
        }
    }
}
