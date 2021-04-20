package com.cg.thread.control;

public class AvgThread extends Thread{

	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("average = " +SleepClient.total/1000);
	}
	
}
