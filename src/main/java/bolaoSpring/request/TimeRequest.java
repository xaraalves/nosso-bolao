package bolaoSpring.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class TimeRequest {

    @NotNull(message = "Nome do time não pode ser nulo")
    @NotEmpty(message = "Nome do time não pode estar em branco")
    private String nome;

    @NotNull(message = "Data de fundação não pode ser nula")
    @Past(message = "Data de fundação deve estar no passado")
    private Date dataFundacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
