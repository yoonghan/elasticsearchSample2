package com.self.entity;

public class Beer {
	
	private String name;
	private String description;
	private int abv;
	
	public Beer(String name, String description, int abv){
		this.name = name;
		this.description = description;
		this.abv = abv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAbv() {
		return abv;
	}

	public void setAbv(int abv) {
		this.abv = abv;
	}
}
