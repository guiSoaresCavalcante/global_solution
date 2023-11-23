package br.com.fiap.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "duvidas_usr")
public class DuvidasUsr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pergunta;

	private String respota;

	@ManyToOne 
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	public DuvidasUsr() {
		super();
	}

	public DuvidasUsr(Long id, String pergunta, String respota, UsuarioEntity usuario) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.respota = respota;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getRespota() {
		return respota;
	}

	public void setRespota(String respota) {
		this.respota = respota;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

}
