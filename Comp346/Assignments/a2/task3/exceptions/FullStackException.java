package a2.task3.exceptions;

public class FullStackException extends Exception{		//task2
    public FullStackException(){
        super("Full Stack !!!");
    }
    public FullStackException(String message){
        super(message);
    }
}
