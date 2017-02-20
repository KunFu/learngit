package test_2;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person();
		person1.setPersonname("Lily");
		person1.setAge("25");
		Person child = new Person("LiXiaoly","15");
		Book book1 = new Book("Hadoop", "50");
		Book book2 = new Book("Hive", "10");
		
		person1.setBook(book1);
		book1.setPerson(person1);
		
		person1.setChild(child);
		child.setBook(book2);
		book2.setPerson(child);
		System.out.println("从人找到书－－》姓名：" + person1.getPersonname() + " 年龄："
											+ person1.getAge() + " 书名：" + person1.getBook().getBookname() 
											+ " 价格："+ person1.getBook().getPrice());
		
		System.out.println("从书找到人－－》书名：" + book1.getBookname() + " 价格："
				+ book1.getPrice() + " 人名：" + book1.getPerson().getPersonname() 
				+ " 年龄："+ book1.getPerson().getAge());
		
		System.out.println(person1.getPersonname()+ "的孩子--> 姓名：" + person1.getChild().getPersonname() + " 年龄："
				+ person1.getChild().getAge() + " 书名：" + person1.getChild().getBook().getBookname() 
				+ " 价格："+ person1.getChild().getBook().getPrice());
		
		
		
	}

}
