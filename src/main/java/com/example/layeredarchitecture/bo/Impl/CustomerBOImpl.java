package com.example.layeredarchitecture.bo.Impl;

import com.example.layeredarchitecture.bo.CustomerBO;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.save(customerDTO);
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }

    @Override
    public boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(customerDTO);
    }
}
