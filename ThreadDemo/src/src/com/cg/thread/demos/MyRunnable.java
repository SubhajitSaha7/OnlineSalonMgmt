package com.cg.thread.demos;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=3000; ++i)
			System.out.println(Thread.currentThread().getName() + " " + i*5);
		System.out.println(Thread.currentThread().getName() + "completes");
	}

}
