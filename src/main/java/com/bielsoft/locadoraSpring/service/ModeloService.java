package com.bielsoft.locadoraSpring.service;

import com.bielsoft.locadoraSpring.DAO.RequestModeloDAO;
import com.bielsoft.locadoraSpring.entities.Modelo;
import com.bielsoft.locadoraSpring.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ModeloService {
    @Autowired
    ModeloRepository repository;

    public List<Modelo> obterModelos(){
        return repository.findAll();
    }

    public Modelo obterModeloId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MODELO NAO ENCONTRADO"));
    }

    public Modelo salvarModelo(RequestModeloDAO requestModeloDAO){
        Modelo newModelo = new Modelo(requestModeloDAO);
        return repository.save(newModelo);
    }

    public Modelo atualizarModelo(RequestModeloDAO requestModeloDAO){
        Modelo newModelo = repository.findById(requestModeloDAO.id())
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));

        newModelo.setNome(requestModeloDAO.nome());
        return repository.save(newModelo);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
