public class day22mission {
    public static void main(String[] args) {
        int alphabet = 'a';
        Thread thread = new Worker();
        thread.start();
        for(int p=0;p<11;p++){

            System.out.printf("메인스레드: %s\n",(char) (alphabet+p));
            try {
                thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Worker extends Thread{
    public void run(){
        for (int i=0;i<5;i++){
            System.out.printf("작업 스레드: %d\n",i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}