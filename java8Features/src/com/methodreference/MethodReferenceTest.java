package com.methodreference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.methodreference.Person.Sex;

public class MethodReferenceTest {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList( new Person(Sex.MALE, "Sam", 20),
				 new Person(Sex.MALE, "Sam", 20),
				 new Person(Sex.MALE, "John", 30),
				 new Person(Sex.FEMALE, "Sita", 16),
				 new Person(Sex.FEMALE, "Gita", 20),
				 new Person(Sex.MALE, "Ravi", 50),
				 new Person(Sex.MALE, "shyam", 10),
				 new Person(Sex.MALE, "Steve", 80),
				 new Person(Sex.FEMALE, "bunny", 2),
				 new Person(Sex.FEMALE, "rita", 20)			
				
				);
		
		System.out.println(personList);
		
		//using java 7
		
		personList.sort( new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return p2.getAge().compareTo(p1.getAge());
			}
		});
		
		System.out.println("java 7 sort " + personList);
		// using java 8 compare by age 
		
		personList.sort((Person a, Person b) -> Person.compareByAge(b, a));
		System.out.println("java 7 sort using lambda " + personList);
		
		
		//java8 sorting using method reference
		personList.sort(Person :: compareByAge);
		
		System.out.println("java 8 sort by method reference " + personList);
	}
}