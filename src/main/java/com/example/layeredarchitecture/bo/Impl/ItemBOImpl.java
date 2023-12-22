package com.example.layeredarchitecture.bo.Impl;

import com.example.layeredarchitecture.bo.ItemBO;
import com.example.layeredarchitecture.dao.custom.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = new ItemDAOImpl();
    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(itemDTO);
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(itemDTO);
    }

    @Override
    public boolean delete(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(itemDTO);
    }
}
