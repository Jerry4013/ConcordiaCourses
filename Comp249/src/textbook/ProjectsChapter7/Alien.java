package textbook.ProjectsChapter7;

public class Alien {
	private int health; // 0=dead, 100=full strength
	private String name;

	public Alien (int health, String name)
	{
		this.health = health;
		this.name = name;
	}
	
	public String toString(){
		return "Name: " + name + "\tHealth: " + health;
	}
}

class Snake_alien extends Alien{
	private final int damage = 10;
	public Snake_alien(int health, String name){
		super(health, name);
	}
	public int getDamage(){
		return damage;
	}
}

class Ogre_alien extends Alien{
	private final int damage = 6;
	public Ogre_alien(int health, String name){
		super(health, name);
	}
	public int getDamage(){
		return damage;
	}
}

class Marshmallow_alien extends Alien{
	private final int damage = 1;
	public Marshmallow_alien(int health, String name){
		super(health, name);
	}
	public int getDamage(){
		return damage;
	}
}
