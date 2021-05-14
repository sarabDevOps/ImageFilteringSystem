package ie.gmit.sw.threadTask;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import javax.imageio.ImageIO;

/**
 * 
 * This class implements callable interface and performs BufferedImage task
 * @author Sarab Jeet
 * @version 1.0
 *
 */


public class BufferedImageProcessorTask implements Callable<Boolean> {

	
	BufferedImage output;
	File inputFile;
	String filterName;
	String outputPath;
	
	public BufferedImageProcessorTask(BufferedImage output, File inputFile, String fileName, String outputPath) {
		this.output = output;
		this.inputFile = inputFile;
		this.filterName = fileName;
		this.outputPath = outputPath;
		
	}
	
	/**
	 * This method writes the bufferedImage to the output path
	 * 
	 * 
	 * @param output		{@link BufferedImage} output
	 * @param inputFile		input file as a File
	 * @param filterName	filter name as a String
	 * @param outputPath	output path as a String
	 * @return boolean 		true if write operation is successful else false
	 */
	private boolean writeBufferedImageToOutputFile(BufferedImage output, File inputFile , String filterName, String outputPath  ){
		boolean isDone = false;
		
		File outputFile = amendOutputImagePath(inputFile , filterName , outputPath);
		
		try {
			isDone = ImageIO.write(output, "PNG", outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("[->] Output File :: "+ outputFile.getPath());
		return isDone;
	}
	
	
	/**
	 * This method amends the filter name to the output file name
	 * 
	 * @param input			input file
	 * @param filterName 	name of the filter 
	 * @param ouputPath 	output path of the image 
	 * @return File 		output file 
	 */
	private File amendOutputImagePath(File input, String filterName, String outputPath){
		String fileName = input.getName();
		
		int indexOfSeparator = fileName.lastIndexOf(".");
		
		String primaryName = fileName.substring(0,indexOfSeparator);
		String typeName = fileName.substring(indexOfSeparator + 1);
		String outputFileUrl = outputPath + "\\" + primaryName + "_" + filterName + "." + typeName;
		
		return new File(outputFileUrl);
	}
	
	/**
	 * Calls writeBufferedImaeIOOutputFile method
	 * 
	 * @return Boolean
	 * @throws Exception
	 */
	
	@Override
	public Boolean call() throws Exception {
		
		return writeBufferedImageToOutputFile(output, inputFile, filterName, outputPath);
	}

}
