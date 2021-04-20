package com.cg.questions;

//public class ih {

//}

class A{
	private final void display()
	{
		System.out.println("A");}
}
class ih extends A{
	public void display(){
		System.out.println("B");
		}
	public static void main(String[] args) {
		ih b = new ih();
		b.display();
		}
	}


