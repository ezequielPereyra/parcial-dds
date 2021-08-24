package dominio.tramitante.provincia;
import java.sql.*;
public class ProvinciaDAO {

    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://localhost:3306/parcial-dds";
            conn = DriverManager.getConnection(connectionUrl, "root", "");

            // Do something with the Connection
            //System.out.println("Conexi�n realizada");

            return conn;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

    public int insert(String nombre, String zonaHoraria, Double latitud, Double longitud){
        String consulta = "INSERT INTO Provincia (nombre, zona_horaria, latitud, longitud) VALUES ('" + nombre + "', '" + zonaHoraria + "'," + latitud.doubleValue() + "," + longitud.doubleValue() + ");";
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

    public boolean cambiarNombreProvincia(String nombreViejo, String nombreNuevo) {
        String consulta = "UPDATE Provincia SET nombre = '" + nombreNuevo + "' WHERE nombre = '" + nombreViejo + "';";

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

    public boolean borrarProvincia(String nombreProvincia){
        String consulta = "DELETE FROM Provincia WHERE nombre = '" + nombreProvincia + "';";

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
}
