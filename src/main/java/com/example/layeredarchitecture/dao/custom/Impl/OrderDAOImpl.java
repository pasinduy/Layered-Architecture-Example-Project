package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dto.OrderDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> load() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getNextID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", orderDTO.getOrderId(), Date.valueOf(orderDTO.getOrderDate()), orderDTO.getCustomerId());
    }

    @Override
    public boolean existRecord(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.test("SELECT oid FROM `Orders` WHERE oid=?", orderId);
        return resultSet.next();
    }
}
