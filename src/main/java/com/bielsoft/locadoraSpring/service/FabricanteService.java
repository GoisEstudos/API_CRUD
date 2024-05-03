package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DAO.RequestFabricanteDAO;
import com.bielsoft.locadoraSpring.entities.Fabricante;
import com.bielsoft.locadoraSpring.repositories.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FabricanteService {
    @Autowired
    FabricanteRepository repository;

    public List<Fabricante> obterTodosFabricantes() {
        return repository.findAll();
    }

    public Fabricante obterFabricanteId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("FABRICANTE NÃO ENCONTRADA"));
    }

    public Fabricante salvarFabricante(RequestFabricanteDAO requestFabricanteDAO){
        Fabricante newFabricante = new Fabricante(requestFabricanteDAO);
        return repository.save(newFabricante);
    }

    public Fabricante atualizarFabricante(RequestFabricanteDAO requestFabricanteDAO){
        Fabricante newFabricante = repository.findById(requestFabricanteDAO.id())
                .orElseThrow(() -> new RuntimeException("FABRICANTE NÃO ENCONTRADO"));
        newFabricante.setNome(requestFabricanteDAO.nome());
        return repository.save(newFabricante);
    }

    public void deletarFabricanteId(Long id){
        repository.deleteById(id);
    }
}
