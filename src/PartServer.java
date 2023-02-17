

import java.io.IOException;
import java.net.InetSocketAddress;
import static java.net.StandardSocketOptions.SO_RCVBUF;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

    public class PartServer {
        private static final HashMap<String,Float> parts = new HashMap<>();

        public PartServer() {
            System.out.println("Part Server Started");
            initializeParts();
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(5000));
                serverSocketChannel.setOption(SO_RCVBUF, 64);
                boolean running = true;
                while (running) {
                    System.out.println("Waiting for client ...");
                    SocketChannel socketChannel
                            = serverSocketChannel.accept();
                    new Thread(new ClientHandler(socketChannel.socket())).start();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private void initializeParts() {
            parts.put("Hammer", 12.55f);
            parts.put("Nail", 1.35f);
            parts.put("Pliers", 4.65f);
            parts.put("Saw", 8.45f);
            parts.put("Driver", 5.55f);

        }

        public static Float getPrice(String partName) {
            return parts.get(partName);
        }

        public static void main(String[] args) {
            new PartServer();
        }
    }


