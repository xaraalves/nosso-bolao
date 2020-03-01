package bolaoSpring.controller.dto;

import bolaoSpring.model.Time;

import java.util.Date;

public class TimeDto {

    private String nome;
    private Date dataFundacao;

    public TimeDto() {}

    public TimeDto(Time time) {
        this.nome = time.getNome();
        this.dataFundacao = time.getDataFundacao();
    }

    public String getNome() {
        return nome;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }
}
