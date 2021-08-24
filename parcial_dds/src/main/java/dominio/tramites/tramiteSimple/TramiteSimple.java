package dominio.tramites.tramiteSimple;

import dominio.tramites.Tramite;
import dominio.tramites.estadoTramite.EstadoTramite;
import dominio.tramites.tramiteSimple.validaciones.ValidacionNecesaria;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TramiteSimple extends Tramite {

    private final List<ValidacionNecesaria> validaciones = new ArrayList<>();

    @Override
    public EstadoTramite getEstado() {
        return this.estadoActual;
    }

    @Override
    public void concretarValidacion() {
        if(validaciones.stream().anyMatch(validacion -> !validacion.esValido(this))){
            this.estadoActual = EstadoTramite.RECHAZADO;
        }
        else{
            this.estadoActual = EstadoTramite.APROBADO;
        }

        this.estadoActual.impactarSobreTramitante(this.personaIniciadora);
    }

    @Override
    public Tramite clonarTramite() {
        TramiteSimple clon = new TramiteSimple();
        clon.fechaInicio = LocalDateTime.now();
        clon.nombre = this.nombre;
        clon.estadoActual = EstadoTramite.PENDIENTE;
        clon.agregarValidaciones(this.validaciones);
        return clon;
    }

    private void agregarValidaciones(List<ValidacionNecesaria> validaciones) {
        this.validaciones.addAll(validaciones);
    }
}
