package com.katas.question13;

import org.junit.Test;

public class ThreadIdTest {

	@Test
	public void test() {
		Runnable runnable1 = new Runnable(){
			public void run() {
				int id1 = ThreadId.get();
				System.out.println("Thread id is : " + id1);
			}
		};
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable1);

		thread1.start();
		thread2.start();
	}
}