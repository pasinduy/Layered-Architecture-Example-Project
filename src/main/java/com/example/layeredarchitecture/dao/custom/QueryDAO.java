package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.dto.QueryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<QueryDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
