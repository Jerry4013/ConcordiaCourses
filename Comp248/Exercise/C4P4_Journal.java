import java.util.StringTokenizer;
public class C4P4_Journal {
	private String author;
	private String title;
	private C4P8_Date dateOfSubmission;
	
	public C4P4_Journal(String author, String title, C4P8_Date dateOfSubmission)
	{
		this.author = author;
		this.title = title;
		this.dateOfSubmission = dateOfSubmission;
	}
	
	public void displayDetails()
	{
		System.out.println("Author: " + author);
		System.out.println("Title: " + title);
		System.out.println("Date: " + dateOfSubmission);
	}
	
	public String getSubmissionDetails()
	{
		String newTitle = "\n";
		StringTokenizer st = new StringTokenizer(title);
		while(st.hasMoreTokens())
		{
			String temp = st.nextToken();
			newTitle = newTitle + (temp.substring(0,1).toUpperCase() + temp.substring(1) + " ");
		}
		return newTitle;
	}
}
