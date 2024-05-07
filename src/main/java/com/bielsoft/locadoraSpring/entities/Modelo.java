package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DAO.RequestModeloDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long id_fabricante;

    public Modelo(RequestModeloDAO requestModeloDAO){
         this.nome = requestModeloDAO.nome();
         this.id_fabricante = requestModeloDAO.id_fabricante();
    }
}
