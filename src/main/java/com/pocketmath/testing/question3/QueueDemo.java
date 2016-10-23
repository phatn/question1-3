package com.pocketmath.testing.question3;

public class QueueDemo {

	public static final String[] TEST_DATA = {"Implement", "a", "MyQueue", 
			"class", "which", "implements", "a", "queue", "using", "two", "stacks"};
	
	public static void main(String[] args) {
		MyQueue<String> myQueue = new MyQueue<>();
		
		// Enqueue data into myQueue
		for(int i = 0; i < TEST_DATA.length; i++) {
			myQueue.enqueue(TEST_DATA[i]);
		}
		
		// Get the first item of queue
		System.out.println(myQueue.peek());
		
		// Dequeue
		while(!myQueue.isEmpty()) {
			System.out.print(myQueue.dequeue() + " ");
		}
		
		// Check if myQueue is empty or not
		System.out.println("\nIs myQueue empty? " + myQueue.isEmpty());
	}
}
