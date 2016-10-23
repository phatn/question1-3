package com.pocketmath.testing.question2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Foo {
	
	private Semaphore runFirstLock = new Semaphore(1);
	
	private Semaphore runSecondLock = new Semaphore(1);
	
	public Foo() {
		
		/*
		 * Must acquire two semaphores in constructor to make 
		 * sure only first() method can be executed first.
		 */
		
		try {
			runFirstLock.acquire();
			runSecondLock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void first() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("first() is called");
			
			// Release the runFirstLock after finishing its works
			runFirstLock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void second() {
		try {
			
			// Acquire the runFirstLock to make sure it can be executed after first()
			runFirstLock.acquire();
			runFirstLock.release();
			
			TimeUnit.SECONDS.sleep(1);
			System.out.println("second() is called");
			
			runSecondLock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void third() {
		try {
			
			// Acquire the runSecondLock to make sure it can be executed after second()
			runSecondLock.acquire();
			TimeUnit.SECONDS.sleep(1);
			
			System.out.println("third() is called");
			
			runSecondLock.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
