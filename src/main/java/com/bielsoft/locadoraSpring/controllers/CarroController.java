package com.bielsoft.locadoraSpring.controllers;

import com.bielsoft.locadoraSpring.DTO.RequestCarroDTO;
import com.bielsoft.locadoraSpring.entities.Carro;
import com.bielsoft.locadoraSpring.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carro")
@CrossOrigin(origins = "*")
public class CarroController {

    @Autowired
    CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> obterTodosCarros(){
        return ResponseEntity.ok(service.obterCarros());
    }

    @GetMapping("{id}")
    public ResponseEntity<Carro> obterCarro(@PathVariable Long id){
        return ResponseEntity.ok(service.obterCarroId(id));
    }

    @PostMapping
    public ResponseEntity<Carro> salvarCarro(@RequestBody RequestCarroDTO requestCarroDTO){
        Carro newCarro = service.salvarCarro(requestCarroDTO);
        return ResponseEntity.ok(newCarro);
    }

    @PatchMapping
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody RequestCarroDTO requestCarroDTO){
        Carro newCarro = service.atualizarCarro(requestCarroDTO);
        return ResponseEntity.ok(newCarro);
    }

    @DeleteMapping
    public ResponseEntity<Carro> deletarCarro(@PathVariable Long id){
        service.deletarCarro(id);
        return ResponseEntity.ok().build();
    }
}
