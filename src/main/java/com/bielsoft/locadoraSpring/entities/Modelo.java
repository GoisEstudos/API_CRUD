package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DAO.RequestModeloDAO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
