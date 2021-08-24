package dominio.tramites.estadoTramite;

import dominio.tramitante.Tramitante;
import dominio.tramites.Tramite;
import java.util.Comparator;
import java.util.stream.Stream;

public enum EstadoTramite {

    APROBADO {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) {
            personaIniciadora.seAproboUnTramite();
        }

        @Override
        public void validar(Tramite tramite) {

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

    RECHAZADO {
        @Override
        public void impactarSobreTramitante(Tramitante personaIniciadora) {
            personaIniciadora.seRechazoUnTramite();
        }

        @Override
        public void validar(Tramite tramite) {

        }
    };

    public abstract void impactarSobreTramitante(Tramitante personaIniciadora);

    public abstract void validar(Tramite tramite);

    public EstadoTramite quienGana(EstadoTramite otroEstado) {
        return Stream.of(this, otroEstado).max(Comparator.naturalOrder()).orElse(APROBADO);
    }
}
