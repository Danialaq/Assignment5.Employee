package com.company.data;

import com.company.data.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements IDB{ //подключаем интерфейс 
    @Override
    public Connection con() throws SQLException, ClassNotFoundException { // пользуемся методом из IDB
        String url = "jdbc:postgresql://localhost:5432/danial"; // пишем какую базу данных будем использовать из сервера
        try {
            Class.forName("org.postgresql.Driver");  
            Connection y = DriverManager.getConnection(url, "postgres", "0000");  // коннэктим IntelliG с pgAdmin знакомым нам способом, используя DriverManager и его методом getConnection,обязательно прописываем его пакет
            return y;
        } catch (Exception e){
            System.out.println("No connection!"); // я не прописывал какие имена ошибки ловить ему, не видел в этом необходимости
            return null;
        }
    }
}
