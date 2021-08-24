package dominio.tramites.estadoTramite;

import dominio.tramitante.Tramitante;

public enum EstadoTramite {


    RECHAZADO {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) {
            personaIniciadora.seRechazoUnTramite();
        }
    },

    PENDIENTE {
        @Override
        public Boolean estoyPendiente(){
            return true;
        }

        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) { }
    },

    APROBADO {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) {
            personaIniciadora.seAproboUnTramite();
        }
    };

    public Boolean estoyPendiente(){
        return false;
    }

    public abstract void impactarSobreTramitante(Tramitante personaIniciadora);
}
