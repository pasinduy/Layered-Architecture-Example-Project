package com.example.layeredarchitecture.dao.Impl;

import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Customer");

        ArrayList<CustomerDTO> getAllCustomer=new ArrayList<>();

        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("UPDATE INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public boolean delete(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("DELETE FROM Customer WHERE id=?", customerDTO.getId());
    }

    @Override
    public boolean existRecord(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.test("SELECT id FROM Customer WHERE id=?", id);
        return resultSet.next();
    }

    @Override
    public ArrayList<String> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Customer");
        ArrayList<String > list =  new ArrayList<>();
        while (rst.next()){
            list.add(
                    rst.getString(1)
            );
        }
        return list;
    }
}
