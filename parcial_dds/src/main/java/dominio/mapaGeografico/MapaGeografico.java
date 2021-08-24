package dominio.mapaGeografico;

import dominio.mapaGeografico.proveedorProvincias.AdapterAPIML;
import dominio.mapaGeografico.proveedorProvincias.ProveedorProvincias;
import dominio.tramitante.provincia.Provincia;

import java.util.List;

public class MapaGeografico {

    private ProveedorProvincias proveedor = new AdapterAPIML();

    public List<Provincia> provinciasDeArgentina(){
        return this.proveedor.provinciasDeArgentina();
    }
}
