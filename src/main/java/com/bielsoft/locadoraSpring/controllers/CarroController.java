package com.bielsoft.locadoraSpring.controllers;

import com.bielsoft.locadoraSpring.DAO.RequestCarroDAO;
import com.bielsoft.locadoraSpring.entities.Carro;
import com.bielsoft.locadoraSpring.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> obterTodosCarros(){
        return ResponseEntity.ok(service.obterCarros());
    }

    @GetMapping("{id}")
    public ResponseEntity obterCarro(@PathVariable Long id){
        return ResponseEntity.ok(service.obterCarroId(id));
    }

    @PostMapping
    public ResponseEntity salvarCarro(@RequestBody RequestCarroDAO requestCarroDAO){
        Carro newCarro = service.salvarCarro(requestCarroDAO);
        return ResponseEntity.ok(newCarro);
    }

    @PutMapping
    public ResponseEntity atualizarCarro(@PathVariable Long id, @RequestBody RequestCarroDAO requestCarroDAO){
        Carro newCarro = service.atualizarCarro(requestCarroDAO);
        return ResponseEntity.ok(newCarro);
    }

    @DeleteMapping
    public ResponseEntity deletarCarro(@PathVariable Long id){
        service.deletarCarro(id);
        return ResponseEntity.ok().build();
    }
}
