/**
 * The ConsoleLogger class implements the ILogger interface for logging messages to the console.
 */

package logging;

public class ConsoleLogger implements ILogger {

    /**
     * Writes a long parameter to the console.
     *
     * @param param the long value to be written to the console.
     */
    @Override
    public void write(long param) {
        System.out.println(param);
    }

    /**
     * Writes a string parameter to the console.
     *
     * @param param the string value to be written to the console.
     */
    @Override
    public void write(String param) {
        System.out.println(param);
    }

    /**
     * Writes multiple objects to the console separated by a space.
     *
     * @param values the objects to be written to the console.
     */
    @Override
    public void write(Object... values) {
        for (Object obj : values) {
            System.out.print(obj + " ");
        }
    }

    /**
     * Closes the ConsoleLogger. Does nothing for this implementation.
     */
    @Override
    public void close() {
        //do nothing
    }
}
