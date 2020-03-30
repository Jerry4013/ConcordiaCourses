package comp445.server;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/03
 **/
public class InvalidRequestException extends Exception {
    public InvalidRequestException() {
        super("Invalid Request.");
    }
}
