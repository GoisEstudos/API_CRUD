package com.bielsoft.locadoraSpring.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RequestModeloDTO(
        Long id,
        @NotBlank(message = "O nome esta em branco")
        @Pattern(regexp="[0-9]+", message="Apenas números são permitidos")
        @Max(value = 100, message = "O nome nao pode ter mais que 100 caracteres")
        String nome,
        @NotBlank
        Long id_fabricante
) {
}
