package com.bielsoft.locadoraSpring.DTO;

import com.bielsoft.locadoraSpring.repositories.FabricanteRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

public record RequestFabricanteDTO(
        Long id,
        @NotBlank(message = "O nome esta em branco")
        @Pattern(regexp="[0-9]+", message="Apenas números são permitidos")
        @Max(value = 100, message = "O nome nao pode ser maior que 100 caracteres")
        String nome
) {
}
