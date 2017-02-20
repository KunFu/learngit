package test_2;

public class Person {
	private String personname;
	private String age;
	private Book book;
	
	public Person(){}
	public Person(String personname, String age){
		this.setPersonname(personname);
		this.setAge(age);
	}
	
	public String getPerson() { 
		return personname;
	}
	public void setPersonname (String personname) {
		this.personname = personname;
	}
	public String getPersonname(){
		return personname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setBook(Book book){
		this.book = book;
	}
	public Book getBook(){
		return book;
	}

}



