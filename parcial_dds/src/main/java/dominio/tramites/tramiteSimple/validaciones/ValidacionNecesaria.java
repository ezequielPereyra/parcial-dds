package dominio.tramites.tramiteSimple.validaciones;

import dominio.tramites.Tramite;

public abstract class ValidacionNecesaria {

    private String nombreValidacion;

    public abstract Boolean esValido(Tramite tramite);
}
