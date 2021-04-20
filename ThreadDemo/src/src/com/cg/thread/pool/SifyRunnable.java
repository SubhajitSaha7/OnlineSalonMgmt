package src.com.cg.thread.pool;

import java.util.List;

public class SifyRunnable implements Runnable{
    private String thname;
    
    
	public SifyRunnable(String thname) {
		super();
		this.thname = thname;
	}


	@Override
	public void run() {
		for(int i=1; i<=1000; ++i)
			System.out.println(thname +  " is working");
		System.out.println(thname + " completed");
	}

}
