package com.ann.controller;

import com.ann.service.impl.TableServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class Controller {
    TableServiceImpl tableService = new TableServiceImpl();

    @GetMapping("/")
    public String helloPage(@RequestParam("row") String row,
                            @RequestParam("col") String col) throws SQLException, IOException {
        return tableService.getData(row, col);
    }


}


