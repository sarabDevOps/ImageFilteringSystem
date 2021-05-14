package ie.gmit.sw.blockingqueue;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * This class implements runnable interface and insert items into blocking queue
 * 
 * @author Sarab Jeet
 * @version 1.0
 *
 */

public class FileProducer implements Runnable{
	BlockingQueue<File> blockingQueue;
	ArrayList<File> fileArrayList;
	
	
	public FileProducer(BlockingQueue<File> blockingQueue, ArrayList<File> fileArrayList){
		this.blockingQueue = blockingQueue;
		this.fileArrayList = fileArrayList;
	}


	/**
	 * This method overrides the run method of the runnable interface
	 * and insert item into the blocking queue
	 * and waits if the queue is full 
	 * 
	 */
	
	@Override
	public void run() {
		
		fileArrayList.forEach(f -> {
		
			try {
				blockingQueue.put(f);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		});
		
		
		/*for(File f : fileArrayList){
			try {
				blockingQueue.put(f);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		
	}
	

	
	
}
