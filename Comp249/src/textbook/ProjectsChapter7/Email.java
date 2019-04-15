package textbook.ProjectsChapter7;

public class Email extends Message{
	private String sender;
	private String receiver;
	private String subject;
	
	public Email(){}
	public Email(String text, String sender, String receiver, String subject){
		super(text);
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
	}
	
	public String toString(){
		return "From: " + sender +"\nTo: " + receiver +  "\nSubject: " + subject + "\n" + super.toString();
	}
	
	
}
