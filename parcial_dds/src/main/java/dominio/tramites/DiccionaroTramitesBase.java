package dominio.tramites;

import java.util.ArrayList;
import java.util.List;

public class DiccionaroTramitesBase {

    private final List<Tramite> tramitesBase = new ArrayList<>();

    public List<Tramite> tramitesBase(){
        return this.tramitesBase;
    }
}
