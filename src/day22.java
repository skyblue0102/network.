import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;


public class day22 {
    public static void main(String[] args) {
        System.out.println("NIO 타임 서버");
        try {
            ServerSocketChannel sc = ServerSocketChannel.open();
            sc.socket().bind(new InetSocketAddress(20000));
            while (true) {
                System.out.println("Waiting for request...");
                SocketChannel socketChannel = sc.accept();
                if (socketChannel != null) {
                    String dt = "Date: " + new Date(System.currentTimeMillis());
                 ByteBuffer buf = ByteBuffer.allocate(64);
                 buf.put(dt.getBytes());
                 buf.flip();
                while (buf.hasRemaining()) {
                //    sc.write();
                }
            }}
        }catch (IOException ex) {
            System.out.println("입출력 예외 발생");
        }
    }
}

