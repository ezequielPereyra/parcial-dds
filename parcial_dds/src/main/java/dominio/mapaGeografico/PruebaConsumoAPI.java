package dominio.mapaGeografico;

import dominio.tramitante.provincia.Provincia;

public class PruebaConsumoAPI {

    private static final MapaGeografico mapa = new MapaGeografico();

    public static void main(String[] args) {
        mapa.provinciasDeArgentina().forEach(PruebaConsumoAPI::imprimir);
    }

    private static void imprimir(Provincia provincia) {
        System.out.println("------------------------------");
        System.out.println("Nombre de la provincia: " + provincia.getNombre());
        System.out.println("Zona Horaria: " + provincia.getZonaHoraria());
        System.out.println("Latitud: " + provincia.getLatitud());
        System.out.println("Longitud: " + provincia.getLongitud());
    }
}
