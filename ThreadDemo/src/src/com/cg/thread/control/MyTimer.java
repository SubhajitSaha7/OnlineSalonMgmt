package com.cg.thread.control;

import java.time.LocalDateTime;

public class MyTimer extends Thread{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			// actual code for generating a report
			System.out.println("report genered at  " + LocalDateTime.now());
		}
	}
	
}
