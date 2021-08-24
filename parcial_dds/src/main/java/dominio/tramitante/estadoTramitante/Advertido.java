package dominio.tramitante.estadoTramitante;

import dominio.tramitante.Tramitante;

public class Advertido extends EstadoTramitante{

    private Integer cantidadTramitesAprobados = 0;
    private Integer cantidadTramitesRechazados = 0;
    private static final Integer UMBRAL = 2;

    @Override
    public void seRechazoUnTramite(Tramitante tramitante) {
        this.cantidadTramitesRechazados++;
        if(this.cantidadTramitesRechazados - this.cantidadTramitesAprobados > UMBRAL){
            tramitante.setEstado(new Baneado());
        }
    }

    @Override
    public void seAproboUnTramite(Tramitante tramitante) {
        this.cantidadTramitesAprobados++;
        if(this.cantidadTramitesAprobados - this.cantidadTramitesRechazados > UMBRAL){
            tramitante.setEstado(new Valido());
        }
    }
}
