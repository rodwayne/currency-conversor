import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {

    public Currency convertRequest(int option, double amount) {
        String baseCode = "", targetCode = "";

        switch (option) {
            case 1 -> {
                baseCode = "USD";
                targetCode = "ARS";
            }
            case 2 -> {
                baseCode = "ARS";
                targetCode = "USD";
            }
            case 3 -> {
                baseCode = "USD";
                targetCode = "BRL";
            }
            case 4 -> {
                baseCode = "BRL";
                targetCode = "USD";
            }
            case 5 -> {
                baseCode = "USD";
                targetCode = "COP";
            }
            case 6 -> {
                baseCode = "COP";
                targetCode = "USD";
            }
            case 7 -> {
                baseCode = "USD";
                targetCode = "MXN";
            }
            case 8 -> {
                baseCode = "MXN";
                targetCode = "USD";
            }
        }

        URI urlStr = URI.create("https://v6.exchangerate-api.com/v6/22617e4afb20de9e4b9622c3/pair/" + baseCode + "/" + targetCode  + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(urlStr)
                .build();

        HttpResponse<String> response;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }

        return new Gson().fromJson(response.body(), Currency.class);
    }

}
