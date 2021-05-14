package ie.gmit.sw.blockingqueue;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;

import ie.gmit.sw.model.FilterModel;
import ie.gmit.sw.threadTask.TaskExecutor;

/**
 * This class implements runnable interface and pop out items from blocking queue
 * 
 * @author sarab
 *
 * @version 1.0
 */

public class FileConsumer implements Runnable{

	BlockingQueue<File> blockingQueue;
	ArrayList<File> fileArrayList;
	FilterModel selectedFilterModel;
	String outputPath;
	
	public FileConsumer(BlockingQueue<File> blockingQueue, ArrayList<File> fileArrayList , FilterModel selectedFilterModel, String outputPath){
		this.blockingQueue = blockingQueue;
		this.fileArrayList = fileArrayList;
		this.selectedFilterModel = selectedFilterModel;
		this.outputPath = outputPath;
		
	}
	
	/**
	 * This method performanceTask method of the TaskExecutor class
	 * 
	 *  @param file image file 
	 *  
	 */	
	
	private void performAction(File file){
		try {
			TaskExecutor.performTask(file, selectedFilterModel, outputPath);
		} catch (ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * this method overrides the run method of the runnable interface
	 * and pop out the item from the blocking queue
	 * and waits if the queue is empty
	 * 
	 */
	@Override
	public void run() {
		File file;
		
		for (int i = 0; i < fileArrayList.size(); i++) {
			
			try {
				file = blockingQueue.take();
				performAction(file);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
}
