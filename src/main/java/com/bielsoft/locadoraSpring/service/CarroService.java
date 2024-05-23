package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DTO.RequestCarroDTO;
import com.bielsoft.locadoraSpring.entities.Carro;
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
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));
    }

    @Transactional
    public Carro salvarCarro(@Valid RequestCarroDTO requestCarroDTO) {
        Carro newCarro = new Carro(requestCarroDTO);
        return repository.save(newCarro);
    }

    @Transactional
    public Carro atualizarCarro(@Valid RequestCarroDTO requestCarroDTO) {
        Carro newCarro = repository.findById(requestCarroDTO.id())
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));

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
}
