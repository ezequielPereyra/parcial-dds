package dominio.tramites.tramiteSimple.validaciones;

import dominio.tramitante.provincia.Provincia;
import dominio.tramites.Tramite;

public class VerificarProvincia implements ValidacionNecesaria{

    private Provincia provinciaRequerida;

    @Override
    public Boolean esValido(Tramite tramite) {
        return tramite.perteneceA(this.provinciaRequerida);
    }
}
