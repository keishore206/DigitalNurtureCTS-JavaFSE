class ThreadExample extends Thread {
    private String msg;
    public ThreadExample(String msg) {
        this.msg = msg;
    }
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(msg + " " + i);
        }
    }
}
public class ThreadCreation {
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample("Thread 1");
        ThreadExample t2 = new ThreadExample("Thread 2");
        t1.start();
        t2.start();
    }
}