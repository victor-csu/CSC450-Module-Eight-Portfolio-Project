package counter;

public abstract  class CountRunnable implements Runnable {
    protected Count threadCount;

    public CountRunnable(Count threadCount) {
        setThreadCount(threadCount);
    }

    /**
     * setThreadCount
     *
     * @param threadCount an integer counter
     */
    private void setThreadCount(Count threadCount) {
        this.threadCount = threadCount;
    }
}
