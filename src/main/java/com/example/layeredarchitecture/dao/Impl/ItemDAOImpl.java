package com.example.layeredarchitecture.dao.Impl;

import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.util.SQLUtil;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Item");

        ArrayList<ItemDTO> getAllItem = new ArrayList<>();

        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            getAllItem.add(itemDTO);
        }
        return getAllItem;
    }
    @Override
    public boolean addItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("UPDATE INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public boolean deleteItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("DELETE FROM Item WHERE code=?", itemDTO.getCode());
    }
    @Override
    public ArrayList<String> getItemIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Item");
        ArrayList<String> list = new ArrayList<>();
        while (rst.next()) {
            list.add(rst.getString("code"));
        }
        return list;
    }
    @Override
    public ItemDTO getItemData( String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.test("SELECT * FROM Item WHERE code=?", code);

        rst.next();
        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("SELECT code FROM Item WHERE code=?", code);
    }
    @Override
    public PreparedStatement UpdateOrder(Connection connection, ItemDTO item) throws SQLException, ClassNotFoundException {
        return SQLUtil.test("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(),item.getCode());
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        return false;
    }
}
