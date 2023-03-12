package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogger;
import timing.ITimer;
import timing.Timer;

public class TestDemoBench {

    public static void main (String[] args){

        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new DemoBenchmark();

        bench.initialize(1000);
        timer.start();
        bench.run();
        long time = timer.stop();

        log.write("Finished in: " + time + " ns");
        log.close();
        bench.clean();
    }

}



