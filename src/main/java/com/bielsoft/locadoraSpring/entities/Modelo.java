package com.bielsoft.locadoraSpring.entities;

import com.bielsoft.locadoraSpring.DTO.RequestModeloDTO;
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
    private Long idFabricante;

    public Modelo(RequestModeloDTO requestModeloDTO){
         this.nome = requestModeloDTO.nome();
         this.idFabricante = requestModeloDTO.id_fabricante();
    }
}
