package dominio.tramites;

import dominio.tramites.estadoTramite.EstadoTramite;
import dominio.tramites.prototypeTramites.PrototypeTramites;

public abstract class Tramite implements PrototypeTramites {

    public void validarTramite(){
        if(this.getEstado().estoyPendiente()){
            this.concretarValidacion();
        }
    }

    public abstract EstadoTramite getEstado();

    public abstract void concretarValidacion();
}
