package com.cg.thread.inter;

public class ProducerThread extends Thread{

	private CgQueue queue;

	public ProducerThread(CgQueue queue) {
		super();
		this.queue = queue;
	}
	
	public void run() {
		for(int i=1; i<=5; ++i)
			queue.putData();
	}
}
