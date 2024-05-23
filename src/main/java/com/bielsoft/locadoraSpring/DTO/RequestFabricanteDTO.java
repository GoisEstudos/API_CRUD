package com.bielsoft.locadoraSpring.DTO;

import com.bielsoft.locadoraSpring.repositories.FabricanteRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

public record RequestFabricanteDTO(
        Long id,
        @NotBlank(message = "O nome esta em branco")
        @Pattern(regexp="[0-9]+", message="Apenas números são permitidos")
        String nome
) {
}
