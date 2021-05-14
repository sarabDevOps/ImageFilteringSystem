package ie.gmit.sw.utility;

import java.io.File;
import java.util.Scanner;

/**
 * This class handles user input , uses scanner class
 * 
 * @author Sarab Jeet
 * 
 * @version 1.0
 * 
 */

public class ConsoleInput {

	
	private Scanner sc;

	public ConsoleInput() {
		sc = new Scanner(System.in);
	}

	/**
	 * this method accept the input image path from the user and validates if
	 * the file exits or not
	 * 
	 * @return File input image file
	 * 
	 */

	protected File acceptSingleImageFileAsInput() {

        File inputImageFile = null;
        System.out.println("[?] Enter Input Image path");
        String inputImagePath = sc.next();
        if (!checkImagePath(inputImagePath)) {
            return null;
        }
        inputImageFile = new File(inputImagePath.replace("\"", ""));
        return inputImageFile;
    }

	/**
	 * this method accept the input image directory from user and validates if
	 * the directory exits or not and display the appropriate message
	 * 
	 * @return File the input image directory
	 * 
	 */

	 protected File acceptImageDirectoryAsInput() {
	        System.out.println("[?] Enter Input Image Directory");
	        String dirPath = sc.next();
	        File dir = new File(dirPath.replace("\"", ""));
	        if (!dir.isDirectory()) {
	            System.out.println("[!] Directory does not exist::" + dir);
	            return null;
	        }
	        return dir;
	    }

	/**
	 * this method checks if the input image file exits or not and validates if
	 * the only image files are provided and display appropriate message
	 * 
	 * @param inputImagePath	 input image path in String form
	 *           
	 * @return Boolean 			  if file exits return true else return false
	 * 
	 */

	 private Boolean checkImagePath(String inputImagePath) {

	        File inputImageFile = new File(inputImagePath.replace("\"", ""));
	        if (!inputImageFile.exists()) {
	            System.out.println("[!] File does not exist:" + inputImagePath);
	            return false;
	        }
	        if (!(inputImageFile.getPath().toLowerCase().endsWith(".jpg") || inputImageFile.getPath().toLowerCase().endsWith(".png") || inputImageFile.getPath().toLowerCase().endsWith(".gif"))) {
	            System.out.println("[!] Not an Image File:" + inputImagePath);
	            return false;
	        }
	        return true;
	    }

	/**
	 * this method accept output directory path from the user and validates if
	 * the directory exits or not and display appropriate message
	 * 
	 * @return String the image file path
	 * 
	 */

	 protected String acceptOutputFilePathAsInput() {
	        // sc=new Scanner(System.in);
	        System.out.println("[?] Enter Output path");
	        String outPutImagePath = sc.next();
	        File dir = new File(outPutImagePath.replace("\"", ""));
	        if (!dir.isDirectory()) {
	            System.out.println("[!] OutPut Directory does not exist::" + dir);
	            return null;
	        }
	        return outPutImagePath.replace("\"", "");
	    }

	/**
	 * this method is used to accept the custom kernel size and its size from
	 * the user
	 * 
	 * 
	 * @return double[][] the custom kernel matrix
	 * 
	 */

	  protected double[][] acceptCustomFilterMatrixAsInput() {
	        // sc=new Scanner(System.in);
	        System.out.println("[?] Enter the Size of Kernel Matrix");
	        int sizeOfCustomKernelMatrix = sc.nextInt();
	        System.out.println("Enter elements in matrix");
	        double[][] customKernelMatrix = new double[sizeOfCustomKernelMatrix][sizeOfCustomKernelMatrix];
	        for (int i = 0; i < sizeOfCustomKernelMatrix; i++) {
	            for (int j = 0; j < sizeOfCustomKernelMatrix; j++) {
	                System.out.print("Enter the element at index:[" + i + "][" + j + "]=");
	                customKernelMatrix[i][j] = sc.nextDouble();
	            }
	        }
	        return customKernelMatrix;
	    }

}
