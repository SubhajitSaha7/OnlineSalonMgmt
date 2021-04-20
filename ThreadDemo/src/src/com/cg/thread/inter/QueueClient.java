package com.cg.thread.inter;

public class QueueClient {

	public static void main(String[] args) {
		CgQueue queue = new CgQueue();
		ProducerThread t1 = new ProducerThread(queue);
		ConsumerThread t2 = new ConsumerThread(queue);
		
		t1.start();
		t2.start();
		

	}

}
