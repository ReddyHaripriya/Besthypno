package com.java8.streams;

public class Transaction {
private Trader trader;
private int year;
private Integer value;
public Transaction(Trader trader, int year, int value) {
	this.trader=trader;
	this.year=year;
	this.value=value;
}
public Trader getTrader() {
	return trader;
}
public void setTrader(Trader trader) {
	this.trader = trader;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Integer getValue() {
	return value;
}
public void setValue(Integer value) {
	this.value = value;
}

public String toString() {
	return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
	}

}
