package com.interview;

class Parent {
	public void message() {
		System.out.println("Hi , I am from parent :");
	}

	public void work() {
		System.out.println("Doing office work :");
	}
}

class Child extends Parent {
	@Override
	public void work() {
		System.out.println("Doing school work :");
	}
}

public class Test1 {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		Parent p2 = new Child();
		p.message();
		p.work();

		c.message();
		c.work();

		p2.work();
		p2.message();

	}
}
