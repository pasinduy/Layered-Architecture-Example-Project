package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Customer");

        ArrayList<Customer> getAllCustomer=new ArrayList<>();

        while (rst.next()){
            Customer entity = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            getAllCustomer.add(entity);
        }
        return getAllCustomer;
    }

    @Override
    public boolean save(Customer customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public boolean update(Customer customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("UPDATE INTO Customer (id,name, address) VALUES (?,?,?)", customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }

    @Override
    public boolean delete(Customer customerDTO) throws SQLException, ClassNotFoundException {
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

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Customer WHERE id=?",id+" ");
        rst.next();
        Customer customerDTO = new Customer(id + "", rst.getString("name"), rst.getString("address"));
        return  customerDTO;
    }

    @Override
    public String getNextID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString(1);
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }
}
