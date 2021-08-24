package dominio.validacionTramites;

import dominio.tramites.Tramite;

import java.util.List;

public class RepoTramites {

    private static RepoTramites INSTANCE;

    private RepoTramites() {
    }

    public static RepoTramites getInstance(){
        if(INSTANCE == null){
            INSTANCE = new RepoTramites();
        }

        return INSTANCE;
    }

    public List<Tramite> tramitesPendientes() {

        //TODO: PENDIENTE
        return null;
    }
}
