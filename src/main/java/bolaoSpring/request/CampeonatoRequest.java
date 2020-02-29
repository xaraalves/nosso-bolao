package bolaoSpring.request;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CampeonatoRequest {

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode estar em branco")
    private String nome;

    @NotNull(message = "Data de início não pode ser nula")
    @FutureOrPresent(message = "A data de início deve estar no presente ou no futuro")
    private Date dataInicio;

    @NotNull(message = "Quantidade de times não pode ser nula")
    private Integer qtdeTimes;

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
}
