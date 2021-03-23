package exception;
//created by J.M.

public class NotEnoughMemory extends RuntimeException{

    public NotEnoughMemory(String message){
        super(message);
    }
}
