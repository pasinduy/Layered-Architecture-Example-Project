package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO{
    boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;
}
