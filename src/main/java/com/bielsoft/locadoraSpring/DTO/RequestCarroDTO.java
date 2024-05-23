package com.bielsoft.locadoraSpring.DTO;

import jakarta.validation.constraints.NotBlank;

public record RequestCarroDTO(
        Long id,
        Long idFabricante,
        Long idModelo, String placa,
        String cor,
        Boolean disponivel,
        String ano,
        Double valorlocacao
) {
}
