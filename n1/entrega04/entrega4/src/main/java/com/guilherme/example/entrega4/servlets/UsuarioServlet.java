package com.guilherme.example.entrega4.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.guilherme.example.entrega4.service.UsuarioService;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {

    private final UsuarioService service = new UsuarioService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "usuarios",
                service.listarTodos());

        request.getRequestDispatcher("/listar.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        try {

            service.cadastrar(nome, email);

            request.setAttribute(
                    "usuarios",
                    service.listarTodos());

            response.setStatus(HttpServletResponse.SC_CREATED);

            request.getRequestDispatcher("/listar.jsp")
                    .forward(request, response);

        } catch (IllegalArgumentException e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            request.setAttribute(
                    "mensagemErro",
                    e.getMessage());

            request.getRequestDispatcher("/erro.jsp")
                    .forward(request, response);
        }
    }
}