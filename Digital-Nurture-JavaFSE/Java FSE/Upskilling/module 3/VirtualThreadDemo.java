public class VirtualThreadDemo {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[100000];
        for (int i = 0; i < 100000; i++) {
            int id = i;
            threads[i] = Thread.startVirtualThread(() -> {
                System.out.println("Virtual Thread " + id);
            });
        }
        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nTime Taken: "+ (endTime - startTime) + " ms");
    }
}