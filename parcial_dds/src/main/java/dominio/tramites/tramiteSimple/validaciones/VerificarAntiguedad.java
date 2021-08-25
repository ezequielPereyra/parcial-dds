package dominio.tramites.tramiteSimple.validaciones;

import dominio.tramites.Tramite;

public class VerificarAntiguedad extends ValidacionNecesaria{

    private Integer aniosDeAntiguedad;

    public VerificarAntiguedad(Integer aniosDeAntiguedad) {
        this.aniosDeAntiguedad = aniosDeAntiguedad;
    }

    @Override
    public Boolean esValido(Tramite tramite) {
        return this.aniosDeAntiguedad <= tramite.aniosAntiguedadTramitante();
    }
}
