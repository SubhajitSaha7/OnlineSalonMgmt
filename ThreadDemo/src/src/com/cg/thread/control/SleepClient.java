package com.cg.thread.control;

public class SleepClient {
    public static long total;
    
	public static void main(String[] args) {
		AvgThread t1 = new AvgThread();
		SumThread t2 = new SumThread();
		t1.start();
		t2.start();
		

	}

}
