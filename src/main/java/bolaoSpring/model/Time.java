package bolaoSpring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String nome;
	private Date dataFundacao;
	
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
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	/* ToString */
	@Override
	public String toString() {
		return "Time [Id=" + Id + ", nome=" + nome + ", dataFundacao=" + dataFundacao + "]";
	}
	
}
