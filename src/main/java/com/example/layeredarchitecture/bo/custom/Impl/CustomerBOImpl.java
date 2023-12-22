package com.example.layeredarchitecture.bo.custom.Impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean delete(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        ArrayList<Customer> customers = customerDAO.getAll();
        for (Customer customer : customers) {
            dtos.add(
                    new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress())
            );
        }
        return dtos;
    }

    @Override
    public boolean existRecord(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.existRecord(id);
    }
}
