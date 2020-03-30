package comp445.client;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/03
 **/
public class InvalidCommandException extends Exception {
    public InvalidCommandException() {
        super("Invalid Command. Use \"httpc help\" for more information.");
    }
}
