package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.Impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.Impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.Impl.PlaceOrderBOImpl;
import com.example.layeredarchitecture.bo.custom.SuperBO;
import com.example.layeredarchitecture.dao.custom.Impl.OrderDAOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory(){{return boFactory == null? boFactory = new BOFactory() : boFactory;}
    }

    public enum BOTypes{
        CUSTOMER, ITEM, PlaceOrder
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PlaceOrder:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
