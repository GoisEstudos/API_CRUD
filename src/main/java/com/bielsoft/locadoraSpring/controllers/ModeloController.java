package com.bielsoft.locadoraSpring.controllers;

import com.bielsoft.locadoraSpring.DAO.RequestModeloDAO;
import com.bielsoft.locadoraSpring.entities.Modelo;
import com.bielsoft.locadoraSpring.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modelo")
public class ModeloController {
    @Autowired
    ModeloService service;

    @GetMapping
    public ResponseEntity<List<Modelo>> obterTodosModelos(){
        return ResponseEntity.ok(service.obterModelos());
    }

    @GetMapping("{id}")
    public ResponseEntity obterModelo(@PathVariable Long id){
        return ResponseEntity.ok(service.obterModeloId(id));
    }

    @PostMapping
    public ResponseEntity salvarModelo(@RequestBody RequestModeloDAO requestModeloDAO){
        Modelo newModelo = service.salvarModelo(requestModeloDAO);
        return ResponseEntity.ok(newModelo);
    }

    @PutMapping
    public ResponseEntity atualizarModelo(@PathVariable Long id, @RequestBody RequestModeloDAO requestModeloDAO){
        Modelo newModelo = service.atualizarModelo(requestModeloDAO);
        return ResponseEntity.ok(newModelo);
    }

    @DeleteMapping
    public ResponseEntity deletarModelo(@PathVariable Long id){
        service.deletarModelo(id);
        return ResponseEntity.ok().build();
    }
}
