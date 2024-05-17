import controller.ExchangeApi;
import model.mapper.ConvertToEntity;
import model.mapper.ConverteToJson;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {

        int opcion = 0;
        String moneda = null;
        String monedaConver = null;
        Scanner entrada = new Scanner(System.in);
        ExchangeApi exchangeApi = new ExchangeApi();
        ConverteToJson converToJson = new ConverteToJson();
        String menu = menu();
        float cantidad;
        float cantidadConver = 0;
        
        while(opcion !=7 ){
            System.out.println("""
                            
                            
                            ***********************************************
                                    BIENVENIDO A CONVETIDOR DE MONEDAS
                                    """);
            System.out.println(menu);
            opcion = entrada.nextInt();

            switch(opcion) {
                case 1:
                    moneda ="MXN";
                    break;
                case 2:
                    moneda = "USD";
                    break;
                case 3:
                    moneda = "CAD";
                    break;
                case 4:
                    moneda= "JYP";
                    break;
                case 5:
                    moneda= "ARS";
                    break;
                case 6:
                    moneda= "EUR";
                    break;
                case 7:
                    break;
            }
        
            //API para buscar la moneda
            converToJson.convertToJson(exchangeApi.buscaMoneda(moneda));
            //Convirtiendo DTO a Entity
            ConvertToEntity convertToEntity = new ConvertToEntity(converToJson.getDivisaDto());

            System.out.println("""
                            ***********************************************
                                    Ingresa cantidad a convertir
                            ***********************************************
                            """ );
            cantidad = entrada.nextFloat();
            System.out.println("A que moneda quieres convertirlo: ");
            System.out.println(menu);
            opcion = entrada.nextInt();

            switch(opcion) {
                case 1:
                    monedaConver ="MXN";
                    cantidadConver = (float) (cantidad * convertToEntity.getDivisaEntity().getMXN());
                    break;
                case 2:
                    monedaConver = "USD";
                    cantidadConver = (float) (cantidad * convertToEntity.getDivisaEntity().getUSD());
                    break;
                case 3:
                    monedaConver = "CAD";
                    cantidadConver = (float) (cantidad * convertToEntity.getDivisaEntity().getCAD());
                    break;
                case 4:
                    monedaConver = "JYP";
                    cantidadConver = (float) (cantidad * convertToEntity.getDivisaEntity().getJPY());
                    break;
                case 5:
                    monedaConver = "ARS";
                    cantidadConver = (float) (cantidad * convertToEntity.getDivisaEntity().getARS());
                    break;
                case 6:
                    monedaConver = "EUR";
                    cantidadConver = (float) (cantidad * convertToEntity.getDivisaEntity().getEUR());
                    break;
                case 7:
                    break;
            }

            System.out.println("La cantidad de $" + cantidad + moneda + " son $" + cantidadConver + monedaConver);
        }






    }

    public static String menu(){
        return """
                ***********************************************
                        Selecciona moneda
                ***********************************************
                
                1) MXN (Peso Mexicano)
                2) USD (Dólar estadounidense)
                3) CAD (Dolar Canadiense)
                4) JYP (Yen japonés)
                5) ARS (Peso Argentino)
                6) EUR (EURO)
                7) Salir
                
                *********************************************
                  Nota: Solo numeros
                **********************************************
                
                """;
    }

}
