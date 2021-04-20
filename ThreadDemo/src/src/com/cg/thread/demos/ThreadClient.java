package com.cg.thread.demos;

public class ThreadClient {

	public static void main(String[] args) {
		System.out.println("main thread");
		MyThread t1 = new MyThread();
		t1.setName("ram");
		MyThread t2 = new MyThread();
		t2.setName("tom");

		t1.start();
		t2.start();

		for (int i = 1; i <= 1000; ++i)
			System.out.println(Thread.currentThread().getName() + " " + i * 5);

		System.out.println("main thread completes");
	}

}
