package br.com.fiap.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDto(
		@NotBlank
		String nome,
		@NotBlank @Email(message = "Email inválido")
		String email,
		@NotBlank
		String senha
) {}
