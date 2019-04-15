package lab.lab10;
import java.util.Random;
public class Lab10Driver {

	public static void main(String[] args) {
		Fillable[] f = new Fillable[5];
		f[0] = new Circle(4,5,9);
		f[1] = new Circle(5.1, 5, 2);
		f[2] = new Rectangle(4,4,6,3);
		f[3] = new Rectangle(6,3,2,1);
		f[4] = new Rectangle(4,3,2,5);
		for(int i=0; i<f.length; i++){
			Random randomGenerator = new Random();
			int color = randomGenerator.nextInt(5) + 1;
			f[i].draw(color);
			color = randomGenerator.nextInt(5) + 1;
			f[i].fill(color);
		}
	}

}
