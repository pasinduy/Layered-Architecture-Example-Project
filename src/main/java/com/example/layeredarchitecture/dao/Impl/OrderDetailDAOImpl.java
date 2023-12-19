package com.example.layeredarchitecture.dao.Impl;

import com.example.layeredarchitecture.dao.OrderDetailDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", dto.getOid(), dto.getItemCode(), dto.getUnitPrice(), dto.getQty());
    }

    @Override
    public boolean update(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean existRecord(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<String> load() throws SQLException, ClassNotFoundException {
        return null;
    }
}
