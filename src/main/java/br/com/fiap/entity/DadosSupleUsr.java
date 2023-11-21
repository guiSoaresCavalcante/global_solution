package br.com.fiap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dados_suple_usr")
public class DadosSupleUsr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double altura;

	private Double peso;

	private char sexo;

	private int idade;
	
	 @OneToOne(mappedBy = "dadosSupleUsr", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private UsuarioEntity usuarioEntity;

	public DadosSupleUsr() {
		super();
	}

	public DadosSupleUsr(Long id, Double altura, Double peso, char sexo, int idade) {
		super();
		this.id = id;
		this.altura = altura;
		this.peso = peso;
		this.sexo = sexo;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
