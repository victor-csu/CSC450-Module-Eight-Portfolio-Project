package counter;

import java.util.concurrent.locks.ReentrantLock;

/*
 * Thread is a class that represents a Thread.
 */
public final class CounterThread extends Thread {
    private ReentrantLock mutex;

    public CounterThread(
        String name,
        ReentrantLock mutex,
        Runnable runnable
    ) {
        super(runnable);
        super.setName(name);

        setMutex(mutex);
    }

    /**
     * getMutex
     * mutex lock
     * @return ReentrantLock
     */
    private ReentrantLock getMutex() {
        return this.mutex;
    }

    /**
     * setMutex
     * @param mutex the mutex lock
     */
    private void setMutex(ReentrantLock mutex) {
        this.mutex = mutex;
    }

    /**
     * details
     * @static
     * print thread details
     * @param name thread name
     */
    static public void details(String name) {
        long processId = ProcessHandle.current().pid();
        long threadId = Thread.currentThread().threadId();

        System.out.printf(
            "\nThread(%s) with id(%d) started\n",
            name,
            threadId
        );

        System.out.printf("Running within process: %d\n", processId);
    }

    /**
     * details
     * get thread details
     */
    private void details() {
        details(getName());
    }

    public void run() {
        details();
        // critical section
        // mutex lock
        getMutex().lock();

        super.run();

        // mutex unlock
        getMutex().unlock();
    }
}
