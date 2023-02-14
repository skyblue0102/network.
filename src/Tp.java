import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tp {

        public static void main(String[] args) {
            Runnable task = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.print("잘가. ");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            };
            ExecutorService exec = Executors.newFixedThreadPool(4);
            exec.submit(task);

            for (int i = 0; i < 5; i++) {
                System.out.print("안녕. ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            exec.shutdown();
        }
    }

