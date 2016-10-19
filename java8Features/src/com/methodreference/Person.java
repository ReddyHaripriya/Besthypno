package com.methodreference;

public class Person {
	public enum Sex{
		MALE, FEMALE
		
	}
	private String name;
	private Sex gender;
	private Integer age;
	
	
	public Person(Sex gender, String name, Integer age)
	{
		this.gender = gender;
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public static int compareByAge(Person p1, Person p2)
	{
		return p2.getAge().compareTo(p1.getAge());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

}