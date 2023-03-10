import java.nio.Buffer;
import java.nio.ByteBuffer;

public class day24 {
    public static void main(String[] args) {
        System.out.println("[7바이트 크기로 버퍼 생성]");
        ByteBuffer buffer = ByteBuffer.allocateDirect(7);
        printState(buffer); //0, 7, 7

        buffer.put((byte)10); //0, 7, 7
        buffer.put((byte)11);
        System.out.println("[2바이트 저장 후]");
        printState(buffer);

        buffer.put((byte)12);
        buffer.put((byte)13);
        buffer.put((byte)14);
        System.out.println("[3바이트 저장 후]");
        printState(buffer);

        buffer.flip();
        System.out.println("[flip() 실행 후]");
        printState(buffer);

        buffer.get(new byte[3]);
        System.out.println("[3바이트 읽은 후]");
        printState(buffer); //3, 5, 7

        buffer.mark(); //3, 5, 7 (mark 3)
        System.out.println("--------[현재 위치를 마크해놓음]");

        buffer.get(new byte[2]);
        System.out.println("[2바이트 읽은 후]");
        printState(buffer); // 5, 5, 7 (mark 3)

        buffer.reset();
        System.out.println("--------[position을 마크 위치로 옮김]");
        printState(buffer); //3,5,7

        buffer.rewind();
        System.out.println("[rewind() 실행 후]");
        printState(buffer);//0,5,7

        buffer.clear();
        System.out.println("[clear() 실행 후]");
        printState(buffer); //0, 7, 7
    }

    public static void printState(Buffer buffer) {
        System.out.print("\tposition:" + buffer.position() + ", ");
        System.out.print("\tlimit:" + buffer.limit() + ", ");
        System.out.println("\tcapacity:" + buffer.capacity());
    }
}

