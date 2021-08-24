package dominio.mapaGeografico.proveedorProvincias.dtos.states;

import dominio.mapaGeografico.proveedorProvincias.dtos.cities.CityDTO;
import dominio.mapaGeografico.proveedorProvincias.dtos.cities.ReducedCountryDTO;
import dominio.mapaGeografico.proveedorProvincias.dtos.countries.GeographicInfoDTO;

import java.util.List;

public class CompleteStateDTO {

    public String id;
    public String name;
    public ReducedCountryDTO country;
    public GeographicInfoDTO geo_information;
    public String time_zone;
    public List<CityDTO> cities;
}
