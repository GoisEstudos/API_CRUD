package com.bielsoft.locadoraSpring.repositories;

import com.bielsoft.locadoraSpring.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    boolean existsByNomeIgnoreCase(String nome);

    boolean existsByIdFabricante(Long idFabricante);

    boolean dontExistsByIdFabricanteByIdFabricante(Long idFabricante);

}
