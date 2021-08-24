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
        this.actualizarEstado();
    }

    private void actualizarEstado() {
        this.estado = this.calcularEstado();
        this.estado.impactarSobreTramitante(this.personaIniciadora);
    }

    private EstadoTramite calcularEstado() {
        return this.tramitesRequeridos.stream()
                .map(Tramite::getEstado)
                .reduce(EstadoTramite.APROBADO, EstadoTramite::quienGana);
    }

    @Override
    public boolean esValido() {
        return this.tramitesRequeridos.stream().allMatch(Tramite::esValido);
    }
}
