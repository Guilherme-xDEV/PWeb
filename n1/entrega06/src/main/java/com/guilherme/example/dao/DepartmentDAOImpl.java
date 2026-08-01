package com.guilherme.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.guilherme.example.entities.Department;

public class DepartmentDAOImpl implements DepartmentDAO {

    private Connection conn;

    public DepartmentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM department")) {

            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));

                departments.add(department);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar departamentos:");
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public Department findById(Integer id) {

        String sql = "SELECT * FROM department WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    Department department = new Department();

                    department.setId(rs.getInt("id"));
                    department.setName(rs.getString("name"));

                    return department;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar departamento por ID:");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(Department department) {

        String sql = "INSERT INTO department (name) VALUES (?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, department.getName());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Departamento inserido com sucesso!");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir departamento:");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {

        String sql = "UPDATE department SET name = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, department.getName());
            pstmt.setInt(2, department.getId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Departamento atualizado com sucesso!");
            } else {
                System.out.println("Nenhum departamento encontrado para atualização.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar departamento:");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {

        String sql = "DELETE FROM department WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Departamento removido com sucesso!");
            } else {
                System.out.println("Nenhum departamento encontrado para exclusão.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao excluir departamento:");
            e.printStackTrace();
        }
    }
}