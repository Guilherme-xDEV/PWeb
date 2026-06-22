package com.guilherme.example.dao;
import com.guilherme.example.database.ConnectionFactory;

public class DAOFactory {
    public static DepartmentDAO createDepartmentDAO() {
        return new DepartmentDAOImpl(ConnectionFactory.getConnection());
    }

    public static SellerDAO createSellerDAO() {
        return new SellerDAOImpl(ConnectionFactory.getConnection());
    }
}