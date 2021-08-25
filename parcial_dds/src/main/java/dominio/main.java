package dominio;

import dominio.tramitante.provincia.Provincia;
import dominio.tramitante.provincia.ProvinciaDAO;

public class main {

    private static final ProvinciaDAO provinciaDAO = new ProvinciaDAO();

    public static void main(String[] args) {

        System.out.println("Vamos a persistir algunas provincias de ejemplo.");

        String nombreACambiar = "Prueba";

        Provincia provincia = new Provincia();
        provincia.setLatitud(-26.9468463);
        provincia.setLongitud(-65.2857082);
        provincia.setZonaHoraria("GMT-03:00");
        provincia.setNombre("Tucumán");

        Provincia otraProvincia = new Provincia();
        otraProvincia.setLatitud(-30.9468463);
        otraProvincia.setLongitud(-18.2857082);
        otraProvincia.setZonaHoraria("GMT-03:00");
        otraProvincia.setNombre(nombreACambiar);

        Provincia unaProvincia = new Provincia();
        unaProvincia.setLatitud(-30.9468463);
        unaProvincia.setLongitud(-18.2857082);
        unaProvincia.setZonaHoraria("GMT-03:00");
        unaProvincia.setNombre("Catamarca");

        persistirProvincia(provincia);
        persistirProvincia(otraProvincia);
        persistirProvincia(unaProvincia);

        System.out.println("Ahora vamos a cambiarle el nombre a la que se llama: " + nombreACambiar);

        cambiarNombreDeProvincia(nombreACambiar);

        System.out.println("Finalmente mostramos todas las provincias persistidas: ");
        mostrarTodas();

    }

    private static void mostrarTodas() {
        provinciaDAO.getTodasLasProvincias().forEach(provincia -> {
            System.out.println("------------------------------");
            System.out.println("Nombre de la provincia: " + provincia.getNombre());
            System.out.println("Zona Horaria: " + provincia.getZonaHoraria());
            System.out.println("Latitud: " + provincia.getLatitud());
            System.out.println("Longitud: " + provincia.getLongitud());
        });
    }

    private static void cambiarNombreDeProvincia(String nombreACambiar) {
        if(provinciaDAO.cambiarNombreProvincia(nombreACambiar, "Tierra del Fuego")){
            System.out.println("¡Se pudo cambiar con exito!");
        }
        else {
            System.out.println("Hubo un problema y no se pudo cambiar el nombre de la provincia");
        }
    }

    private static void persistirProvincia(Provincia provincia) {
        int id = provinciaDAO.insert(provincia);
        System.out.println("La provincia se persistio con exito. Su id es: " + id);
    }
}
