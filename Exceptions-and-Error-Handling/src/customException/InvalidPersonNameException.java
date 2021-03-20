package customException;
//created by J.M.

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException(String massage){
        super(massage);
    }
}
