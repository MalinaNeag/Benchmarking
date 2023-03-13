package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;

public class CPUDigitsOfPi implements IBenchmark {

    private GaussLegendre gl;
    private BigDecimal result;
    public BigDecimal getResult() {
        return result;
    }
    @Override
    public void run() {
        result = GaussLegendre.approxPi();
    }

    @Override
    public void run(Object... options){
        result =GaussLegendre.approxPi();
    }


    @Override
    public void initialize(Object... params) {
        gl = new GaussLegendre();
        int precision = (Integer) params[0];
        gl.setPrecision(precision);

    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {
        for (int i=0; i<10; i++){
            result = GaussLegendre.approxPi();
        }

    }


}
