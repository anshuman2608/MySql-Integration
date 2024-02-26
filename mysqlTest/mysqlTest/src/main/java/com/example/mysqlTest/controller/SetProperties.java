package com.example.mysqlTest.controller;

import com.example.mysqlTest.entity.PropertyUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


@RestController
@CrossOrigin("*")
public class SetProperties {


    @Autowired
    private Environment environment;

    @PostMapping("/update-properties")
    public String updateProperties(@RequestBody PropertyUpdateRequest request) {
        try {
            Properties props = new Properties();
            props.setProperty("spring.datasource.url", "jdbc:mysql://" + request.getHost() + ":" + request.getPort() + "");
            props.setProperty("spring.datasource.username", request.getUsername());
            props.setProperty("spring.datasource.password", request.getPassword());

            // Update other properties as needed

            String path = environment.getProperty("user.dir") + "/src/main/resources/application.properties";
            props.store(new FileOutputStream(path), null);
            return "Properties updated successfully.";
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Failed to update properties.";
        }
    }
}
