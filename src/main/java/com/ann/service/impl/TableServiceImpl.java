package com.ann.service.impl;

import com.ann.dao.impl.TableDaoImpl;
import com.ann.service.TableService;

import java.io.IOException;
import java.sql.SQLException;

public class TableServiceImpl implements TableService {
    TableDaoImpl tableDao = new TableDaoImpl();

    @Override
    public String getData(String row, String col) throws SQLException, IOException {
        return tableDao.selectData(row, col);
    }
}
