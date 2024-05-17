import controller.ExchangeApi;
import model.mapper.ConverteToJson;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {

        System.out.println("introduce moneda");
        Scanner entrada = new Scanner(System.in);
        String moneda = entrada.nextLine();
        ExchangeApi exchangeApi = new ExchangeApi();

        ConverteToJson converteToJson = new ConverteToJson();
        converteToJson.convertToJson(exchangeApi.buscaMoneda(moneda));

        System.out.println(converteToJson.getDivisaDto());

    }
}
