package com.java8.features;

import java.util.ArrayList;
import java.util.List;

public class Applefilterusingjava7 {
public static List<Apple> filterApples(List<Apple> applelist,String color){
	
	List<Apple> redAppleList=new ArrayList<>();
	for(Apple apple:applelist){
		if("red".equals(apple.getColor())){
			redAppleList.add(apple);
		}
	}
	
	return applelist;
	}
public static List<Apple> filterApples(List<Apple> applelist){
	
	List<Apple> heavyAppleList=new ArrayList<>();
	for(Apple apple:applelist){
		if(apple.getWeight()>200.0){
			heavyAppleList.add(apple);
		}
	}
	
	return applelist;
	}
}
