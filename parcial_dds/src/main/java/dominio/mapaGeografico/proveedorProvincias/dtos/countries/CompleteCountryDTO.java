package dominio.mapaGeografico.proveedorProvincias.dtos.countries;

import dominio.mapaGeografico.proveedorProvincias.dtos.states.StateDTO;

import java.util.List;

public class CompleteCountryDTO {

    public String id;
    public String name;
    public String locale;
    public String currency_id;
    public String decimal_separator;
    public String thousands_separator;
    public String time_zone;
    public GeographicInfoDTO geo_information;
    public List<StateDTO> states;
}
