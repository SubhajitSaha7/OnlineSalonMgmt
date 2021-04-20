package src.com.cg.thread.sync;

public class Account {

	public  synchronized void doTx() {
		for(int i=1; i<=5000; ++i)
			System.out.println(Thread.currentThread().getName() + " doing tx ");
		System.out.println(Thread.currentThread().getName() + " tx completed ");
			
	}
	
	public  void getBalance() {
		for(int i=1; i<=1000; ++i)
		   System.out.println(Thread.currentThread().getName() + " get balance");
	}
}
