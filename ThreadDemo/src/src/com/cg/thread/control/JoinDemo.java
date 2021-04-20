package com.cg.thread.control;

import com.cg.thread.demos.MyThread;

public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		t1.setName("ram");
		MyThread t2 = new MyThread();
		t2.setName("sam");
		t1.start();
		t1.join();//blocks other threads until it completes
		t2.start();
		
				
		
		for(int i=1; i<=2000; ++i)
			System.out.println(Thread.currentThread().getName() + " " + i*5);
		

	}

}
