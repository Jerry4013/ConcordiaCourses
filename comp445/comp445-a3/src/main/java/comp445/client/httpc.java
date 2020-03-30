package comp445.client;

import java.nio.channels.DatagramChannel;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/09/16
 **/
public class httpc {

    public static void main(String[] args) throws Exception {
        UDPClient udpClient = new UDPClient();
        Request request = ArgsParser.parse(args, udpClient);
        if (request != null) {
            DatagramChannel datagramChannel = udpClient.handShaking();
            udpClient.sendRequest(request, datagramChannel);
        }
    }

}
