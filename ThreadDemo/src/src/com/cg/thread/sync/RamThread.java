package src.com.cg.thread.sync;

public class RamThread extends Thread{
    private Account acc;
    
	public RamThread(Account acc) {
		this.acc = acc;
	}
	
	public void run() {
		acc.doTx();
	}
}
