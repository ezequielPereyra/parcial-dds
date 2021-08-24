package dominio.tramites;

import dominio.tramites.estadoTramite.EstadoTramite;
import dominio.tramites.prototypeTramites.PrototypeTramites;
import dominio.tramitante.Tramitante;

import java.time.LocalDateTime;

public abstract class Tramite implements PrototypeTramites {

    protected EstadoTramite estado = EstadoTramite.PENDIENTE;
    private LocalDateTime fechaInicio;
    private String nombre;
    protected Tramitante personaIniciadora;

    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    public Tramitante getPersonaIniciadora() {
        return personaIniciadora;
    }

    public EstadoTramite getEstado() {
        return estado;
    }

    public Tramite(Tramite fuente) {
        this.fechaInicio = fuente.fechaInicio;
        this.nombre = fuente.nombre;
        this.personaIniciadora = fuente.personaIniciadora;
        this.estado = fuente.estado;
    }

    public abstract void validarTramite();

    public abstract boolean esValido();
}
