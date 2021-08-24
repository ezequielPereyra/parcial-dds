package dominio.tramitante.estadoTramitante;

import dominio.tramitante.Tramitante;

public class Valido extends EstadoTramitante{
    @Override
    public void seRechazoUnTramite(Tramitante tramitante) {
        tramitante.setEstado(new Advertido());
    }

    @Override
    public void seAproboUnTramite(Tramitante tramitante) { }
}
