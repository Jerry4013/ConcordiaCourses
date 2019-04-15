
public class T8Q5 {

	public static void main(String[] args) {
		String[][] animals = {
				{ "dog", "cat", "fish", "bird", "worm" },
				{ "lion", "baboon", "bison", "beaver" },
				{ "bear", "bat", "ant", "bobcat", "buffalo","elephant"}, 
				{ "crab", "coyote", "cow", "frog", "goat","grissly" }
		};
		for (int i = 0; i < animals.length; i++)
		{
			System.out.print("["+i+"]["+0+"]" + animals[i][0] + " --");
			for (int j = 1; j < animals[i].length; j++)
			{
				System.out.print("["+i+"]["+j+"]" + animals[i][j] + "");
			}
			System.out.println();
		}
	}

}
