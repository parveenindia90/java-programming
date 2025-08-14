package com.test;

public class InheritanceTest {
	
	public static void main(String args[]) {
		TestInheritance test = new TestIn();
		test.show();

	}

}

class TestIn extends TestInheritance{
	public void show() {
		System.out.println("In Child");
	}
}

class TestInheritance{
	public void show() {
		System.out.println("In Parent");
	}
}