package com.cg.thread.control;

public class SumThread extends Thread{

	@Override
	public void run() {
		long sum =0;
		for(int i=1 ; i<=20000;++i)
			sum = sum + i * i;
		SleepClient.total= sum;
	}

	
	
}
