package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ILogger;
import logging.TimeUnit;
import timing.Timer;
import logging.ConsoleLogger;
import timing.ITimer;

public class TestDemoBenchmark {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new DemoBenchmark();

        final int workload = 10000;
        TimeUnit timeUnit = TimeUnit.Sec;
        bench.initialize(workload);
        for (int i = 0; i < 12; i++) {
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.writeTime("Run " + i + ": ", time, timeUnit);
            //log.write("Run " + i + ": ", time);
        }
        log.writeTime(timer.stop(), timeUnit);
    }
}
