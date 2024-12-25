public class Task1 extends Thread {

    @Override
    public void run() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        Thread.yield();
        System.out.println("\nTask1 started\n");
        for (int i = 100; i <= 199; i++) {
            System.out.println(" " + i + " ");
        }
        System.out.println("\nTask1 done\n");
    }

}
