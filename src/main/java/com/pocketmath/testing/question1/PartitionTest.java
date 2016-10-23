package com.pocketmath.testing.question1;

import java.util.Arrays;

public class PartitionTest {

	public static final int[] TEST_DATA = { 2, 4, 7, 6, 1, 3, 5, 4 };
	
	public static void main(String[] args) {
		Partition partition = new Partition(TEST_DATA);
		System.out.println("Input:  " + Arrays.toString(partition.getIntArray()));
		partition.partitionEvenOdd();
		System.out.println("Output: " + Arrays.toString(partition.getIntArray()));
	}
}
