package com.example.layeredarchitecture.dao.custom.Impl;

import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    /*@Override
    public PreparedStatement UpdateOrder(Connection connection, ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(),item.getCode());
    }*/
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Item");

        ArrayList<Item> getAllItem = new ArrayList<>();

        while (rst.next()){
            Item entity = new Item(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            getAllItem.add(entity);
        }
        return getAllItem;
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("UPDATE INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", entity.getCode(),entity.getDescription(),entity.getUnitPrice(),entity.getQtyOnHand());
    }

    @Override
    public boolean delete(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("DELETE FROM Item WHERE code=?", entity.getCode());
    }

    @Override
    public boolean existRecord(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.test("SELECT code FROM Item WHERE code=?", code);
        return resultSet.next();
    }

    @Override
    public ArrayList<String> load() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Item");
        ArrayList<String> list = new ArrayList<>();
        while (rst.next()) {
            list.add(rst.getString("code"));
        }
        return list;
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Item WHERE code=?",id);
        rst.next();
        return new Item(id, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }

    @Override
    public String getNextID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
