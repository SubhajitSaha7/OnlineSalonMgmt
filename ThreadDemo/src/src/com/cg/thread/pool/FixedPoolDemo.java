package src.com.cg.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPoolDemo {

	public static void main(String[] args) {
		SifyRunnable r1 = new SifyRunnable("ram");
		SifyRunnable r2 = new SifyRunnable("tom");
		SifyRunnable r3 = new SifyRunnable("sam");
		SifyRunnable r4 = new SifyRunnable("peter");
		SifyRunnable r5 = new SifyRunnable("john");
		SifyRunnable r6 = new SifyRunnable("vinay");
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
				
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r6);
		pool.shutdown();
		
	}

}