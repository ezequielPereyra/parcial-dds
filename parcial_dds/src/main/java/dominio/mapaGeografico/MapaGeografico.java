package dominio.mapaGeografico;

import dominio.mapaGeografico.proveedorProvincias.ProveedorProvincias;
import dominio.tramitante.direccion.Provincia;

import java.util.List;

public class MapaGeografico {

    private ProveedorProvincias proveedor;

    public List<Provincia> provinciasDeArgentina(){
        return this.proveedor.provinciasDeArgentina();
    }
}
