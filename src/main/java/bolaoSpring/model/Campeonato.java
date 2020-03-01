package bolaoSpring.model;

import bolaoSpring.controller.dto.TimeDto;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Campeonato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String nome;
	private Date dataInicio;
	private Integer qtdeTimes;
	@ManyToMany
	private List<Time> times;

	public Campeonato() {}

	public Campeonato (String nome, Date dataInicio, Integer qtdeTimes, List<Time> times) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.qtdeTimes = qtdeTimes;
		this.times = times;
	}
	
	/* Getters e Setters */

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

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
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	/* ToString */
	@Override
	public String toString() {
		return "Campeonato [Id=" + Id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", qtdeTimes=" + qtdeTimes
				+ "]";
	}
}
