package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "atualizacao_saude_pub")
public class AtualizacaoSaudePub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String descricao;

	private LocalDate dtInfoSaude;

	@ManyToMany(mappedBy = "atualizacoesSaudePub")
		private List<UsuarioEntity> usuarios;

	public AtualizacaoSaudePub() {
		super();
	}

	public AtualizacaoSaudePub(Long id, String titulo, String descricao, LocalDate dtInfoSaude,
			List<UsuarioEntity> usuarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dtInfoSaude = dtInfoSaude;
		this.usuarios = usuarios;
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

	public List<UsuarioEntity> getUsuario() {
		return usuarios;
	}

	public void setUsuario(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

}
