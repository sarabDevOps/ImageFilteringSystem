package ie.gmit.sw.threadTask;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import javax.imageio.ImageIO;

/**
 * This class implements callable interface and calls the File task 
 * 
 * @author Sarab Jeet
 * @version 1.0
 *
 */

public class FileProcessorTask  implements Callable<BufferedImage>{
	
	private File file;
	
	public FileProcessorTask(File inFile){
		this.file  = inFile;
	}
	
	/**
	 * This method reads the file and convert to bufferedImages object
	 * handles the input file and converts it to bufferedImage
	 * 
	 * @param file input file 
	 * @return BufferedImage of the input file
	 * 
	 */
	
	private BufferedImage connvertFileToBufferedImage(File file){
		BufferedImage bufferedImage  = null;
		try {
			bufferedImage  = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bufferedImage;
		
	}

	
	
	/**
	 * Calls the convertFilrToBufferedImage method
	 * 
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@Override
	public BufferedImage call() throws Exception {
		return connvertFileToBufferedImage(file);
	}
	
	
	

}
