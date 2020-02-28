package bolaoSpring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bolao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@OneToOne
	private Usuario usuario;
	private Date dataCriacao;
	@OneToOne
	private Campeonato campeonato;
	@OneToMany
	private List<Participante> participantes;
	
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
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public List<Participante> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Bolao [Id=" + Id + ", usuario=" + usuario + ", dataCriacao=" + dataCriacao + ", campeonato="
				+ campeonato + ", participantes=" + participantes + "]";
	}
}
