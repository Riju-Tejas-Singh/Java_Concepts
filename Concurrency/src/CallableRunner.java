import java.util.List;
import java.util.concurrent.*;

class CallableTask implements Callable<String> {
    private final String game;

    CallableTask(String game) {
        this.game = game;
    }

    @Override
    public String call() {
        return " Play " + game;
    }

}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. submit 2. invokeAll 3. invokeAny


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // Future is a promise that there will be a result
        Future<String> futureGame = executorService.submit(new CallableTask("Chess"));
        System.out.println("Callable method called");
        String game = futureGame.get();
        System.out.println(game);
        executorService.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        List<CallableTask> tasks = List.of(new CallableTask("Cricket"), new CallableTask("Tennis"));
        List<Future<String>> results = executorService2.invokeAll(tasks);
        for (Future<String> result : results) {
            System.out.println(result.get());
        }


        String result = executorService2.invokeAny(tasks);
        System.out.println(result);
        executorService2.shutdown();
    }
}
