package timing;

/**
 * A Timer implementation that tracks elapsed and total time using System.nanoTime().
 */
public class Timer implements ITimer {

    // elapsed time since the last start or resume call
    private long elapsedTime;

    // total time accumulated over multiple start/pause/stop cycles
    private long totalTime;

    /**
     * Starts the timer and resets the elapsed and total time counters.
     */
    @Override
    public void start() {
        elapsedTime = System.nanoTime();
        totalTime = 0;
    }

    /**
     * Stops the timer and returns the total elapsed time since the last start call.
     *
     * @return The total elapsed time in nanoseconds.
     */
    @Override
    public long stop() {
        elapsedTime = System.nanoTime() - elapsedTime;
        totalTime += elapsedTime;
        return totalTime;
    }

    /**
     * Resumes the timer from the last paused state, updating the elapsed time.
     */
    @Override
    public void resume() {
        elapsedTime = System.nanoTime();
    }

    /**
     * Pauses the timer and returns the elapsed time since the last start or resume call.
     *
     * @return The elapsed time in nanoseconds.
     */
    @Override
    public long pause() {
        elapsedTime = System.nanoTime() - elapsedTime;
        totalTime += elapsedTime;
        return elapsedTime;
    }

}
