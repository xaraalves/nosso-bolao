package bolaoSpring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Campeonato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String nome;
	private Date dataInicio;
	private Integer qtdeTimes;

	public Campeonato() {}

	public Campeonato (String nome, Date dataInicio, Integer qtdeTimes) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.qtdeTimes = qtdeTimes;
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
	
	/* ToString */
	@Override
	public String toString() {
		return "Campeonato [Id=" + Id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", qtdeTimes=" + qtdeTimes
				+ "]";
	}
}
