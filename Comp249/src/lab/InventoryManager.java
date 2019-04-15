package lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class InventoryManager{
	

	public static void main(String[] args) {
		InventoryItem[] items = new InventoryItem[5];
		TextToObjects(items);
		ObjectsToBinary(items);
		BinaryToObjects();
	}
	public static InventoryItem[] TextToObjects(InventoryItem[] items){
		Scanner fileIn = null;
		try{
			fileIn = new Scanner(new FileInputStream("items.txt"));
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		for(int i=0; i<items.length; i++){
			long id = fileIn.nextLong();
			String des = fileIn.next();
			double price = fileIn.nextDouble();
			int inStock = fileIn.nextInt();
			items[i] = new InventoryItem(id, des, price, inStock);
		}
		fileIn.close();
		return items;
	}
	
	public static void ObjectsToBinary(InventoryItem[] items){
		try{
			ObjectOutputStream binOut = new ObjectOutputStream(new FileOutputStream("items.dat"));
			for(int i=0; i<items.length; i++){
				binOut.writeObject(items[i]);
			}
			binOut.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public static void BinaryToObjects() {
		try{
			ObjectInputStream binIn = new ObjectInputStream(new FileInputStream("items.dat"));
			InventoryItem item = null;
			for(int i=0; i<5; i++){
				item = (InventoryItem) binIn.readObject();
				System.out.println(item);
			}
			binIn.close();
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}catch(ClassNotFoundException e3){
			System.out.println(e3.getMessage());
			System.exit(0);
		}catch(IOException e2){
			System.out.println(e2.getMessage());
			System.exit(0);
		}
	}
			
}
