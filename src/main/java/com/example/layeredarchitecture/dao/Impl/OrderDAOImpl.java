package com.example.layeredarchitecture.dao.Impl;

import com.example.layeredarchitecture.dao.OrderDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean existsOrder(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.test("SELECT oid FROM `Orders` WHERE oid=?", orderId);
        return resultSet.next();
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", dto.getOrderId(), Date.valueOf(dto.getOrderDate()), dto.getCustomerId());
    }
}
