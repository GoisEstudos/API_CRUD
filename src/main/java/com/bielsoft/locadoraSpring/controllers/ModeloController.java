package com.bielsoft.locadoraSpring.controllers;

import com.bielsoft.locadoraSpring.DTO.RequestModeloDTO;
import com.bielsoft.locadoraSpring.entities.Modelo;
import com.bielsoft.locadoraSpring.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modelo")
@CrossOrigin(origins = "*")
public class ModeloController {
    @Autowired
    ModeloService service;

    @GetMapping
    public ResponseEntity<List<Modelo>> obterTodosModelos(){
        return ResponseEntity.ok(service.obterModelos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Modelo> obterModelo(@PathVariable Long id){
        return ResponseEntity.ok(service.obterModeloId(id));
    }

    @PostMapping
    public ResponseEntity<Modelo> salvarModelo(@RequestBody RequestModeloDTO requestModeloDTO){
        Modelo newModelo = service.salvarModelo(requestModeloDTO);
        return ResponseEntity.ok(newModelo);
    }

    @PatchMapping
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable Long id, @RequestBody RequestModeloDTO requestModeloDTO){
        Modelo newModelo = service.atualizarModelo(requestModeloDTO);
        return ResponseEntity.ok(newModelo);
    }

    @DeleteMapping
    public ResponseEntity<Modelo> deletarModelo(@PathVariable Long id){
        service.deletarModelo(id);
        return ResponseEntity.ok().build();
    }
}
