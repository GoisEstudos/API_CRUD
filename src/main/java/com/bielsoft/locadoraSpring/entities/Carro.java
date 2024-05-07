package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DAO.RequestCarroDAO;
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

    public Carro(RequestCarroDAO requestCarroDAO) {
        this.idFabricante = requestCarroDAO.idFabricante();
        this.idModelo = requestCarroDAO.idModelo();
        this.placa = requestCarroDAO.placa();
        this.cor = requestCarroDAO.cor();
        this.disponivel = requestCarroDAO.disponivel();
        this.ano = requestCarroDAO.ano();
        this.valorlocacao = requestCarroDAO.valorlocacao();
    }
}
