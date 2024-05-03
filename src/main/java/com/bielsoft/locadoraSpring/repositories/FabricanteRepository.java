package com.bielsoft.locadoraSpring.repositories;

import com.bielsoft.locadoraSpring.entities.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
