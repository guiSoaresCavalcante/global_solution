package br.com.fiap.dto;

public class DadosSupleUsrDto {
	private Long id;
	private Double altura;
	private Double peso;
	private char sexo;
	private int idade;

	public DadosSupleUsrDto() {
		super();
	}

	public DadosSupleUsrDto(Long id, Double altura, Double peso, char sexo, int idade) {
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
