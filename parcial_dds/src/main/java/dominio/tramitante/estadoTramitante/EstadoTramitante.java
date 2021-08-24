package dominio.tramitante.estadoTramitante;

import dominio.tramitante.Tramitante;

public abstract class EstadoTramitante {
    
    //Esto esta para poder diferenciar la subclase en la persistencia
    private String nombre;

    public abstract void seRechazoUnTramite(Tramitante tramitante);

    public abstract void seAproboUnTramite(Tramitante tramitante);
}
