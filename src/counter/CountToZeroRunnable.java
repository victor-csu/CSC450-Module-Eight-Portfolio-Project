package counter;

/**
 * CountToTwenty class
 * counts from twenty to zero
 */
public class CountToZeroRunnable extends CountRunnable {

    /**
     * Constructor
     * Enforced Parameterized constructor
     *
     * @param threadCount a shared integer counter state
     */
    public CountToZeroRunnable(Count threadCount) {
        super(threadCount);
    }

    /**
     * countToZero
     * counts down to zero and prints the count value.
     */
    public void countToZero() {
        // critical section reading a shared variable.
        System.out.printf("\nCount From %d to 0\n", threadCount.getValue());

        while (threadCount.getValue() >= 0) {
            System.out.println(threadCount.getValue());

            // critical section writing to a shared variable.
            threadCount.setValue(threadCount.getValue() - 1);
        }

        System.out.println("");
    }

    /**
     * run in thread
     */
    public void run() {
        countToZero();
    }
}
