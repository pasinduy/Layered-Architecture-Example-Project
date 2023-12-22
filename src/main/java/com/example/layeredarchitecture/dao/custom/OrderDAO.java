package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dto.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    String generateOrderID() throws SQLException, ClassNotFoundException;
}
