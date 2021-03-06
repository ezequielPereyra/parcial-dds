package dominio.tramitante;

import dominio.Usuario;
import dominio.tramitante.estadoTramitante.EstadoTramitante;
import dominio.tramitante.estadoTramitante.Valido;
import dominio.tramitante.provincia.Provincia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Tramitante {

    private LocalDateTime fechaDeNacimiento;
    private LocalDateTime fechaRegistro;
    private String nombre;
    private String apellido;
    private String telefono;
    private EstadoTramitante estado = new Valido();
    private Provincia provincia;
    private Usuario usuario;

    public void seRechazoUnTramite() {
        this.estado.seRechazoUnTramite(this);
    }

    public void seAproboUnTramite() {
        this.estado.seAproboUnTramite(this);
    }

    public void setEstado(EstadoTramitante estado) {
        this.estado = estado;
    }

    private Integer aniosQuePasaronDesde(LocalDateTime fecha){
        return Period.between(fecha.toLocalDate(), LocalDate.now()).getYears();
    }

    public Integer edad(){
        return this.aniosQuePasaronDesde(this.fechaDeNacimiento);
    }

    public Integer aniosAntiguedad() {
        return this.aniosQuePasaronDesde(this.fechaRegistro);
    }

    public Boolean resideEn(Provincia provincia) {
        return this.provincia.equals(provincia);
    }
}
