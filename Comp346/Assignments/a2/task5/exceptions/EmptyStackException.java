package a2.task5.exceptions;

public class EmptyStackException extends Exception{		//task2
    public EmptyStackException(){
        super("Empty Stack !!!");
    }
    public EmptyStackException(String message){
        super(message);
    }
}
