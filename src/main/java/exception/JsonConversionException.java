package exception;

public class JsonConversionException extends RuntimeException{

    public JsonConversionException(String mensaje) {
        super(mensaje);
    }
}
