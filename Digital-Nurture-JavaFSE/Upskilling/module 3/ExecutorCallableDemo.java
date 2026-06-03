import java.util.concurrent.*;
public class ExecutorCallableDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<Integer> task1 = () -> {
            Thread.sleep(1000);
            return 10 + 20;
        };
        Callable<Integer> task2 = () -> {
            Thread.sleep(1000);
            return 30 + 40;
        };
        Callable<Integer> task3 = () -> {
            Thread.sleep(1000);
            return 50 + 60;
        };
        try {
            Future<Integer> future1 = executor.submit(task1);
            Future<Integer> future2 = executor.submit(task2);
            Future<Integer> future3 = executor.submit(task3);
            System.out.println("Result 1: " + future1.get());
            System.out.println("Result 2: " + future2.get());
            System.out.println("Result 3: " + future3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}