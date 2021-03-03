package com.company.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    public Connection con() throws SQLException, ClassNotFoundException; // создаем интерфейс и его метод для DB, можно было обойтись без него,но мы показываем что умеем работать с interface ;)  
}
