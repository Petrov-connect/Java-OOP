package manager.exceptions;
//created by J.M.

public class NonExistantModelException extends Exception {

    public NonExistantModelException(){
        super();
    }

    public NonExistantModelException(String message) {
        super(message);
    }
}
