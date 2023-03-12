package bench;

import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

/**
 * A benchmark that makes the main thread sleep for a specified number of milliseconds
 */
public class SleepBenchmark implements IBenchmark {

    /** The number of milliseconds to sleep for. */
    public int n;

    /**
     * Runs the benchmark by sleeping for {@code n} milliseconds.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Does not use any parameters.
     * @param params the parameters to be ignored
     */
    @Override
    public void run(Object... params) {

    }

    /**
     * Initializes the benchmark with the specified sleep time.
     * @param params an array containing one element: the number of milliseconds to sleep for
     */
    @Override
    public void initialize(Object... params) {
        n = (int) params[0];
    }

    /**
     * Does not perform any cleanup actions yet.
     */
    @Override
    public void clean() {

    }

    /**
     * Does not provide a way to cancel the benchmark yet.
     */
    @Override
    public void cancel() {

    }

}

/**
 * A test program that runs a {@link SleepBenchmark} and logs the results.
 */
class SleepTest {

    public static void main(String[] args) {
        ITimer timer = new Timer();
        SleepBenchmark bench = new SleepBenchmark();
        ILogger log = new ConsoleLogger();

        // Initialize the benchmark with a sleep time of 10 ms.
        bench.initialize(10);

        // Start the timer and run the benchmark.
        timer.start();
        bench.run();
        long time = timer.stop();

        // Calculate the offset between the actual sleep time and the requested sleep time.
        long offset = (long) (100 * (time - (bench.n)*Math.pow(10, 6)) / ((bench.n)*Math.pow(10, 6)));

        // Log the results.
        log.write("Given value: ", bench.n, "ms");
        log.write("Finished after: ", time, "ns");
        log.write("Offset is: ", offset, "%");

    }

}
