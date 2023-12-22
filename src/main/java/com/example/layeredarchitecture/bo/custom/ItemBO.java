package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO{
    boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean delete(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
}
