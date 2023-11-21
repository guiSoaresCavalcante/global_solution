package br.com.fiap.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DuvidasUsrDto {
	@JsonIgnore
	private Long id;
	private String pergunta;
	private String resposta;
	private Long usuarioId;

	public DuvidasUsrDto(Long id, String pergunta, String resposta, Long usuarioId) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.usuarioId = usuarioId;
	}

	public DuvidasUsrDto() {
		super();

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

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
