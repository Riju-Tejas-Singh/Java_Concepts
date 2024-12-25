public class Task2 implements Runnable{

    @Override
    public void run() {
        System.out.println("\nTask2 started\n");
        for (int i = 200; i <= 299; i++) {
            System.out.println(" " + i + " ");
        }
        System.out.println("\nTask2 done\n");
    }

}
