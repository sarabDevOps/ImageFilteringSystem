package ie.gmit.sw.threadTask;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ie.gmit.sw.model.FilterModel;

/**
 * This Class execute the thread task and perform convolution and file operation
 * @author Sarab Jeet
 * @version 1.0
 */

public class TaskExecutor {
	
	private final static int NO_OF_THREADS = 3;
	
	/**
	 * 
	 * This method creates the thread pool of fixed size
	 * invokes the executor service
	 * and submit the different task
	 * and the get the future object on completion of task
	 * 
	 * @param file 					on which filter object will be applied
	 * @param selectedFilterModel	the selected filter which will be applied on th input image
	 * @param outputPath 			the path where the output will be saved
	 * @return boolean 				on completion of the task 
	 * @throws ExecutionException
	 * @throws {@link InterruptedException}
	 * 
	 */
	
	  public static Boolean performTask(File file, FilterModel selectedFilterModel, String outputPath) throws ExecutionException, InterruptedException {
		  ExecutorService executorService = Executors.newFixedThreadPool(NO_OF_THREADS);
	        Future<BufferedImage> bufferedImage = executorService.submit(new FileProcessorTask(file));
	        Future<BufferedImage> outputBufferedImage = executorService.submit(new ConvolutionTask(bufferedImage.get(), selectedFilterModel));
	        Future<Boolean> booleanFuture = executorService.submit(new BufferedImageProcessorTask(outputBufferedImage.get(), file, selectedFilterModel.getFilterName(), outputPath));
	        return booleanFuture.get();
	    }
	
	

}
