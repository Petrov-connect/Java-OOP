package exception;
//created by J.M.

public class NonExistentObject extends RuntimeException{

    public NonExistentObject(String message){
        super(message);
    }
}
