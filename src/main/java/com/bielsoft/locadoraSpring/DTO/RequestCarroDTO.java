package com.bielsoft.locadoraSpring.DTO;

import jakarta.validation.constraints.*;

public record RequestCarroDTO(
        Long id,
        @NotBlank
        Long idFabricante,
        @NotBlank
        Long idModelo,
        @NotBlank
        @Size(min = 7, max = 7, message = "A placa tem que ter 7 caracteres!")
        String placa,
        @NotBlank
        @Max(value = 10, message = "A cor deve ter no maximo 10 caracteres")
        String cor,
        @NotEmpty
        Boolean disponivel,
        @NotBlank
        @Future
        String ano,
        @NotBlank
        Double valorlocacao
) {
}
