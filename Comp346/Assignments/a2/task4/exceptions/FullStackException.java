package a2.task4.exceptions;

public class FullStackException extends Exception{		//task2
    public FullStackException(){
        super("Full Stack !!!");
    }
    public FullStackException(String message){
        super(message);
    }
}
