package textbook.chapter10;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		

		StringTokenizer partitionAuthor = new StringTokenizer("T. Jackson and A. H. Peterson and N. Wang");
		while(partitionAuthor.hasMoreTokens())
			System.out.println(partitionAuthor.nextToken());
		
		String s = "T. Jackson and A. H. Peterson and N. Wang";
		System.out.println(s.replace(" and ", ", "));
		String authors = "J. Park and J. N. James and Q. Li and Y. Xu and W. Huang";
		System.out.println(authors.substring(0, authors.indexOf(" and ")));
	}

}
