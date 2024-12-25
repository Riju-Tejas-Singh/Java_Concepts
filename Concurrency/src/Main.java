public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Hello and welcome!\n");

        System.out.println("Task1 kicked off from Main\n");
        Task1 task1 =  new Task1();
        task1.start();
        task1.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Task2 kicked off from Main\n");
        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.start();
        task2Thread.setPriority(Thread.MIN_PRIORITY);

        task1.join();
        task2Thread.join();
        System.out.println("\nTask3 kicked off from Main\n");
        for (int i = 300; i <= 399; i++) {
            System.out.println(" " + i + " ");
        }
        System.out.println("\nTask3 done\n");

        Counter c1 = new Counter();
        Runnable obj1 = () -> {
            for (int i=1; i<=10000; i++) {
                c1.increment();
            }
        };

        Runnable obj2 = () -> {
            for (int i=1; i<=10000; i++) {
                c1.increment();
            }
        };
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
        // remember to join before print
        t1.join();
        t2.join();
        System.out.println(c1.count);
    }
}