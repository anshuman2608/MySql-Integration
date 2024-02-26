package com.example.mysqlTest.controller;

import com.example.mysqlTest.entity.PropertyUpdateRequest;
import com.example.mysqlTest.service.DatabaseMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class TableController {

    @Autowired
    private DatabaseMetadataService databaseMetadataService;


   @Autowired
   SetProperties setProperties;



    //all of the below controller is done using JDBCTemplate by directly interacting using sql querry

    //controller to get all database present inside a instance
    @PostMapping("/db")
    public List<String> getdb(@RequestBody PropertyUpdateRequest request){
        setProperties.updateProperties(request);
        return databaseMetadataService.getDatabases();

    }

    //controller to get all tables present inside a particular database
    @GetMapping("db/{databaseName}")
    public List<String> getTables(@PathVariable String databaseName) {
        return databaseMetadataService.getTables(databaseName);
    }

    @GetMapping("db/{databaseName}/{tableName}")
    public List<Map<String, Object>> getTableContents(@PathVariable String databaseName, @PathVariable String tableName) {
        return databaseMetadataService.getTableContents(databaseName, tableName);
    }








    //all of the below controller done by using entityManager by using native query

//    @GetMapping("/databases")
//    public List<String> getAllDatabases(){
//        return databaseMetadataService.getAllDataBases();
//    }
//
//    @GetMapping("/tables")
//    public List<String> getAllTables() {
//        return databaseMetadataService.getAllTableNames();
//    }
//
//    @GetMapping("/tables/{tableName}")
//    public List<List<Object>> getTableContents(@PathVariable String tableName) {
//
//        return databaseMetadataService.getTableContents(tableName);
//    }
}
