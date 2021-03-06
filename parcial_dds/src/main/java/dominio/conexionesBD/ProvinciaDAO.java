package dominio.conexionesBD;

import dominio.tramitante.provincia.Provincia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dominio.conexionesBD.ConexionMySQL.newConnection;

public class ProvinciaDAO {

    private Connection conn;

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
            System.out.println("Error en Delete");
            return false;
        }

    }

    public int insert(Provincia provincia) {
        return this.insert(provincia.getNombre(), provincia.getZonaHoraria(),
                provincia.getLatitud(), provincia.getLongitud());
    }

    public List<Provincia> getTodasLasProvincias(){
        String consulta = "SELECT * FROM Provincia";
        try {

            this.conn = newConnection();
            List<Provincia> provincias = new ArrayList<>();
            // Ejecuci�n
            PreparedStatement stmt = this.conn.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next()){
                Provincia obj = new Provincia();
                obj.setNombre(rs.getString("nombre"));
                obj.setZonaHoraria(rs.getString("zona_horaria"));
                obj.setLatitud(rs.getDouble("latitud"));
                obj.setLongitud(rs.getDouble("longitud"));
                provincias.add(obj);
            }
            return provincias;

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }
}
