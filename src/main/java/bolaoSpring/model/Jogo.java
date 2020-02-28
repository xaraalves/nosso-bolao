package bolaoSpring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@OneToOne
	private Time timeDaCasa;
	@OneToOne
	private Time timeVisitante;
	private Date dataInicio;
	@OneToOne
	private Campeonato campeonato;
	private String idRodada;
	private Integer numGolsCasa;
	private Integer nulGolsVisitante;
	
	//Getters e Setters 
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Time getTimeDaCasa() {
		return timeDaCasa;
	}
	public void setTimeDaCasa(Time timeDaCasa) {
		this.timeDaCasa = timeDaCasa;
	}
	public Time getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Campeonato getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	public String getIdRodada() {
		return idRodada;
	}
	public void setIdRodada(String idRodada) {
		this.idRodada = idRodada;
	}
	public Integer getNumGolsCasa() {
		return numGolsCasa;
	}
	public void setNumGolsCasa(Integer numGolsCasa) {
		this.numGolsCasa = numGolsCasa;
	}
	public Integer getNulGolsVisitante() {
		return nulGolsVisitante;
	}
	public void setNulGolsVisitante(Integer nulGolsVisitante) {
		this.nulGolsVisitante = nulGolsVisitante;
	}
	
	// ToString
	@Override
	public String toString() {
		return "Jogo [Id=" + Id + ", timeDaCasa=" + timeDaCasa + ", timeVisitante=" + timeVisitante + ", dataInicio="
				+ dataInicio + ", campeonato=" + campeonato + ", idRodada=" + idRodada + ", numGolsCasa=" + numGolsCasa
				+ ", nulGolsVisitante=" + nulGolsVisitante + "]";
	}
}
