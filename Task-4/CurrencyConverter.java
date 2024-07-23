package p1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "apikey"; //place api secret key here

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type currency to convert from (e.g., USD)");
        String convertFrom = scanner.nextLine().toUpperCase();
        System.out.println("Type currency to convert to (e.g., EUR)");
        String convertTo = scanner.nextLine().toUpperCase();
        System.out.println("Type quantity to convert");
        BigDecimal quantity = scanner.nextBigDecimal();

        String urlString = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + convertFrom;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String stringResponse = response.body().string();
            JSONObject jsonObject = new JSONObject(stringResponse);
            JSONObject ratesObject = jsonObject.getJSONObject("conversion_rates");
            BigDecimal rate = ratesObject.getBigDecimal(convertTo);

            BigDecimal result = rate.multiply(quantity);
            System.out.println("Converted amount: " + result);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
