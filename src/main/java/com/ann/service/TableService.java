package com.ann.service;

import java.io.IOException;
import java.sql.SQLException;

public interface TableService {
    String getData(String row, String col) throws SQLException, IOException;
}
