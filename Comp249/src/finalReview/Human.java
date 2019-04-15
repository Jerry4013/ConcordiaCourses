package finalReview;

public class Human 
{
	Arm a;
	
	private class Arm{
		private int length;

		@Override
		public String toString() {
			return "Arm [length=" + length + "]";
		}
		
		
	}
	
	public Human()
	{
		a = this.new Arm();
		a.length = 20;
	}

	@Override
	public String toString() {
		return "Human [a=" + a + "]";
	}

	
}
