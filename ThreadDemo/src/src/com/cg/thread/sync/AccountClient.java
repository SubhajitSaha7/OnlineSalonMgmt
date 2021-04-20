package src.com.cg.thread.sync;

public class AccountClient {

	public static void main(String[] args) {
		Account acc = new Account();
		RamThread t1 = new RamThread(acc);
		t1.setName("ram");
		TomThread t2 = new TomThread(acc);
		t2.setName("tom");
		
		t1.start();
		t2.start();

	}

}
