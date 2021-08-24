package dominio;
import dominio.hasheador.Hasheador;
import dominio.hasheador.HasheadorBCrypt;
import org.apache.commons.lang3.StringUtils;

public class Usuario {
    private String usuario;
    private String password;
    private Hasheador hasheador = new HasheadorBCrypt();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hasheador.hashear(password);
    }

    public boolean validarLogin(String usuario, String password) {
        if (StringUtils.isNotEmpty(usuario) && StringUtils.isNotEmpty(password)) {
            return hasheador.coinciden(hasheador.hashear(password),this.password);
        } else {
            return false;
        }
    }
}
