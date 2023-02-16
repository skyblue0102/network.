import java.io.IOException;
import java.net.*;
import java.util.Date;

public class day22 {
    public static void main(String args[]) {
        System.out.println("멀티캐스트 타임 서버");
        DatagramSocket serverSocket = null; //UDP지원 프로토콜
        try {
            serverSocket = new DatagramSocket();
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();
                InetAddress group = InetAddress.getByName("224.0.0.0");
                DatagramPacket packet;
                packet = new DatagramPacket(buffer, buffer.length, group, 10000);
                serverSocket.send(packet);
                System.out.println("전송된 시간: " + dateText);

                try {
                    Thread.sleep(1000); //1초 단위로 딜레이
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}