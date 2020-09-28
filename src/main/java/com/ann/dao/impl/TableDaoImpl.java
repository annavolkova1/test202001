package com.ann.dao.impl;

import com.ann.connection.ConnectionManager;
import com.ann.dao.TableDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableDaoImpl implements TableDao {

    @Override
    public String selectData(String col, String row) throws SQLException, IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("Select " + row + " as row," + col + " as col, COUNT() as val from source_data group by " + row + " order by " + col);
                ResultSet resultSet = pr.executeQuery();
                while (resultSet.next()) {
                    ObjectNode record = mapper.createObjectNode();
                    record.put("val", resultSet.getString("val"));
                    record.put("col", resultSet.getString("col"));
                    record.put("row", resultSet.getString("row"));
                    arrayNode.add(record);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
    }
}
