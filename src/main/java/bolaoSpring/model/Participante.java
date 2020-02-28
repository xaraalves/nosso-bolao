package bolaoSpring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Usuario usuario;
	private Date dataEntrada;
	private String linkAcesso;
	@OneToOne
	private Palpite palpite;
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getLinkAcesso() {
		return linkAcesso;
	}
	public void setLinkAcesso(String linkAcesso) {
		this.linkAcesso = linkAcesso;
	}
	public Palpite getPalpite() {
		return palpite;
	}
	public void setPalpite(Palpite palpite) {
		this.palpite = palpite;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Participante [id=" + id + ", usuario=" + usuario + ", dataEntrada=" + dataEntrada + ", linkAcesso="
				+ linkAcesso + ", palpite=" + palpite + "]";
	}
}
