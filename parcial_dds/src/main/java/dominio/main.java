package dominio;

import dominio.tramitante.provincia.Provincia;
import dominio.tramitante.provincia.ProvinciaDAO;

public class main {

    private static final ProvinciaDAO provinciaDAO = new ProvinciaDAO();

    public static void main(String[] args) {

        Provincia provincia = new Provincia();
        provincia.setLatitud(-26.9468463);
        provincia.setLongitud(-65.2857082);
        provincia.setZonaHoraria("GMT-03:00");
        provincia.setNombre("Tucumán");

        persistirProvincia(provincia);

    }

    private static void persistirProvincia(Provincia provincia) {
        int id = provinciaDAO.insert(provincia);
        System.out.println("La provincia se persistio con exito. Su id es: " + id);
    }
}
