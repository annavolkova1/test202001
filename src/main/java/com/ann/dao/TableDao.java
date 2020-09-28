package com.ann.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface TableDao {
    String selectData(String col, String row) throws SQLException, IOException;
}
