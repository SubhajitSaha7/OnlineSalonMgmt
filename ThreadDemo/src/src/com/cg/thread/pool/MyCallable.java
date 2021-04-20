package src.com.cg.thread.pool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=1;i<=1000; ++i) {
			System.out.println("callable");
			sum = sum +i;
		}
		return sum;
	}

}
