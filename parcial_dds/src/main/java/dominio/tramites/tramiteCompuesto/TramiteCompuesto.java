package dominio.tramites.tramiteCompuesto;

import dominio.tramites.Tramite;
import dominio.tramites.estadoTramite.EstadoTramite;

import java.util.ArrayList;
import java.util.List;

public class TramiteCompuesto extends Tramite {

    private final List<Tramite> tramitesRequeridos = new ArrayList<>();

    public TramiteCompuesto(TramiteCompuesto fuente) {
        super(fuente);
        this.agregarTramites(this.tramitesRequeridos);
    }

    private void agregarTramites(List<Tramite> tramitesRequeridos) {
        this.tramitesRequeridos.addAll(tramitesRequeridos);
    }

    @Override
    public Tramite clonarTramite() {
        return new TramiteCompuesto(this);
    }

    @Override
    public void validarTramite() {
        this.tramitesRequeridos.forEach(Tramite::validarTramite);
    }

    @Override
    public boolean esValido() {
        return this.tramitesRequeridos.stream().allMatch(Tramite::esValido);
    }
}
