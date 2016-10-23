package com.pocketmath.testing.question2;

public class SequentialThreadDemo {
	
	public static void main(String[] args) {
		Foo foo = new Foo();
		
		Thread threadA = new Thread(() -> {
			foo.first();
		});
		
		Thread threadB = new Thread(() -> {
			foo.second();
		});
		
		Thread threadC = new Thread(() -> {
			foo.third();
		});
		
		threadC.start();
		threadB.start();
		threadA.start();
	}
}	