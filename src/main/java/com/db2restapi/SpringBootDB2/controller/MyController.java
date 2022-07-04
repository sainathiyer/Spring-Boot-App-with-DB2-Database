package com.db2restapi.SpringBootDB2.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.db2restapi.SpringBootDB2.model.jdbcModel;

@RestController
public class MyController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping(path = "/welcome")
	public String welcome() {
		return "Welcome to Spring Boot App";
	}
	
	@RequestMapping("test")
    public @ResponseBody ResponseEntity<String> example() {
        List<String> list = new ArrayList<>();
        list.add("Table data...");
        jdbcTemplate.query(
                "SELECT * FROM SAMPLE.THINGS", new Object[]{},
                (rs,rowNum) -> new jdbcModel(rs.getLong("id"), rs.getString("name")))
                .forEach(thing -> list.add(thing.toString()));
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
	}
}
