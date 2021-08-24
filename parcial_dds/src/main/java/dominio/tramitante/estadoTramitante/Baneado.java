package dominio.tramitante.estadoTramitante;

import dominio.tramitante.Tramitante;

public class Baneado extends EstadoTramitante {
    @Override
    public void seRechazoUnTramite(Tramitante tramitante) { }

    @Override
    public void seAproboUnTramite(Tramitante tramitante) { }
}
