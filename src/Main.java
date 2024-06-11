import java.util.concurrent.locks.ReentrantLock;

import counter.Count;
import counter.CountToTwentyRunnable;
import counter.CountToZeroRunnable;
import counter.CounterThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Count Up and Down Program.");

        CounterThread.details("Main");

        Count counter = new Count(0);
        ReentrantLock mutex = new ReentrantLock();

        CountToTwentyRunnable countToTwentyRunnable = new CountToTwentyRunnable(
            counter
        );

        CountToZeroRunnable countToZeroRunnable = new CountToZeroRunnable(
            counter
        );

        CounterThread countToTwentyThread = new CounterThread(
            "Count To Twenty",
            mutex,
            countToTwentyRunnable
        );

        CounterThread countZeroThread = new CounterThread(
            "Count To Zero",
            mutex,
            countToZeroRunnable
        );

        countToTwentyThread.start();
        countZeroThread.start();
    }
}
