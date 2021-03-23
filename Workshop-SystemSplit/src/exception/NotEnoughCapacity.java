package exception;
//created by J.M.

public class NotEnoughCapacity extends RuntimeException{

    public NotEnoughCapacity(String message){
        super(message);
    }
}
