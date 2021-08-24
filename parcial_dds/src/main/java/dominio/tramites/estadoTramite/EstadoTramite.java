package dominio.tramites.estadoTramite;

public enum EstadoTramite {


    RECHAZADO,

    PENDIENTE {
        @Override
        public Boolean estoyPendiente(){
            return true;
        }
    },

    APROBADO;

    public Boolean estoyPendiente(){
        return false;
    }
}
