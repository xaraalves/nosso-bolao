package bolaoSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Palpite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;	
	@OneToOne
	private Jogo jogo;
	private Integer numGolsCasa;
	private Integer numGolsVisitante;
	private Boolean dobra;
	private Integer pontuacao;
	private Boolean processado;
	
	//Getters e Setters
	public Jogo getJogo() {
		return jogo;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	public Integer getNumGolsCasa() {
		return numGolsCasa;
	}
	public void setNumGolsCasa(Integer numGolsCasa) {
		this.numGolsCasa = numGolsCasa;
	}
	public Integer getNumGolsVisitante() {
		return numGolsVisitante;
	}
	public void setNumGolsVisitante(Integer numGolsVisitante) {
		this.numGolsVisitante = numGolsVisitante;
	}
	public Boolean getDobra() {
		return dobra;
	}
	public void setDobra(Boolean dobra) {
		this.dobra = dobra;
	}
	public Integer getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}
	public Boolean getProcessado() {
		return processado;
	}
	public void setProcessado(Boolean processado) {
		this.processado = processado;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Palpite [jogo=" + jogo + ", numGolsCasa=" + numGolsCasa + ", numGolsVisitante=" + numGolsVisitante
				+ ", dobra=" + dobra + ", pontuacao=" + pontuacao + ", processado=" + processado + "]";
	}
		
}
