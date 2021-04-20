package com.cg.thread.demos;

public class RunnableClient {

	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1);
		t1.setName("ram");
		Thread t2 = new Thread(r1);
		t2.setName("tom");
		
		t1.start();
		t2.start();
		System.out.println("main thread completes");
		

	}

}
