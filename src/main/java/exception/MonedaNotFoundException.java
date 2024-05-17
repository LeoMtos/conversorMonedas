package exception;

public class MonedaNotFoundException extends RuntimeException{

    public MonedaNotFoundException(String mensaje) {
        super(mensaje);
    }

}
