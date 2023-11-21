package br.com.fiap.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sugestoes_saude")
public class SugestoesSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sugestao;

	private LocalDate dtSugestao;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	public SugestoesSaude() {
		super();
	}

	public SugestoesSaude(Long id, String sugestao, LocalDate dtSugestao, UsuarioEntity usuario) {
		super();
		this.id = id;
		this.sugestao = sugestao;
		this.dtSugestao = dtSugestao;
		this.usuario = usuario;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public LocalDate getDtSugestao() {
		return dtSugestao;
	}

	public void setDtSugestao(LocalDate dtSugestao) {
		this.dtSugestao = dtSugestao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
