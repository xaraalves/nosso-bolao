package bolaoSpring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Bolao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@OneToOne
	private Usuario usuario;
	private LocalDateTime dataCriacao;
	@OneToOne
	private Campeonato campeonato;
	@ElementCollection
	private List<String> participantes;

	public Bolao() { }

	public Bolao(Usuario usuario, LocalDateTime dataCriacao, Campeonato campeonato, List<String> participantes) {
		this.usuario = usuario;
		this.dataCriacao = dataCriacao;
		this.campeonato = campeonato;
		this.participantes = participantes;
	}

	//Getters e Setters
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public List<String> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<String> participantes) {
		this.participantes = participantes;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Bolao [Id=" + Id + ", usuario=" + usuario + ", dataCriacao=" + dataCriacao + ", campeonato="
				+ campeonato + ", participantes=" + participantes + "]";
	}
}
