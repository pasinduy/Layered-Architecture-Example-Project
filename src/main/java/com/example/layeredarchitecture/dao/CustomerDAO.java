package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public void deleteCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException;
}
