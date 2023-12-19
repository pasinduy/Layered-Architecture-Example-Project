package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO>{
    /*boolean saveOrderDetails(OrderDetailDTO detail) throws SQLException, ClassNotFoundException;*/
}
