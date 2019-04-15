package a2.task4.exceptions;

public class InvalidPositionException extends Exception{		//task2
    public InvalidPositionException(){
        super("Invalid position index !!!");
    }
    public InvalidPositionException(String message){
        super(message);
    }
}
