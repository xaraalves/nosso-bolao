package bolaoSpring.controller.dto;

import bolaoSpring.model.Bolao;
import bolaoSpring.model.Campeonato;
import bolaoSpring.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BolaoDto {


    private UsuarioDto dono;
    private LocalDateTime dataCriacao;
    private CampeonatoDto campeonato;
    private List<String> convidados;

    public BolaoDto() { }

    public BolaoDto(Bolao bolao) {
        this.dono = new UsuarioDto(bolao.getUsuario());
        this.dataCriacao = bolao.getDataCriacao();
        this.campeonato = new CampeonatoDto(bolao.getCampeonato());
        this.convidados = bolao.getParticipantes();
    }

    public UsuarioDto getDono() {
        return dono;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public CampeonatoDto getCampeonato() {
        return campeonato;
    }

    public List<String> getConvidados() {
        return convidados;
    }
}
