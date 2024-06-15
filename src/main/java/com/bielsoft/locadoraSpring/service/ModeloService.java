package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DTO.RequestFabricanteDTO;
import com.bielsoft.locadoraSpring.DTO.RequestModeloDTO;
import com.bielsoft.locadoraSpring.entities.Modelo;
import com.bielsoft.locadoraSpring.exceptions.FabricanteExistenteException;
import com.bielsoft.locadoraSpring.exceptions.FabricanteNaoEncontradoException;
import com.bielsoft.locadoraSpring.exceptions.ModeloExisteException;
import com.bielsoft.locadoraSpring.exceptions.ModeloNaoEncontradoException;
import com.bielsoft.locadoraSpring.repositories.ModeloRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ModeloService {
    @Autowired
    ModeloRepository repository;

    public List<Modelo> obterModelos() {
        return repository.findAll();
    }

    public Modelo obterModeloId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ModeloNaoEncontradoException());
    }

    @Transactional
    public Modelo salvarModelo(@Valid RequestModeloDTO requestModeloDTO) {
        existeModelo(requestModeloDTO);
        Modelo newModelo = new Modelo(requestModeloDTO);
        return repository.save(newModelo);
    }

    @Transactional
    public Modelo atualizarModelo(@Valid RequestModeloDTO requestModeloDTO) {
        Modelo newModelo = repository.findById(requestModeloDTO.id())
                .orElseThrow(() -> new ModeloNaoEncontradoException());

        newModelo.setNome(requestModeloDTO.nome());
        return repository.save(newModelo);
    }

    @Transactional
    public void deletarModelo(Long id) {
        repository.deleteById(id);
    }

    private String existeModelo(RequestModeloDTO requestModeloDTO) {
        String existeModelo = requestModeloDTO.nome();
        Long idFabricante = requestModeloDTO.id_fabricante();
        if (repository.existsByNomeIgnoreCase(existeModelo)) {
            throw new ModeloExisteException();
        }
        if (repository.existsByIdFabricante(idFabricante)){
            throw new FabricanteExistenteException();
        }
        if (repository.dontExistsByIdFabricanteByIdFabricante(idFabricante)) {
            throw new FabricanteNaoEncontradoException();
        }
        return existeModelo;
    }
}
