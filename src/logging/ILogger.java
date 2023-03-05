package logging;

/**
 * An interface for a logger that can write longs, strings, and variable argument lists of objects.
 */
public interface ILogger {

    /**
     * Writes a long value to the log.
     *
     * @param param The value to write.
     */
    void write(long param);

    /**
     * Writes a string value to the log.
     *
     * @param param The value to write.
     */
    void write(String param);

    /**
     * Writes multiple values to the log as a formatted string.
     *
     * @param values The values to write.
     */
    void write(Object ...values);

    /**
     * Closes the logger and releases any resources it may be holding.
     */
    void close();
}


