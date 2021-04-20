package com.cg.questions;

public class Question1 {
	public static void main(String[] args) {
		Alpha a= new Alpha();
		Alpha b= new Gamma();
		a= (Alpha) b;
		Alpha c= (Beta) b;
		Alpha c= (Beta) b;
		a.test();
		c.test();
		
		
		
		
		
	}

}
class Alpha	{
	public void test()	{
		System.out.println("Alpha");
	}
	
}
class Beta extends Alpha	{
	public void test()	{
		System.out.println("Beta");
	}
	
}
class Gamma extends Alpha	{
	public void test()	{
		System.out.println("Gamma");
	}
}