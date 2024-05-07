package com.bielsoft.locadoraSpring.repositories;

import com.bielsoft.locadoraSpring.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
