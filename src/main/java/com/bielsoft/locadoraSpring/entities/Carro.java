package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DTO.RequestCarroDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idFabricante;
    private Long idModelo;
    private String placa;
    private String cor;
    private Boolean disponivel;
    private String ano;
    private Double valorlocacao;

    public Carro(RequestCarroDTO requestCarroDTO) {
        this.idFabricante = requestCarroDTO.idFabricante();
        this.idModelo = requestCarroDTO.idModelo();
        this.placa = requestCarroDTO.placa();
        this.cor = requestCarroDTO.cor();
        this.disponivel = requestCarroDTO.disponivel();
        this.ano = requestCarroDTO.ano();
        this.valorlocacao = requestCarroDTO.valorlocacao();
    }
}
