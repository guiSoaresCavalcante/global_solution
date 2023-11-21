package br.com.fiap.dto;

import java.time.LocalDate;
import java.util.List;

public class AtualizacaoSaudePubDto {

	private Long id;
	private String titulo;
	private String descricao;
	private LocalDate dtInfoSaude;
	private List<Long> usuarioIds;

	public AtualizacaoSaudePubDto() {
		super();
	}

	public AtualizacaoSaudePubDto(Long id, String titulo, String descricao, LocalDate dtInfoSaude,
			List<Long> usuarioIds) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dtInfoSaude = dtInfoSaude;
		this.usuarioIds = usuarioIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDtInfoSaude() {
		return dtInfoSaude;
	}

	public void setDtInfoSaude(LocalDate dtInfoSaude) {
		this.dtInfoSaude = dtInfoSaude;
	}

	public List<Long> getUsuarioIds() {
		return usuarioIds;
	}

	public void setUsuarioIds(List<Long> usuarioIds) {
		this.usuarioIds = usuarioIds;
	}

}
