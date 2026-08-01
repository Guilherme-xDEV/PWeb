package com.guilherme.example.demo.servlets;

import java.io.IOException;

import com.guilherme.example.demo.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse resp)
        throws ServletException, IOException {
            
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username, password);

        req.setAttribute("user", user);

        if ("admin".equals(username) &&
            "admin123".equals(password)) {
                
            req.getRequestDispatcher(
                "/q1/welcome.jsp"
            ).forward(req, resp);
            return;

        }

        req.setAttribute("error", "Login failed. Please try again.");
        req.getRequestDispatcher("/q1/login.jsp").forward(req, resp);

    }    
}

//http://localhost:8080/demo/q1/login.jsp