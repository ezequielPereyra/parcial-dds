package dominio.validacionTramites;

import dominio.tramites.Tramite;

public class ValidadorDeTramites {

    public void validarTramites(){
        RepoTramites.getInstance()
                .tramitesPendientes()
                .forEach(Tramite::validarTramite);
    }
}
