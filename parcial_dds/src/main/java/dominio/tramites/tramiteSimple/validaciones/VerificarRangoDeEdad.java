package dominio.tramites.tramiteSimple.validaciones;

import dominio.tramites.Tramite;

public class VerificarRangoDeEdad extends ValidacionNecesaria{

    private Integer edadMinima;
    private Integer edadMaxima;

    public VerificarRangoDeEdad(Integer edadMinima, Integer edadMaxima) {
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
    }

    @Override
    public Boolean esValido(Tramite tramite) {
        Integer edadTramitante = tramite.edadDelTramitante();
        return this.edadMinima <= edadTramitante && edadTramitante <= this.edadMaxima;
    }
}
