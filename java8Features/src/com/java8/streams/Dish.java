package com.java8.streams;

public class Dish {
private int colories;
private String name;
public Dish(int colories, String name) {
	this.colories=colories;
	this.name=name;
	
}
public int getColories() {
	return colories;
}
public void setColories(int calories) {
	this.colories = colories;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Dish [colories=" + colories + ", name=" + name + "]";
}

}
