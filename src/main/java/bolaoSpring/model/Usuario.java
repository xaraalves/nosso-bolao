package bolaoSpring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(unique = true)
	private String login;

	private Date dataHora;

	private String senha;

	public Usuario() {}

	public Usuario(String login, String senha, Date data) {
		this.login = login;
		this.senha = senha;
		this.dataHora = data;
	}

	//Getters e Setters
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	//ToString
	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", login=" + login + ", dataHora=" + dataHora + ", senha=" + senha + "]";
	}
}
