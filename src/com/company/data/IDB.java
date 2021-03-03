package com.company.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    public Connection con() throws SQLException, ClassNotFoundException;
}
