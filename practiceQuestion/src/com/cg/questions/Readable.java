package com.cg.questions;
interface Readable{
	public void readBook();
	}
abstract class Book implements Readable
{
	public void readBook()
	
		{
		System.out.println(“Book”);
		}
}
class Ebook extends Book
	{ void readBook()
		{
			System.out.println(“E-Book”);
			}
	}



		
		
	public static void main(String[] args) {
		
			

Book book = new Ebook();
book.readBook();

}

