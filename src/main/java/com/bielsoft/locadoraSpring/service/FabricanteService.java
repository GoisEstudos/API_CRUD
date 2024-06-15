package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DTO.RequestFabricanteDTO;
import com.bielsoft.locadoraSpring.entities.Fabricante;
import com.bielsoft.locadoraSpring.exceptions.FabricanteExistenteException;
import com.bielsoft.locadoraSpring.exceptions.FabricanteNaoEncontradoException;
import com.bielsoft.locadoraSpring.repositories.FabricanteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .orElseThrow(() -> new FabricanteNaoEncontradoException());
    }

    @Transactional
    public Fabricante salvarFabricante(@Valid RequestFabricanteDTO requestFabricanteDTO){
        existeFabricante(requestFabricanteDTO);
        Fabricante newFabricante = new Fabricante(requestFabricanteDTO);
        return repository.save(newFabricante);
    }

    @Transactional
    public Fabricante atualizarFabricante(@Valid RequestFabricanteDTO requestFabricanteDTO){
        Fabricante newFabricante = repository.findById(requestFabricanteDTO.id())
                .orElseThrow(() -> new FabricanteNaoEncontradoException());
        newFabricante.setNome(requestFabricanteDTO.nome());
        return repository.save(newFabricante);
    }

    @Transactional
    public void deletarFabricanteId(Long id){
        repository.deleteById(id);
    }

    private String existeFabricante(RequestFabricanteDTO requestFabricanteDTO) {
        String existeFabricante = requestFabricanteDTO.nome();
        if (repository.existsByNomeIgnoreCase(existeFabricante)){
            throw new FabricanteExistenteException();
        }
        return existeFabricante;
    }
}
