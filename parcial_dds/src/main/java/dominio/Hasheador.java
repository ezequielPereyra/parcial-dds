package dominio;

public interface Hasheador{
    String hashear(String contrasenia);

    boolean coinciden(String contraseniaIngresada, String contraseniaRealHasheada);
}