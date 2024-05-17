package controller;

import exception.MonedaNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeApi {
    private static final String API_KEY = "584a9bd94913afa18e4f9429";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public String buscaMoneda(String moneda){

        String direccion = API_URL + API_KEY +"/latest/"+ moneda;
        System.out.println(direccion);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                throw new MonedaNotFoundException("Moneda no encontrada: " + moneda);
            }

            return response.body();
        } catch (IOException | InterruptedException e) {
            // Manejo de excepciones relacionadas con la conexión HTTP
            throw new MonedaNotFoundException("Error al buscar la moneda: " + moneda);
        }
    }
}
