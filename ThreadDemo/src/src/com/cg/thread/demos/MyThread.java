package com.cg.thread.demos;

public class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=1; i<=2000; ++i)
			System.out.println(Thread.currentThread().getName() + (i*5));
		System.out.println(Thread.currentThread().getName()+ " completes");
	}

}
