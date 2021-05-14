package ie.gmit.sw.blockingqueue;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import ie.gmit.sw.model.FilterModel;

/**
 * This class implements two threads and perform operations on blocking queue
 * 
 * @author sarab
 * @version1.0
 */

public class BlockingQueueExecutor {

    private static final int SIZE_OF_BLOCKING_QUEUE = 3;
    
    
    /**
     * this method creates a array blocking queue of size 3
     * creates and start two threads and perform operation on blocking queue
     * 
     * @param fileArrayList				list of files
     * @param selecttedFilterModel		select filter model object
     * @param outputPath 				output path of the images
     * 
     * 
     */
    
    
    public static void addFilesToBlockingQueue(ArrayList<File> fileArrayList, FilterModel selectedFilterModel, String outputPath){
    	
    	  BlockingQueue<File> blockingQueue = new ArrayBlockingQueue(SIZE_OF_BLOCKING_QUEUE);
          FileProducer fileProducer = new FileProducer(blockingQueue, fileArrayList);
          FileConsumer fileConsumer = new FileConsumer(blockingQueue, fileArrayList, selectedFilterModel, outputPath);


          Thread t1 = new Thread(fileProducer);
          Thread t2 = new Thread(fileConsumer);
          t1.start();
          t2.start();
          try {
              t2.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
    }
   
}
