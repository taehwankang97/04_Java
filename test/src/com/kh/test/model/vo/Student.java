package com.kh.test.model.vo;

public class Student extends Students {

	private String name;
	private int score;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public int getScore() {
		return score;
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;

	}

	Students[] StudentArr = new Students[3];

	@Override
	public String toString() {

		System.out.printf(name + "학생의 점수는 : " + score + "점");
		return super.toString();

	}
}