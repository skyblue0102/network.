
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class timeclient {
    //multicast client
    public static void main(String[] args) {

        {
            SocketAddress address = new InetSocketAddress("127.0.0.1", 20000);
            try (SocketChannel socketChannel = SocketChannel.open(address)) {

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}

