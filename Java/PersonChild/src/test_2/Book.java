package test_2;

public class Book {
	private String bookname;
	private String price;
	private Person person;
	
	public Book(String bookname, String price) {
		this.setBookname(bookname);
		this.setPrice(price);
		
	}
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookname(){
		return bookname;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice(){
		return price;
	}
	
	public void setPerson (Person person){
		this.person = person;
	}
	public Person getPerson (){
		return person;
	}
}
