package bolaoSpring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CampeonatoTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Long IdCampeonato;
    private Long IdTime;

    public Long getIdCampeonato() {
        return IdCampeonato;
    }

    public void setIdCampeonato(Long idCampeonato) {
        IdCampeonato = idCampeonato;
    }

    public Long getIdTime() {
        return IdTime;
    }

    public void setIdTime(Long idTime) {
        IdTime = idTime;
    }
}
