package bolaoSpring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotNull(message = "Login não pode ser Nulo")
	@NotEmpty(message = "Login não pode ser em branco") 
	@Email(message = "Login precisa ser um email válido")
	@Column(unique = true)
	private String login;
	@NotNull(message = "data/hora do cadastro não pode ser nula!")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataHora;
	
	@Transient //Não é salva no banco
	@NotNull(message = "Senha não pode ser Nula")
	@NotEmpty(message = "Senha não pode ser em branco") 
	@Length(min = 6, message="Senha precisa ter no mínimo 6 caracteres")
	private String senha;
	
	@JsonIgnore //Assim não aparece no Rest
	private String senhaHash; //Senha criptografada que será salva
	
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
	public String getSenhaHash() {
		return senhaHash;
	}
	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}
	//ToString
	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", login=" + login + ", dataHora=" + dataHora + ", senha=" + senha + "]";
	}
}
