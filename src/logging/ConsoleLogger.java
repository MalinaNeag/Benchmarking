package logging;

/**
 * The ConsoleLogger class implements the ILogger interface for logging messages to the console.
 */
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


    /**
     * Converts the received value in nanoseconds and prints it in the desired unit
     * @param value The value to be converted and written
     * @param unit The desired unit of the value
     */

    @Override
    public void writeTime(long value, TimeUnit unit) {
        switch (unit) {
            case Nano -> System.out.println("Finished in " + value + " " + unit);
            case Micro -> System.out.println("Finished in " + value * Math.pow(10, -3) + " " + unit);
            case Milli -> System.out.println("Finished in " + value * Math.pow(10, -6) + " " + unit);
            case Sec -> System.out.println("Finished in " + value * Math.pow(10, -9) + " " + unit);
        }
    }

    /**
     * Converts the received value in nanoseconds and prints it in the desired unit, along with a given string
     * @param string The string to be written before the value
     * @param value The value to be converted and written
     * @param unit The desired unit of the value
     */
    @Override
    public void writeTime(String string, long value, TimeUnit unit) {
        switch (unit) {
            case Nano -> System.out.println(string + value + " " + unit);
            case Micro -> System.out.println(string + value * Math.pow(10, -3) + " " + unit);
            case Milli -> System.out.println(string + value * Math.pow(10, -6) + " " + unit);
            case Sec -> System.out.println(string + value * Math.pow(10, -9) + " " + unit);
        }
    }
}

/**
 * Provides a test for ConsoleLogger class
 */
class ConsoleTesting {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        logger.write("Hello ");
        logger.write(1);
        logger.close();
    }
}
