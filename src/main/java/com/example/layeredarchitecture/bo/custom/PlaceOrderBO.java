package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.dto.CustomerDTO;
import com.example.layeredarchitecture.dto.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO extends SuperBO{
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    Item findItem(String itemCode);
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean existItem(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadItem() throws SQLException, ClassNotFoundException;
    String generateOrderID() throws SQLException, ClassNotFoundException;
    CustomerDTO searchCustomer(String id)throws SQLException, ClassNotFoundException;
}
