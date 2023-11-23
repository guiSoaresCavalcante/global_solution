package br.com.fiap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "infos_saude_usr")
public class InfoSaudeUsr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "habitos_saude")
	private String habitosSaude;

	@Column(name = "alimentacao")
	private String alimentacao;

	@Column(name = "horas_sono")
	private Integer horasSono;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioEntity usuario;

	public InfoSaudeUsr() {
	}

	public InfoSaudeUsr(String habitosSaude, String alimentacao, Integer horasSono, UsuarioEntity usuario) {
		this.habitosSaude = habitosSaude;
		this.alimentacao = alimentacao;
		this.horasSono = horasSono;
		this.usuario = usuario;
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}
