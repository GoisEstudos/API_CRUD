package com.bielsoft.locadoraSpring.repositories;

import com.bielsoft.locadoraSpring.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    boolean existsByIdFabricante(Long idFabricante);

    boolean existsByIdModelo(Long idModelo);

    boolean existsByPlacaIgnoreCase(String placa);

    boolean dontExistsByIdFabricante(Long idFabricante);

    boolean dontExistsByIdModelo(Long idModelo);
}
