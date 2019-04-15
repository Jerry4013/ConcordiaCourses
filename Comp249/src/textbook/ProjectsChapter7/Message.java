package textbook.ProjectsChapter7;

public class Message {
	private String text;

	public Message(){}
	public Message(String text){
		this.text = text;
	}

	public String toString(){
		return text;
	}

	public String getText(){
		return text;
	}
	public void setText(String newText){
		text = newText;
	}

	public static boolean ContainsKeyword(Message messageObject,
			String keyword)
	{
		if (messageObject.toString().indexOf(keyword,0) >= 0)
			return true;
		return false;
	}

}
