import java.util.Scanner;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/09/16
 **/
public class httpc {

    public static void main(String[] args) throws Exception {
        Request request = ArgsParser.parse(args);
        if (request != null) {
            request.send();
        }
    }

}
