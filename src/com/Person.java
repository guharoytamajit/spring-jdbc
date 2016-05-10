package com;

public class Person {

String name;
Integer age;
String location;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", location=" + location
			+ "]";
}
public Person() {
	super();
}
public Person(String name, Integer age, String location) {
	super();
	this.name = name;
	this.age = age;
	this.location = location;
}


}
