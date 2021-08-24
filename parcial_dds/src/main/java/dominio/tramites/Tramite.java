package dominio.tramites;

import dominio.tramites.estadoTramite.EstadoTramite;

public abstract class Tramite {

    public void validarTramite(){
        if(this.getEstado().estoyPendiente()){
            this.concretarValidacion();
        }
    }

    public abstract EstadoTramite getEstado();

    public abstract void concretarValidacion();
}
