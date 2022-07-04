package com.db2restapi.SpringBootDB2.model;

public class jdbcModel {
	  private Long id;
	  private String name;
	  public jdbcModel(){
	  }
	  public jdbcModel(long id, String name){
	    this.id = id;
	    this.name = name;
	  }
	  @Override
	  public String toString() {
	    return String.format("Things[id=%d, name='%s']", id, name);
	  }
	}