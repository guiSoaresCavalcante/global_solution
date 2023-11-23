package br.com.fiap.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioDto(
        @NotNull
        Long id,
        String nome,
        String email
) {
}
