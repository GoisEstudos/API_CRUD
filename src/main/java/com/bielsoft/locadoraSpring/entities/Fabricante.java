package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DTO.RequestFabricanteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fabricante")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Fabricante(RequestFabricanteDTO requestFabricanteDTO) {
        this.nome = requestFabricanteDTO.nome();
    }
}
