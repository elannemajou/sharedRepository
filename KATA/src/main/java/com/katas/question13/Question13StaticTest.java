package com.katas.question13;


public class Question13StaticTest {
	
	public static void main(String[] args) {
		Runnable runnable1 = new Runnable(){
			public void run() {
				int id1 = ThreadId.get();
				System.out.println("Thread id is : " + id1);
			}
		};
		
		Runnable runnable2 = new Runnable(){
			public void run() {
				int id1 = ThreadIdWithoutThreadLocal.get();
				System.out.println("Thread id is : " + id1);
			}
		};
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable1);
		Thread thread3 = new Thread(runnable1);
		
		Thread thread4 = new Thread(runnable2);
		Thread thread5 = new Thread(runnable2);
		Thread thread6 = new Thread(runnable2);

		thread1.start();
		thread2.start();
		thread3.start();
		
		thread4.start();
		thread5.start();
		thread6.start();
	}
}
