package io.objectstream;

import java.io.Serializable;

//*********직렬화*********** -> 객체가 통으로 가상통로를 넘어가기 위해서는 한 줄로 세워야 함 이게 직렬화
// Serializable -> 직렬화

public class Record implements Serializable {
	private String name;
	private int age;
	private double height;
	private char bloodType;
	
	//1번 방법 getter setter
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getBloodType() {
		return bloodType;
	}
	public void setBloodType(char bloodType) {
		this.bloodType = bloodType;
	}
	
	//2번 방법 생성자 함수
	
	public Record() {}  //******기본 생성자는 필수로 만들기******
	
	public Record(String name, int age, double height, char bloodType) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.bloodType = bloodType;
	}
	
	
	
	
}
