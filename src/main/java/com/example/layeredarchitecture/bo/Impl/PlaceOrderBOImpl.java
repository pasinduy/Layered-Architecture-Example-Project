package com.example.layeredarchitecture.bo.Impl;

import com.example.layeredarchitecture.bo.PlaceOrderBO;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDetailDAOImpl;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import com.example.layeredarchitecture.util.TransactionUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    ItemDAO itemDAO = new ItemDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/
            //Check order id already exist or not
            boolean b1 = orderDAO.existRecord(orderId);
            /*if order id already exist*/
            if (b1) {
                return false;
            }

            TransactionUtil.setAutoCommit(false);

            //Save the Order to the order table
            boolean b2 = orderDAO.save(new OrderDTO(orderId, orderDate, customerId));

            if (!b2) {
                TransactionUtil.rollback();
                TransactionUtil.setAutoCommit(true);
                return false;
            }

            // add data to the Order Details table

            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = orderDetailDAO.save(detail);
                if (!b3) {
                    TransactionUtil.rollback();
                    TransactionUtil.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                boolean b = itemDAO.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    TransactionUtil.rollback();
                    TransactionUtil.setAutoCommit(true);
                    return false;
                }
            }

            TransactionUtil.commit();
            TransactionUtil.setAutoCommit(true);
            return true;
    }
    @Override
    public ItemDTO findItem(String itemCode) {
        try {
            return itemDAO.getItemData(itemCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.existRecord(id);
    }

    @Override
    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.existRecord(id);
    }

    @Override
    public ArrayList<String> loadItem() throws SQLException, ClassNotFoundException {
        return itemDAO.load();
    }

    @Override
    public ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.load();
    }

    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateOrderID();
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

}
