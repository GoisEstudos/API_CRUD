package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DTO.RequestCarroDTO;
import com.bielsoft.locadoraSpring.DTO.RequestModeloDTO;
import com.bielsoft.locadoraSpring.entities.Carro;
import com.bielsoft.locadoraSpring.exceptions.*;
import com.bielsoft.locadoraSpring.repositories.CarroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository repository;

    public List<Carro> obterCarros() {
        return repository.findAll();
    }

    public Carro obterCarroId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CarroIdNaoEncontradoException());
    }

    @Transactional
    public Carro salvarCarro(@Valid RequestCarroDTO requestCarroDTO) {
        existeCarro(requestCarroDTO);
        Carro newCarro = new Carro(requestCarroDTO);
        return repository.save(newCarro);
    }

    @Transactional
    public Carro atualizarCarro(@Valid RequestCarroDTO requestCarroDTO) {
        Carro newCarro = repository.findById(requestCarroDTO.id())
                .orElseThrow(() -> new CarroIdNaoEncontradoException());

        newCarro.setPlaca(requestCarroDTO.placa());
        newCarro.setCor(requestCarroDTO.cor());
        newCarro.setDisponivel(requestCarroDTO.disponivel());
        newCarro.setAno(requestCarroDTO.ano());
        newCarro.setValorlocacao(requestCarroDTO.valorlocacao());

        return repository.save(newCarro);
    }

    @Transactional
    public void deletarCarro(Long id) {
        repository.findById(id);
    }

    private String existeCarro(RequestCarroDTO requestCarroDTO) {
        Long existeIdFabricante = requestCarroDTO.idFabricante();
        Long existeIdModelo = requestCarroDTO.idModelo();
        String existePlaca = requestCarroDTO.placa();
        if (repository.existsByIdFabricante(existeIdFabricante)) {
            throw new ModeloExisteException();
        }
        if (repository.existsByIdModelo(existeIdModelo)){
            throw new FabricanteExistenteException();
        }
        if (repository.existsByPlacaIgnoreCase(existePlaca)){
            throw new PlacaExistenteException();
        }
        if (repository.dontExistsByIdFabricante(existeIdFabricante)){
            throw new FabricanteNaoEncontradoException();
        }
        if (repository.dontExistsByIdModelo(existeIdModelo)){
            throw new ModeloNaoEncontradoException();
        }
        return existeCarro(requestCarroDTO);
    }
}
