package com.pocketmath.testing.question3;

import java.util.Stack;

public class MyQueue<T> implements Queue<T> {

	/*
	 *                            queue
	 *             ----------------------------------
	 *          <------                             <------
	 * 	 dequeue() ---------------------------------- enqueue()
	 *             front                       back
	 */
	
	// Back of queue
	private Stack<T> firstStack = new Stack<>(); 
	
	// Front of queue
	private Stack<T> secondStack = new Stack<>();
	
	@Override
	public void enqueue(T item) {
		firstStack.push(item);
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			return null;
		}
		
		/*
		 *  If there is no items of the front of the queue to dequeue, 
		 *  move all items of back to the front then.
		 */
        if(secondStack.isEmpty()) {
        	moveFirstStackToSecondStack();
        }
        return secondStack.pop();
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		
		/*
		 *  If there is no items of the front of the queue to dequeue, 
		 *  move all items of back to the front then.
		 */
		if(secondStack.isEmpty()) {
			moveFirstStackToSecondStack();
		}
		return secondStack.peek();
	}
	
	@Override
	public boolean isEmpty() {
		return firstStack.isEmpty() && secondStack.isEmpty();
	}

	@Override
	public int size() {
		return firstStack.size() + secondStack.size();
	}
	
	/*
	 * Move all items of the first stack to the second stack
	 */
	private void moveFirstStackToSecondStack() {
        while (!firstStack.isEmpty())
        	secondStack.push(firstStack.pop());
    }
}
