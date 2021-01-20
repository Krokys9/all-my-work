package asdfsfgth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class BubbleSortExample {
    static double bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        long time0 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long time1 = System.currentTimeMillis();
        double dtime = (time1 - time0) / 1000.;
        return dtime;

    }
}

class Barrier {
    private int numberOfThreads;                      //kiek iš viso turime threadu, tai yra kiek threadu turi laukt pabaigto darbo
    private int threadsToWaitFor;                     // counteris kiek turiu dar sualukti threadu
    private static int count;                           // reikalingas tam kad nustatyciau ar jau baige rusiuoti.
    private static int arraySize;
    private static boolean finished;
    public Barrier(int numberOfThreads, int arraysize) {
        this.numberOfThreads = numberOfThreads;
        this.threadsToWaitFor = numberOfThreads;
        this.arraySize = arraysize;
        finished = false;
    }

    public synchronized boolean await(int counter) throws InterruptedException {

        threadsToWaitFor--;                         
        if (threadsToWaitFor > 0) {
            finished = false;
            count = count + counter;
            this.wait();                              
        }
        else {
            if(count >= arraySize)
                finished = true;
            count = 0;
            threadsToWaitFor = numberOfThreads;       
            notifyAll();                              
        }
        return finished;
    }
}



class TTest extends Thread
{
    static int arraySize = 0;
    static int threadAmount = 0;
    static int debugMode = 0;
    static int[] arr;
   int [] indexs;
    private int odd = 0;
    private static int MaxIntNumber;
    int count = 0;
    public Barrier barrjieras;
    private static int inputThreadAmount;
    private static boolean finished;
    

   
    
    public TTest(int[] indexes, Barrier barrier) {
        this.indexs = indexes;
        this.barrjieras = barrier;
        finished = false;
    }

    public void run() {
        if(debugMode == 1){
            System.out.println(Thread.currentThread().getName() + " started");
        }
        int temp = 0;
        
        try{
            for(int j = 0; j < arraySize*2; j++)
            {
                if(finished){
                    break;
                }
                if((indexs[0])%2 == 1)
                {
                 if(odd == 1)
                 {
                     temp =-2;
                 }
                }
                for(int i = indexs[0]+odd+temp; i<indexs[1]; i+=2){
                    
                  //  System.out.println(this + "  " +i);
                    if(i+1 > arr.length-1){
                        break;
                    }
                    count++;
                    if(arr[i] < arr[i+1]){
                        int tempas = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = tempas;
                        count = 0;
                    }
                }
                finished = barrjieras.await(count);

                if(odd == 0){
                    odd = 1;
                }else{
                    odd = 0;
                    count = 0;
                }
            }
        }catch(Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        if(debugMode == 1)
            System.out.println(Thread.currentThread().getName() + " finished");    //shows when a thread finishes it's work
    }

    private static int[] create_data(int len){
        int[] data = new int[len];
        Random gen = new Random(1);
        for(int i = 0; i <  data.length; i++) {
            data[i] = gen.nextInt(MaxIntNumber);
        }
        return data;
    }

    static double makePerformanceTest() throws Exception
    {
        arr = create_data(arraySize);

        Barrier barrier = new Barrier(threadAmount,arraySize);
        if(debugMode == 1){
            System.err.println("Starting array:");
            for (int datum : arr) {
                System.err.print(datum+" ");
            } System.err.println();
        }
            // padaryti be indeksu padaryti be indeksu 
      //  int[] range;
       // range = IntStream.iterate(0, n -> n + 2).limit((arraySize/2)).toArray();

        int subSize = arraySize/threadAmount; 
        //int subLeft = range.length%threadAmount;
        int old_temp = 0;
        int temp = 0;

        List<int[]> subArr = new ArrayList<>();

        for(int i = 0; i < threadAmount; i++){
            int[] sub = {0,0};
            /*if(subLeft > 0){
                temp +=1;
                subLeft--;
            }*/
          //  System.out.println(subSize+ "  " + arraySize + threadAmount);
            sub[0] = i*subSize;
            sub[1] = (i+1)*subSize;
            
            old_temp = temp;

            subArr.add(sub);
        }
       
     long startTime = System.currentTimeMillis();
        // Create and start threads
        TTest[] aThreads = new TTest[threadAmount];
    
        for (int i = 0; i < threadAmount; i++)
        {
            (aThreads[i] = new TTest(subArr.get(i), barrier)).start();
        }

        // Wait until all threads finish
        for (int i = 0; i < threadAmount; i++)
        {
            aThreads[i].join();
        }
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime-startTime)/1000.;

        if(debugMode == 1){
            System.err.println("Sorted array:");
            for (int datum : arr) {
                System.err.print(datum+" ");
            } System.err.println();
        }

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i + 1]) {
                for (int datum : arr) {
                    if(debugMode == 1)
                        System.err.print(datum);
                } System.err.println();
                throw new InterruptedException("Array is not sorted");
            }
        }
        return elapsedTime;
    }


    public static void main(String[] args)
    {
        try
        {
            if (args.length == 4)
            {
               
                inputThreadAmount = Integer.parseInt(args[0]);
                arraySize = Integer.parseInt(args[1]);
                MaxIntNumber = Integer.parseInt(args[2]);
                debugMode = Integer.parseInt(args[3]);
                 System.err.println("sekmingai nuskaityti args argumentai.");
                for(int i = 0; i < 1; i++){

                    List<Integer> cores = new ArrayList<Integer>();
                    List<Double> speedups = new ArrayList<Double>();

                    double dtime1 = BubbleSortExample.bubbleSort(create_data(arraySize));
                    System.out.println("paprasto bubbleSort laikas(sec): " + dtime1 + "");

                    System.out.println("gijuSkaicius masvoDydis laikas(sec) Pagreitejimas");
                    threadAmount = 1;
                    cores.add(threadAmount);
                    double time = makePerformanceTest();
                    double speed = dtime1/time;
                    speedups.add(speed);
                    System.out.println( threadAmount + " " + arraySize  + " " +time + " " + speed);
                    for (threadAmount = 2; threadAmount <=inputThreadAmount; threadAmount++)
                    {
                        cores.add(threadAmount);
                        double dtime = makePerformanceTest();
                        double speedup = dtime1 / dtime;
                        speedups.add(speedup);
                        System.out.println( threadAmount + " " + arraySize  + " " +dtime + " " + speedup);
                    }
                }
            }
            else
            {
                threadAmount =7;
                arraySize = 100;
                MaxIntNumber = 10;
                debugMode = 1;

                System.err.println("Test: gijuSkaicius="+threadAmount+" masvoDydis="+arraySize+" debug rezimas="+debugMode);
                double elapsedTime = makePerformanceTest();
                System.err.println("#Completed. darbo laikas: " + elapsedTime + "sec");
                System.exit(0); //>>>>>>>
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            System.exit(4);
        }
    }
}
