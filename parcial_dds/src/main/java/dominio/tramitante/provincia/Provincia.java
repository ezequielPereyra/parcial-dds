package dominio.tramitante.provincia;

import java.util.Objects;

public class Provincia {

    private String nombre;
    private String zonaHoraria;
    private Double latitud;
    private Double longitud;

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provincia)) return false;
        Provincia provincia = (Provincia) o;
        return Objects.equals(getNombre(), provincia.getNombre()) && Objects.equals(getZonaHoraria(), provincia.getZonaHoraria()) && Objects.equals(getLatitud(), provincia.getLatitud()) && Objects.equals(getLongitud(), provincia.getLongitud());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getZonaHoraria(), getLatitud(), getLongitud());
    }
}
