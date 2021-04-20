package com.cg.thread.control;

import com.cg.thread.demos.MyThread;

public class PriorityDemo {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("ram");
		t1.setPriority(Thread.MAX_PRIORITY);
		MyThread t2 = new MyThread();
		t2.setName("tom");
		t2.setPriority(Thread.MIN_PRIORITY);
		
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
		t1.start();
		t2.start();
		
		for(int i=1; i<=1000; ++i)
			System.out.println(Thread.currentThread().getName() + " " + i*5);

	}

}
