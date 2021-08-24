package dominio.tramites.estadoTramite;

import dominio.tramitante.Tramitante;
import dominio.tramites.Tramite;

public enum EstadoTramite {


    RECHAZADO {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) {
            personaIniciadora.seRechazoUnTramite();
        }

        @Override
        public void validar(Tramite tramiteSimple) {

        }
    },

    PENDIENTE {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) { }

        @Override
        public void validar(Tramite tramite) {
            EstadoTramite estadoFinal = tramite.esValido() ? APROBADO : RECHAZADO;
            tramite.setEstado(estadoFinal);
            estadoFinal.impactarSobreTramitante(tramite.getPersonaIniciadora());
        }
    },

    APROBADO {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) {
            personaIniciadora.seAproboUnTramite();
        }

        @Override
        public void validar(Tramite tramiteSimple) {

        }
    };

    public abstract void impactarSobreTramitante(Tramitante personaIniciadora);

    public abstract void validar(Tramite tramiteSimple);
}
