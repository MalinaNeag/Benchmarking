package bench;

import java.util.*;
public class DemoBenchmark implements IBenchmark {

    protected int n;
    protected int[] array;

    @Override
    public void run(){

    }

    @Override
    public void run(Object ... params) {

        boolean isSorted;
        int sortedPortion = 1;

        do{
            isSorted = true;
            for(int i = 0; i < this.n - sortedPortion; i++) {
                if(array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;

                    isSorted = false;
                }
            }

            sortedPortion++;

        }while(!isSorted);


    }

    @Override
    public void initialize(Object ... params) {

        Random random = new Random();
        this.n = (Integer) params[0];
        this.array = new int[n];

        for (int i=0 ; i<n; i++){
            array[i] = random.nextInt(1000);
        }

    }

    @Override
    public void clean(){

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }
}
