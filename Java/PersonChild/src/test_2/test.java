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
		System.out.println("������"+person1.getPersonname() +"���䣺"+person1.getAge()+"��һ���飺"
							+person1.getBook().getBookname()+ "��۸�"+ person1.getBook().getPrice());
		System.out.println("������"+book1.getBookname() +"�۸�"+book1.getPrice()+"���ڣ�"
				+book1.getPerson().getPersonname()+ "���䣺"+ book1.getPerson().getAge());
	}

}
