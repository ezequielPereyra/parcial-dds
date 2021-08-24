package dominio;
import org.mindrot.jbcrypt.BCrypt;
public class HasheadorBCrypt implements Hasheador{
    private static final Integer COMPLEJIDAD = 12;

    @Override
    public String hashear(String contrasenia) {
        return BCrypt.hashpw(contrasenia, BCrypt.gensalt(COMPLEJIDAD));
    }

    @Override
    public boolean coinciden(String contraseniaIngresada, String contraseniaRealHasheada) {
        return BCrypt.checkpw(contraseniaIngresada, contraseniaRealHasheada);
    }
}
