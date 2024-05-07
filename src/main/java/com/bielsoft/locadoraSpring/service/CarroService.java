package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DAO.RequestCarroDAO;
import com.bielsoft.locadoraSpring.entities.Carro;
import com.bielsoft.locadoraSpring.repositories.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Carro salvarCarro(RequestCarroDAO requestCarroDAO) {
        Carro newCarro = new Carro(requestCarroDAO);
        return repository.save(newCarro);
    }

    public Carro atualizarCarro(RequestCarroDAO requestCarroDAO) {
        Carro newCarro = repository.findById(requestCarroDAO.id())
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));

        newCarro.setPlaca(requestCarroDAO.placa());
        newCarro.setCor(requestCarroDAO.cor());
        newCarro.setDisponivel(requestCarroDAO.disponivel());
        newCarro.setAno(requestCarroDAO.ano());
        newCarro.setValorlocacao(requestCarroDAO.valorlocacao());

        return repository.save(newCarro);
    }

    public void deletarCarro(Long id) {
        repository.findById(id);
    }
}
