package dominio.conexionesBD;
import dominio.Usuario;
import dominio.tramitante.provincia.Provincia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dominio.conexionesBD.ConexionMySQL.newConnection;

public class UsuarioDAO {

    private Connection conn;


    public int insert(String nombre, String password_hasheada, Boolean soyAdmin){
        String consulta = "INSERT INTO Usuario (nombre_usuario, password_hash, es_admin) VALUES ('" + nombre + "', '" + password_hasheada + "'," + soyAdmin +");";
        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            // execute the preparedstatement
            stmt.executeUpdate();

            // obtener �ltimo id generado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
                return generatedKeys.getInt(1);
            else
                return 0;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Insert");
            return 0;
        }
    }

    public boolean cambiarContrasenia(String usuario, String contrasenia) {
        String consulta = "UPDATE Usuario SET password_hash = '" + contrasenia + "' WHERE nombre_usuario = '" + usuario + "';";

        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.executeUpdate();
            return true;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Update");
            return false;
        }

    }

    public boolean borrarUsuario(String nombreUsuario){
        String consulta = "DELETE FROM Usuario WHERE nombre_usuario = '" + nombreUsuario + "';";

        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);

            // execute the preparedstatement
            stmt.executeUpdate();
            return true;


        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Delete");
            return false;
        }

    }

    public Usuario getUnUsuario(String nombreUsuario){
        String consulta = "SELECT * FROM Usuario WHERE nombre_usuario = '" + nombreUsuario + "';";
        try {

            this.conn = newConnection();

            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery(consulta);

            Usuario obj = new Usuario();
            obj.setUsuario(rs.getString("nombre_usuario"));
            obj.setPassword(rs.getString("password_hash"));
            obj.setSoyAdmin(rs.getBoolean("es_admin"));

            return obj;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

    public List<Usuario> getTodosLosUsuarios(){
        String consulta = "SELECT * FROM Usuario";
        try {

            this.conn = newConnection();
            List<Usuario> usuarios = new ArrayList<>();
            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next()){
                Usuario obj = new Usuario();
                obj.setUsuario(rs.getString("nombre_usuario"));
                obj.setPassword(rs.getString("password_hash"));
                obj.setSoyAdmin(rs.getBoolean("es_admin"));
                usuarios.add(obj);
            }
            return usuarios;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }
}
