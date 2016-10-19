package com.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;
public class Dishtest {

	public static void main(String[] args) {
		List<Dish> dishlist=Arrays.asList(new Dish(100,"carrot"),
				new Dish(200,"tomato"),
				new Dish(100,"brinjal"),
				new Dish(300,"chicken"),
				new Dish(400,"meet"),
				new Dish(1000,"beef"));
		//to find low colorie dishes using java7
		List<Dish> lowColorieDishList = new ArrayList<>();
		for(Dish dish:  dishlist)
		{
			if(dish.getColories() < 400)
			{
				lowColorieDishList.add(dish);
			}
	}
		System.out.println("lowcolorieslist:" +lowColorieDishList);
		//sort the dishes using anonymous class
		Collections.sort(lowColorieDishList, new Comparator<Dish>(){

			@Override
			public int compare(Dish dish1, Dish dish2) {
				
				return Integer.compare(dish1.getColories(), dish2.getColories());
			}
			
		});
List<String> lowColoriesNamesList = new ArrayList<>();
		
		for(Dish dish : lowColorieDishList)
		{
			lowColoriesNamesList.add(dish.getName());
		}
		
		System.out.println("low colorie list names using java7" + lowColoriesNamesList);
		//using java8 and lambda
				List<String> lowColoriesJava8List = 
				dishlist.stream().filter((dish1) -> { System.out.println("name of dish having colories less than 400 " + dish1.getName());
					return dish1.getColories() <400;})
				                  /* .sorted((dish1, dish2) ->
				                    {  System.out.println("sorted dish " + dish1.getName());
				                    	return Integer.compare(dish1.getColories(), dish2.getColories()); })*/
				                   .map( (dish) -> {
				                	     System.out.println("mapped dish " + dish.getName());
				                	   return dish.getName();})
				                   .limit(3)
				                   .collect(toList());
				
				System.out.println("sorted low colorie dishes using java8 lambda" + lowColoriesJava8List);

				////using java8 and method references
				
				List<String> lowColoriesMethodRefList = 
						dishlist.stream().filter((dish1) -> dish1.getColories() <400)
						                   .sorted(comparing(Dish :: getColories))
						                   .map(Dish :: getName)
						                   .collect(toList());
				System.out.println("sorted low colorie dishes using java8 method reference" +lowColoriesMethodRefList);

}
}
