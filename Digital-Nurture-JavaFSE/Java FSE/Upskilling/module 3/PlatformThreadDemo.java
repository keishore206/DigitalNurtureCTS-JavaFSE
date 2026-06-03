public class PlatformThreadDemo {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[100000];
        for (int i = 0; i < 100000; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("10000 Platform Threads completed in "+ (end - start) + " ms");
    }
}