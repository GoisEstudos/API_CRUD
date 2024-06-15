package com.bielsoft.locadoraSpring.controllers;

import com.bielsoft.locadoraSpring.DTO.RequestFabricanteDTO;
import com.bielsoft.locadoraSpring.advice.ApplicationExceptionHandler;
import com.bielsoft.locadoraSpring.entities.Fabricante;
import com.bielsoft.locadoraSpring.exceptions.ExceptionAbstrata;
import com.bielsoft.locadoraSpring.service.FabricanteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
    @Autowired
    private FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> obterFabricantes() {
        List<Fabricante> fabricantes = service.obterTodosFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fabricante> obterfabricante(@PathVariable Long id) {
        Fabricante fabricante = service.obterFabricanteId(id);
        return ResponseEntity.ok(fabricante);
    }

    @PostMapping
    public ResponseEntity<Fabricante> salvarFabricante(@RequestBody RequestFabricanteDTO requestFabricanteDTO){
        Fabricante newFabricante = service.salvarFabricante(requestFabricanteDTO);
        return ResponseEntity.ok(newFabricante);
    }

    @PatchMapping
    public ResponseEntity<Fabricante> atualizarFabricante(@RequestBody RequestFabricanteDTO requestFabricanteDTO){
        Fabricante newFabricante = service.atualizarFabricante(requestFabricanteDTO);
        return ResponseEntity.ok(newFabricante);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Fabricante> deletarFabricante(@PathVariable Long id){
        service.deletarFabricanteId(id);
        return ResponseEntity.ok().build();
    }
}