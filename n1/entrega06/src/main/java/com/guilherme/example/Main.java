package com.guilherme.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.guilherme.example.dao.DAOFactory;
import com.guilherme.example.dao.DepartmentDAO;
import com.guilherme.example.dao.SellerDAO;
import com.guilherme.example.entities.Department;
import com.guilherme.example.entities.Seller;

public class Main {
    public static void main(String[] args) {

        System.out.println("Exemplo de Criação de Objeto Seller Com Department Especifico\n");
        Department d1 = new Department(1, "Vendas");
        Seller s1 = new Seller(1, "João Silva", "joao.silva@email.com", LocalDate.of(1990, 2, 1), 10000.0, d1);

        System.out.println("Departamento: " + s1.getDepartment().getName());
        System.out.printf("Vendedor: %s, Email: %s%nData de Nascimento: %s, Salário Base: %.2f \n", s1.getName(), s1.getEmail(), s1.getBirthDate(), s1.getBaseSalary());

        String url = "jdbc:postgresql://localhost:5432/pratica06";
        String usuario = "postgres";
        String senha = "postgres";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("\nConectado ao Banco!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace();
        }


        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();

        // Teste de inserção de departamento
        // Passamos null para o ID, pois ele será gerado automaticamente pelo banco de
        // dados
        Department newDepartment = new Department(null, "Marketing");
        departmentDAO.insert(newDepartment);

        // Teste de consulta de departamentos
        List<Department> departments = departmentDAO.findAll();

        System.out.println("Departamentos encontrados:");
        for (Department dept : departments) {
            System.out.println(dept.getId() + ": " + dept.getName());
        }

        // Teste de inserção de vendedor
        Seller newSeller = new Seller(null, "Maria Oliveira", "maria.oliveira@example.com",
                LocalDate.parse("1990-05-15"), 5000.0, departments.getLast()); // Associando o vendedor ao último departamento inserido (Marketing)
        sellerDAO.insert(newSeller);

        // Teste de consulta de vendedores
        List<Seller> sellers = sellerDAO.findAll();

        System.out.println("Vendedores encontrados:");
        for (Seller seller : sellers) {
            System.out.println(seller.getId() + ": " + seller.getName());
        }
    }
}