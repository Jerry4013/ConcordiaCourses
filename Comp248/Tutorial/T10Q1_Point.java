
public class T10Q1_Point {
	private int x;
	private int y;
	
	public T10Q1_Point(int x1, int y1)
	{
		x = x1;
		y = y1;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int newX)
	{
		x = newX;
	}
	
	public void setY(int newY)
	{
		y = newY;
	}
	
	public boolean equals(T10Q1_Point anotherPoint)
	{
		return (x == anotherPoint.x && y == anotherPoint.y);
	}
	
	public T10Q1_Point reverse()
	{
		T10Q1_Point newPoint = new T10Q1_Point(y,x);
		return newPoint;
	}
	
	public void moveBy(int a)
	{
		x = x + a;
		y = y + a;
	}
	
	public String toString()
	{
		return ("Coordinates of point are ("+ x + ", "+ y + ")");
	}
	
	
}
