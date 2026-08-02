package com.guilherme.example;

import java.util.Optional;

import com.guilherme.example.dao.InstrutorDAO;
import com.guilherme.example.db.DBFactory;
import com.guilherme.example.entities.Instrutor;

public class Main {
    public static void main(String[] args) {
        InstrutorDAO instrutorDAO = new InstrutorDAO();

        // Criando um novo instrutor
        Instrutor novoInstrutor = new Instrutor();
        novoInstrutor.setNome("Carlos Eduardo");
        novoInstrutor.setEmail("carlos.eduardo@example.com");
        novoInstrutor.setBiografia("Especialista em desenvolvimento de software e arquitetura de sistemas.");

        // Persistindo o novo instrutor
        instrutorDAO.salvar(novoInstrutor);

        // Buscando o instrutor pelo ID
        Optional<Instrutor> instrutorEncontrado = instrutorDAO.buscarPorId(novoInstrutor.getId());
        if (instrutorEncontrado.isPresent()) {
            System.out.println("Instrutor encontrado: " + instrutorEncontrado.get().getNome());
        } else {
            System.out.println("Instrutor não encontrado.");
        }

        // Atualizando o instrutor
        novoInstrutor.setNome("Carlos E. Silva");
        instrutorDAO.atualizar(novoInstrutor);

        // Removendo o instrutor
        instrutorDAO.remover(novoInstrutor.getId());

        // Fechando a fábrica de EntityManager
        DBFactory.fechar();
    }
}