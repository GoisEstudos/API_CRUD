package com.bielsoft.locadoraSpring.controllers;

import com.bielsoft.locadoraSpring.DAO.RequestFabricanteDAO;
import com.bielsoft.locadoraSpring.entities.Fabricante;
import com.bielsoft.locadoraSpring.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fabricante")
@CrossOrigin(origins = "*")
public class FabricanteController {
    @Autowired
    private FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> obterFabricantes() {
        List<Fabricante> fabricantes = service.obterTodosFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("{id}")
    public ResponseEntity obterfabricante(@PathVariable Long id) {
        Fabricante fabricante = service.obterFabricanteId(id);
        return ResponseEntity.ok(fabricante);
    }

    @PostMapping
    public ResponseEntity salvarFabricante(@RequestBody RequestFabricanteDAO requestFabricanteDAO){
        Fabricante newFabricante = service.salvarFabricante(requestFabricanteDAO);
        return ResponseEntity.ok(newFabricante);
    }

    @PutMapping
    public ResponseEntity atualizarFabricante(@PathVariable Long id, @RequestBody RequestFabricanteDAO requestFabricanteDAO){
        Fabricante newFabricante = service.atualizarFabricante(requestFabricanteDAO);
        return ResponseEntity.ok(newFabricante);
    }

    @DeleteMapping
    public ResponseEntity deletarFabricante(@PathVariable Long id, @RequestBody RequestFabricanteDAO requestFabricanteDAO){
        service.deletarFabricanteId(id);
        return ResponseEntity.ok().build();
    }
}