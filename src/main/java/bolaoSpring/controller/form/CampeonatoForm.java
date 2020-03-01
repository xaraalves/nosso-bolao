package bolaoSpring.controller.form;

import bolaoSpring.model.Time;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CampeonatoForm {

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode estar em branco")
    private String nome;

    @NotNull(message = "Data de início não pode ser nula")
    @FutureOrPresent(message = "A data de início deve estar no presente ou no futuro")
    private Date dataInicio;

    @NotNull(message = "Quantidade de times não pode ser nula")
    private Integer qtdeTimes;

    private List<Time> times;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getQtdeTimes() {
        return qtdeTimes;
    }

    public void setQtdeTimes(Integer qtdeTimes) {
        this.qtdeTimes = qtdeTimes;
    }

    public List<Time> getTimes() {
        if(times == null)
            return Collections.emptyList();

        return times;
    }

    public List<String> getNomesTimes() {
        List<String> nomesTimes = new ArrayList<>();
        for(int i=0; i < times.size(); i++) {
            nomesTimes.add(times.get(i).getNome());
        }

        return nomesTimes;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
}
