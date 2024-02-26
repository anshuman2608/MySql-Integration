package com.example.mysqlTest.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseMetadataService {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<String> getDatabases() {
        return jdbcTemplate.queryForList("SHOW DATABASES", String.class);
    }

    public List<String> getTables(String databaseName) {
        System.out.println("in amcalling tables inside database");
        return jdbcTemplate.queryForList("SHOW TABLES IN " + databaseName, String.class);
    }

    public List<Map<String, Object>> getTableContents(String databaseName, String tableName) {
        return jdbcTemplate.queryForList("SELECT * FROM " + databaseName + "." + tableName);
    }


//    public List<String> getAllDataBases(){
//        Query query = entityManager.createNativeQuery("SHOW DATABASES");
//        List<String> databaseNames=query.getResultList();
//        return databaseNames;
//    }
//    public List<String> getAllTableNames() {
//        Query query = entityManager.createNativeQuery("SHOW TABLES");
//        List<String> tableNames = query.getResultList();
//        return tableNames;
//    }
//
//    //for getting table contents
//    public List<List<Object>> getTableContents(String tableName) {
//        Query query = entityManager.createNativeQuery("SELECT * FROM " + tableName);
//        List<Object[]> resultList = query.getResultList();
//        List<List<Object>> tableContents = new ArrayList<>();
//        for (Object[] row : resultList) {
//            List<Object> rowData = new ArrayList<>();
//            for (Object value : row) {
//                rowData.add(value);
//            }
//            tableContents.add(rowData);
//        }
//        return tableContents;
//    }
//
//    // Service methods for each table
//    public List<List<Object>> getProductsContents() {
//        return getTableContents("products");
//    }



}
