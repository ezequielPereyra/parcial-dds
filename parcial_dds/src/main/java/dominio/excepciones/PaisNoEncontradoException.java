package dominio.excepciones;

public class PaisNoEncontradoException extends RuntimeException {
    public PaisNoEncontradoException(String message) {
        super(message);
    }
}
