package br.com.fiap.dto;

import br.com.fiap.entity.UsuarioEntity;

public record UsuarioCriadoDto(Long id,String nome, String email, boolean ativo) {

    public UsuarioCriadoDto(UsuarioEntity usuario) {
        this (usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.isAtivo());
    }
}
