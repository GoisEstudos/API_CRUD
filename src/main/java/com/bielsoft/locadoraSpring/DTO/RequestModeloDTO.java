package com.bielsoft.locadoraSpring.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RequestModeloDTO(
        Long id,
        @NotBlank(message = "O nome esta em branco")
        @Pattern(regexp="[0-9]+", message="Apenas números são permitidos")
        String nome,
        @NotBlank
        Long id_fabricante
) {
}
