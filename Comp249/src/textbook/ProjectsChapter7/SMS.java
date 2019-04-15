package textbook.ProjectsChapter7;

public class SMS extends Message{
	private int recipientContactNo;
	
	public SMS(){}
	public SMS(String text, int recipientContactNo){
		super(text);
		this.recipientContactNo = recipientContactNo;
	}
	
	public int getRecipientContactNo(){
		return recipientContactNo;
	}
	
	public void setRecipientContactNo(int newNumber){
		recipientContactNo = newNumber;
	}
	 public String toString(){
		 return super.toString() + "\tto: " + recipientContactNo;
	 }
	 
	
}
