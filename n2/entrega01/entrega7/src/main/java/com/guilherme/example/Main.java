package com.guilherme.example;

import com.guilherme.example.entities.Instrutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursosPU");
        EntityManager em = emf.createEntityManager();

        // Operações de persistência utilizando o EntityManager
        Instrutor instrutor = new Instrutor();
        instrutor.setNome("João Silva");
        instrutor.setEmail("joao.silva@example.com");
        instrutor.setBiografia("Especialista em Java e desenvolvimento web.");

        // Iniciando uma transação
        em.getTransaction().begin();

        // Persistindo a entidade
        em.persist(instrutor);

        // Confirmando a transação
        em.getTransaction().commit();


        // Criando uma nova instância da entidade Instrutor
        Instrutor instrutor2 = new Instrutor();
        instrutor2.setNome("João Silva");
        instrutor2.setEmail("joao.silva2@example.com");
        instrutor2.setBiografia("Especialista em Java e desenvolvimento web.");

        // Iniciando uma transação
        em.getTransaction().begin();

        // Persistindo a entidade
        em.persist(instrutor2);

        instrutor2.setEmail("silva.joao@example.com"); // Alterando o email do instrutor antes de confirmar a transação

        // Confirmando a transação
        em.getTransaction().commit();

        // Buscando uma entidade Instrutor pelo ID
        Instrutor instrutorEncontrado = em.find(Instrutor.class, 1L); // Substitua 1L pelo ID do instrutor que deseja buscar
        if (instrutorEncontrado != null) {
            System.out.println("Instrutor encontrado: " + instrutorEncontrado.getNome());
        } else {
            System.out.println("Instrutor não encontrado.");
        }


        /*
        // Suponha que você tenha uma entidade Instrutor desanexada (detached)
        Instrutor instrutorDetached = new Instrutor();
        instrutorDetached.setId(1L); // ID da entidade que você deseja atualizar
        instrutorDetached.setNome("Maria da Silva");
        instrutorDetached.setEmail("maria.silva@example.com");

        em.getTransaction().begin(); // Iniciando uma transação

        // Chamando merge() para atualizar a entidade
        Instrutor instrutorAtualizado = em.merge(instrutorDetached);

        em.getTransaction().commit(); // Confirmando a transação
        */


        em.getTransaction().begin(); // Iniciando uma transação

        // Buscando a entidade Instrutor que deseja remover
        Instrutor instrutorParaRemover = em.find(Instrutor.class, 1L);
        if (instrutorParaRemover != null) {
            // Removendo a entidade
            em.remove(instrutorParaRemover);
            System.out.println("Instrutor removido com sucesso.");
        } else {
            System.out.println("Instrutor não encontrado para remoção.");
        }

        em.getTransaction().commit(); // Confirmando a transação

        em.close();
        emf.close();
    }
}