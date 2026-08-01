package com.guilherme.example.entrega4.models;

public class Usuario {
    private Long id;
    private String nome;
    private String email;

    public Usuario(Long id, String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
