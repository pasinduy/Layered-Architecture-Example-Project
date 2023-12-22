package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dto.QueryDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<QueryDTO> customerOrderDetails() throws SQLException, ClassNotFoundException{
        ResultSet rst = SQLUtil.test("SELECT o.oid, o.customerID, c.name from customer c inner join orders o where c.id = o.customerID");
        ArrayList<QueryDTO> getAllCusOrders = new ArrayList<>();
        while (rst.next()){
            getAllCusOrders.add(
                new QueryDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3)
                )
            );
        }
        System.out.println(getAllCusOrders);
        return getAllCusOrders;
    }
}
