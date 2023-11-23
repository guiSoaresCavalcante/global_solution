package br.com.fiap.dto;

public class InfoSaudeUsrDto {

	private Long id;
	private String habitosSaude;
	private String alimentacao;
	private Integer horasSono;
	private Long usuarioId;

	public InfoSaudeUsrDto() {
		super();
	}

	public InfoSaudeUsrDto(Long id, String habitosSaude, String alimentacao, Integer horasSono, Long usuarioId) {
		super();
		this.id = id;
		this.habitosSaude = habitosSaude;
		this.alimentacao = alimentacao;
		this.horasSono = horasSono;
		this.usuarioId = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHabitosSaude() {
		return habitosSaude;
	}

	public void setHabitosSaude(String habitosSaude) {
		this.habitosSaude = habitosSaude;
	}

	public String getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}

	public Integer getHorasSono() {
		return horasSono;
	}

	public void setHorasSono(Integer horasSono) {
		this.horasSono = horasSono;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

}
