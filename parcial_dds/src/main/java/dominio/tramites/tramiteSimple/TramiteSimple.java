package dominio.tramites.tramiteSimple;

import dominio.tramites.Tramite;
import dominio.tramites.tramiteSimple.validaciones.ValidacionNecesaria;
import java.util.ArrayList;
import java.util.List;

public class TramiteSimple extends Tramite {

    private final List<ValidacionNecesaria> validaciones = new ArrayList<>();

    public TramiteSimple(TramiteSimple fuente) {
        super(fuente);
        this.agregarValidaciones(fuente.validaciones);
    }


    @Override
    public Tramite clonarTramite() {
        return new TramiteSimple(this);
    }

    private void agregarValidaciones(List<ValidacionNecesaria> validaciones) {
        this.validaciones.addAll(validaciones);
    }

    @Override
    public void validarTramite() {
        this.estado.validar(this);
    }

    @Override
    public boolean esValido() {
        return this.validaciones.stream().allMatch(validacion -> validacion.esValido(this));
    }
}
