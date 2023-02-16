

public class day22mission {
    public static void main(String args[]) {
        Thread worker = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("작업 스레드 : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        });
           worker.start();

        int alphabet = 'a';
        try {
            while (worker.isAlive()) {
                System.out.println("메인 스레드 : " + (char) alphabet++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
        }
    }
}