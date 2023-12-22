package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public interface ItemBO extends SuperBO{
    boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean delete(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
}