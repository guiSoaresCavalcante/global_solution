package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import br.com.fiap.dto.CadastroUsuarioDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USUARIO")
	private Long id;

	@Column(name = "NM_USUARIO")
	private String nome;

	@Column(name = "SOBRENOME_USUARIO")
	private String sobrenome;

	@Column(name = "EMAIL_USUARIO")
	private String email;

	@Column(name = "SENHA_USUARIO")
	private String senha;

	@Column(name = "DATA_CADASTRO")
	private LocalDate dataCadastro;

	@Column(name = "ATIVO", columnDefinition = "BIT")
	private boolean ativo;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DADOS_SUPLE_USR")
	private DadosSupleUsr dadosSupleUsr;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InfoSaudeUsr> infoSaudeList;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DuvidasUsr> DuvidasUsrList;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SugestoesSaude> SugestoesSaude;

	@ManyToMany
	@JoinTable(name = "USUARIO_ATUALIZACAO_SAUDE_PUB", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_ATUALIZACAO_SAUDE_PUB"))
	private Set<AtualizacaoSaudePub> atualizacoesSaudePub;

	public UsuarioEntity(CadastroUsuarioDto dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.senha = dados.senha();
		this.dataCadastro = LocalDate.now();
	}

	public UsuarioEntity(Long id, String nome, String sobrenome, String email, String senha, LocalDate dataCadastro,
						 boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
	}

	public UsuarioEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}