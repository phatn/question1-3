package com.pocketmath.testing.question3;

public interface Queue<T> {
	
	// Insert an item at the back of the queue
	void enqueue(T item);
	
	// Remove and return the first element of the queue (null if empty)
	T dequeue();
	
	// Return the first item of the queue (null if empty), but do not remove it
	T peek();
	
	// Check if the queue is empty or not
	boolean isEmpty();
	
	// Return the number of items in the queue
	int size();
}
