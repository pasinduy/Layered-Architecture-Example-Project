package com.example.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T>{
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(T t) throws SQLException, ClassNotFoundException;

    public boolean update(T t) throws SQLException, ClassNotFoundException;

    public boolean delete(T t) throws SQLException, ClassNotFoundException;

    public boolean existRecord(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<String> load() throws SQLException, ClassNotFoundException;
}
