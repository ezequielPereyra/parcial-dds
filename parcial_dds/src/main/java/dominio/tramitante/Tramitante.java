package dominio.tramitante;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Tramitante {

    private LocalDateTime fechaDeNacimiento;
    private LocalDateTime fechaRegistro;

    public void seRechazoUnTramite() {
    }

    public void seAproboUnTramite() {
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
}
