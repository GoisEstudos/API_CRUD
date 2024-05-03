package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DAO.RequestFabricanteDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Fabricante(RequestFabricanteDAO requestFabricanteDAO) {
        this.nome = requestFabricanteDAO.nome();
    }
}
