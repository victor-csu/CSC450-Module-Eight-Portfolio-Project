package counter;

/**
 * Count class
 */
public class Count {
    private volatile int value;

    /**
     * Constructor
     * Enforced Parameterized constructor
     *
     * @param value a shared integer counter
     */
    public Count(int value) {
        setValue(value);
    }

    /**
     * setValue
     *
     * @param value an integer counter
     */
    public synchronized void setValue(int value) {
        this.value = value;
    }

    /**
     * getValue
     * @return int the count value
     */
    public synchronized int getValue() {
        return value;
    }
}
