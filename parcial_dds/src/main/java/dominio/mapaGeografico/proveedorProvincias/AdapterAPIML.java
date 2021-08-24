package dominio.mapaGeografico.proveedorProvincias;

import dominio.excepciones.PaisNoEncontradoException;
import dominio.mapaGeografico.proveedorProvincias.dtos.countries.CompleteCountryDTO;
import dominio.mapaGeografico.proveedorProvincias.dtos.states.CompleteStateDTO;
import dominio.mapaGeografico.proveedorProvincias.dtos.countries.CountryDTO;
import dominio.mapaGeografico.proveedorProvincias.dtos.states.StateDTO;
import dominio.tramitante.provincia.Provincia;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterAPIML implements ProveedorProvincias{

    private static final String apiDomain = "https://api.mercadolibre.com";

    private Client client = ClientBuilder.newClient();

    @Override
    public List<Provincia> provinciasDeArgentina() {
        List<CountryDTO> countries = this.getCountries();

        String idArgentina = countries.stream()
                .filter(country -> country.name.equals("Argentina"))
                .findFirst()
                .orElseThrow(() -> new PaisNoEncontradoException("No se pudo encontrar a Argentina entre los paises disponibles")).id;

        List<StateDTO> states = this.getStatesFrom(idArgentina);

        List<CompleteStateDTO> completeStates = states.stream()
                .map(state -> this.getCompleteState(state.id))
                .collect(Collectors.toList());

        return completeStates.stream()
                .map(this::crearProvincia)
                .collect(Collectors.toList());
    }

    private Provincia crearProvincia(CompleteStateDTO state) {
        Provincia provincia = new Provincia();
        provincia.setNombre(state.name);
        provincia.setZonaHoraria(state.time_zone);
        provincia.setLatitud(state.geo_information.location.latitude);
        provincia.setLongitud(state.geo_information.location.longitude);

        return provincia;
    }

    private CompleteStateDTO getCompleteState(String stateId) {
        return client
                .target(apiDomain)
                .path("classified_locations/states/" + stateId)
                .request(MediaType.APPLICATION_JSON)
                .get(CompleteStateDTO.class);
    }

    private List<StateDTO> getStatesFrom(String countryId) {
        return this.getCompleteCountry(countryId).states;
    }

    private CompleteCountryDTO getCompleteCountry(String countryId) {
        return client
                .target(apiDomain)
                .path("classified_locations/countries/" + countryId)
                .request(MediaType.APPLICATION_JSON)
                .get(CompleteCountryDTO.class);
    }

    private List<CountryDTO> getCountries() {
        return client
                .target(apiDomain)
                .path("classified_locations/countries")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<CountryDTO>>(){});
    }
}
