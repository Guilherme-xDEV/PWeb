package com.guilherme.example.entrega4.service;

import java.util.ArrayList;
import java.util.List;

import com.guilherme.example.entrega4.models.Usuario;

public class UsuarioService {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static Long proximoId = 1L;

    public void cadastrar(String nome, String email) {

        validar(nome, email);

        Usuario usuario = new Usuario();
        usuario.setId(proximoId++);
        usuario.setNome(nome.trim());
        usuario.setEmail(email.trim());

        usuarios.add(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    private void validar(String nome, String email) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email é obrigatório.");
        }

        boolean emailExiste = usuarios.stream()
                .anyMatch(u ->
                        u.getEmail().equalsIgnoreCase(email.trim()));

        if (emailExiste) {
            throw new IllegalArgumentException(
                    "Já existe um usuário cadastrado com este email.");
        }
    }
}