package bolaoSpring.controller.form;

import bolaoSpring.model.Participante;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BolaoForm {

    @NotNull
    private String nomeCampeonato;
    @NotNull
    private List<String> convidados;

    public String getNomeCampeonato() {
        return nomeCampeonato;
    }

    public void setNomeCampeonato(String nomeCampeonato) {
        this.nomeCampeonato = nomeCampeonato;
    }

    public List<String> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<String> convidados) {
        this.convidados = convidados;
    }
}
