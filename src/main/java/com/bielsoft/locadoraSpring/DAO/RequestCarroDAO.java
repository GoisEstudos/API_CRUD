package com.bielsoft.locadoraSpring.DAO;

public record RequestCarroDAO(Long id, Long idFabricante, Long idModelo, String placa, String cor, Boolean disponivel, String ano, Double valorlocacao) {
}
