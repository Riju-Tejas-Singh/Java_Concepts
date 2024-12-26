import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    AtomicInteger atomicCount = new AtomicInteger();

    public synchronized void increment() {
        count++;
    }

    public void increment1() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void increment2() {
        atomicCount.incrementAndGet();
    }
}
