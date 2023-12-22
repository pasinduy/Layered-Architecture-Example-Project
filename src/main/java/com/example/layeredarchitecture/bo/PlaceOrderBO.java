package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String itemCode);
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean existItem(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> loadCustomer() throws SQLException, ClassNotFoundException;
    ArrayList<String> loadItem() throws SQLException, ClassNotFoundException;
    String generateOrderID() throws SQLException, ClassNotFoundException;
    CustomerDTO searchCustomer(String id)throws SQLException, ClassNotFoundException;
}
