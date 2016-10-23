package com.pocketmath.testing.question1;

public class Partition {
	
	private int[] intArray;

	public Partition() {}
	
	public Partition(int[] intArray) {
		this.intArray = intArray;
	}
	
	public int[] getIntArray() {
		return intArray;
	}

	public void setIntArray(int[] intArray) {
		this.intArray = intArray;
	}
	
	public void partitionEvenOdd() {
		if(isEmpty()) {
			return ;
		}
		
		int leftIndex = 0, rightIndex = intArray.length - 1;
		while(rightIndex >= leftIndex) {
			if(!isEven(intArray[leftIndex])) {
				if(isEven(intArray[rightIndex])) {
					swap(leftIndex, rightIndex);
				} else {
					rightIndex--;
				}
			} else {
				leftIndex++;
				if(!isEven(intArray[rightIndex])) {
					rightIndex--;
				}
			}
		}
	}
	
	private boolean isEven(int number) {
		return number % 2 == 0;
	}
	
	private void swap(int indexA, int indexB) {
		if(isEmpty() || indexA < 0 || indexB < 0 ||
				indexA >= intArray.length || 
				indexB >= intArray.length) {
			return ;
		}
		
		int temp = intArray[indexA];
		intArray[indexA] = intArray[indexB];
		intArray[indexB] = temp;
	}
	
	private boolean isEmpty() {
		return (intArray == null || intArray.length == 0);
	}
	
}
