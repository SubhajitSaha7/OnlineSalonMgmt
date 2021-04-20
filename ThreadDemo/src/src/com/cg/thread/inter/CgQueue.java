package com.cg.thread.inter;

import java.util.Scanner;

public class CgQueue {
	static Scanner scan = new Scanner(System.in);
	private String data;
	private boolean flag = false;
	
	public synchronized void putData() {
		if(flag)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		System.out.println("enter the data");
		this.data = scan.next();
		System.out.println("producer produced");
		flag=true;
		notify();
		
	}
  public synchronized void getData() {
	  if(!flag)
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	  
	  System.out.println("consumer consumed " + data);
	  this.flag=false;
	  notify();
  }
	
	
}



