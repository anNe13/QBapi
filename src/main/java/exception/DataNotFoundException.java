package exception;

/**
 * Used only when what went wrong is that the requested data could not be found in db.
 */
public class DataNotFoundException extends RuntimeException {

public DataNotFoundException(String message){
    super(message);
}
}
