package dominio.tramites.tramitante.tramiteSimple.validaciones;

import dominio.tramites.Tramite;

public interface ValidacionNecesaria {
    Boolean esValido(Tramite tramite);
}
