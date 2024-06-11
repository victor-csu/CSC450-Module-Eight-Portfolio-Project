package counter;

/**
 * CountToTwenty class
 * counts from zero to twenty
 */
public class CountToTwentyRunnable extends CountRunnable {
    /**
     * Constructor
     * Enforced Parameterized constructor
     *
     * @param threadCount a shared integer counter state
     */
    public CountToTwentyRunnable(Count threadCount) {
        super(threadCount);
    }

    /**
     * countToTwenty
     * counts up from zero to twenty and prints the count value.
     */
    private void countToTwenty() {
        // critical section reading a shared variable.
        System.out.printf("\nCount From %d to 20\n", threadCount.getValue());

        while (threadCount.getValue() <= 20) {
            System.out.println(threadCount.getValue());

            // critical section writing to a shared variable.
            threadCount.setValue(threadCount.getValue() + 1);
        }

        threadCount.setValue(threadCount.getValue() - 1);

        System.out.println("");
    }

    /**
     * run in thread
     */
    public void run() {
        countToTwenty();
    }
}
