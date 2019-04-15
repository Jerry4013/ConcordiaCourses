package textbook.ProjectsChapter7;

public class MessageDemo {
	public static void main(String[] args){
		Email e1 = new Email("This is Java", "Jerry", "Someone", "Topic");
		System.out.println(e1);
		SMS s1 = new SMS("This is Java", 9217000);
		System.out.println(s1);
		
		System.out.println(Message.ContainsKeyword(s1, "Java"));
		
		
	}
}
