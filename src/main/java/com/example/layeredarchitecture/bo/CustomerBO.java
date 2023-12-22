package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public interface CustomerBO {
    boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
}
