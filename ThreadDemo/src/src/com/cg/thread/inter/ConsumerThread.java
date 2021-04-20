package com.cg.thread.inter;

public class ConsumerThread extends Thread{

	private CgQueue queue;

	public ConsumerThread(CgQueue queue) {
		super();
		this.queue = queue;
	}
	
	public void run() {
		for(int i=1; i<=5; ++i)
			queue.getData();
	}
	

}
