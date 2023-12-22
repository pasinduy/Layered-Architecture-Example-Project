package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.QueryDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<QueryDTO> customerOrderDetails() throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT o.oid, o.customerID, c.name from customer c inner join orders o where c.id = o.customerID");
        ArrayList<QueryDTO> getAllCusOrders = new ArrayList<>();
        while (rst.next()){
            QueryDTO queryDTO = new QueryDTO(
                    rst.getString("Order ID"),
                    rst.getString("Customer ID"),
                    rst.getString("Customer Name")
            );
            getAllCusOrders.add(queryDTO);
        }
        return getAllCusOrders;
    }
}
