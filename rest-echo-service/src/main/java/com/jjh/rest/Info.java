package com.jjh.rest;

public class Info {
    
    private String name;
    private String date;
    
    /**
     * Requires Zero param constructor for conversion to JSON
     */
    public Info() { }

	public Info(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("Info [name=%s, date=%s]", name, date);
	}

}
