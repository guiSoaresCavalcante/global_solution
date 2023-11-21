package br.com.fiap.dto;

import java.time.LocalDate;

public class SugestoesSaudeDto {
	private Long id;
	private String sugestao;
	private LocalDate dtSugestao;
	private Long usuarioId;

	public SugestoesSaudeDto(Long id, String sugestao, LocalDate dtSugestao, Long usuarioId) {
		super();
		this.id = id;
		this.sugestao = sugestao;
		this.dtSugestao = dtSugestao;
		this.usuarioId = usuarioId;
	}

	public SugestoesSaudeDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
