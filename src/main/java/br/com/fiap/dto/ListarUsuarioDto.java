package br.com.fiap.dto;

import java.time.LocalDate;

import br.com.fiap.entity.UsuarioEntity;

public record ListarUsuarioDto(Long id, String nome, String email, LocalDate dataCadastro) {

	public ListarUsuarioDto(UsuarioEntity usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getEmail(),usuario.getDataCadastro());
	}

}


