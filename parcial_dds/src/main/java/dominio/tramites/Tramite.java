package dominio.tramites;

import dominio.tramites.estadoTramite.EstadoTramite;
import dominio.tramites.prototypeTramites.PrototypeTramites;
import dominio.tramitante.Tramitante;

import java.time.LocalDateTime;

public abstract class Tramite implements PrototypeTramites {

    protected EstadoTramite estadoActual = EstadoTramite.PENDIENTE;
    protected LocalDateTime fechaInicio;
    protected String nombre;
    protected Tramitante personaIniciadora;

    public void validarTramite(){
        if(this.hayQueValidar()){
            this.concretarValidacion();
        }
    }

    private Boolean hayQueValidar() {
        return this.getEstado().estoyPendiente();
    }

    public abstract EstadoTramite getEstado();

    public abstract void concretarValidacion();
}
