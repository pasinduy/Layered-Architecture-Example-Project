package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    public boolean addItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean deleteItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public ArrayList<String> getItemIds() throws SQLException, ClassNotFoundException;

    public ItemDTO getItemData( String code) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    PreparedStatement UpdateOrder(Connection connection, ItemDTO item) throws SQLException, ClassNotFoundException;

    boolean update(ItemDTO itemDTO);
}
