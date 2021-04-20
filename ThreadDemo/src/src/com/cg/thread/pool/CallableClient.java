package src.com.cg.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClient {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable obj = new MyCallable();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<Integer> future = pool.submit(obj);//Async -->Non blocking
		for(int i=1; i<=5000; ++i) {
			System.out.println("main thread");
		}
		int res = future.get();// blocking
		System.out.println(res);
		pool.shutdown();

	}

}
