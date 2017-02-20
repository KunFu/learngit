package test_2;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person();
		person1.setPersonname("Lily");
		person1.setAge("25");
		
		Book book1 = new Book("Hadoop", "50");
		
		person1.setBook(book1);
		book1.setPerson(person1);
		System.out.println("人名："+person1.getPersonname() +"年龄："+person1.getAge()+"有一本书："
							+person1.getBook().getBookname()+ "书价格："+ person1.getBook().getPrice());
		System.out.println("书名："+book1.getBookname() +"价格："+book1.getPrice()+"属于："
				+book1.getPerson().getPersonname()+ "年龄："+ book1.getPerson().getAge());
	}

}
