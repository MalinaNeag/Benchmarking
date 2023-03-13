package testbench;

import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUDigitsOfPi{
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogger log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPi();

        final int workload = 1000;
        TimeUnit timeUnit = TimeUnit.Sec;
        bench.initialize(workload);
        for (int i = 0; i < 10; i++){
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.writeTime("Run " + i + ": ", time, timeUnit);
        }
        log.writeTime(timer.stop(), timeUnit);
        /*
        //The value for Pi:
        BigDecimal result = ((CPUDigitsOfPi)bench).getResult();
        log.write("Pi is: "+ result);
         */
    }

}
