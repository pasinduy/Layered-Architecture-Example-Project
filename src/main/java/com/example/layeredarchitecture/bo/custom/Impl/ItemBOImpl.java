package com.example.layeredarchitecture.bo.custom.Impl;

import com.example.layeredarchitecture.bo.custom.ItemBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dto.ItemDTO;
import com.example.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand()));
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand()));
    }

    @Override
    public boolean delete(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(new Item(itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand()));
    }
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException{
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();

        for (Item item : items){
            itemDTOS.add(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return itemDTOS;
    }
}
