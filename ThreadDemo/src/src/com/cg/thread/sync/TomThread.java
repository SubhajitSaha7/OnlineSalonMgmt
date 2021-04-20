package src.com.cg.thread.sync;

public class TomThread extends Thread{

	private Account acc;

	public TomThread(Account acc) {
		super();
		this.acc = acc;
	}
	
	public void run() {
		acc.getBalance();;
	}
}
