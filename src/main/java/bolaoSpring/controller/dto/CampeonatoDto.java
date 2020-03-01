package bolaoSpring.controller.dto;

import bolaoSpring.model.Campeonato;
import bolaoSpring.model.Time;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CampeonatoDto {

    private String nome;
    private Date dataInicio;
    private Integer qtdeTimes;
    private List<TimeDto> times;

    public CampeonatoDto() { }

    public CampeonatoDto(Campeonato campeonato) {
        this.nome = campeonato.getNome();
        this.dataInicio = campeonato.getDataInicio();
        this.qtdeTimes = campeonato.getQtdeTimes();
        this.times = new ArrayList<>();
        for(int i=0; i < campeonato.getTimes().size(); i++) {
            this.times.add(new TimeDto(campeonato.getTimes().get(i)));
        }
    }

    public String getNome() {
        return nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Integer getQtdeTimes() {
        return qtdeTimes;
    }

    public List<TimeDto> getTimes() {
        return times;
    }
}
