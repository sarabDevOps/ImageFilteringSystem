package ie.gmit.sw.threadTask;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;

import ie.gmit.sw.model.FilterModel;

/**
 * This class implements callable interface and perform convolution task
 * 
 * @author Sarab Jeet
 * @version 1.0
 *
 */

public class ConvolutionTask implements Callable<BufferedImage> {

	private BufferedImage input;
	private int order;
	private double[][] kernel;
	private FilterModel filterModel;

	public ConvolutionTask(BufferedImage inInput, int inOrder, double[][] inKernel) {
		this.input = inInput;
		this.order = inOrder;
		this.kernel = inKernel;

	}

	public ConvolutionTask(BufferedImage input, FilterModel filterModel) {
		this.input = input;
		this.filterModel = filterModel;
		this.order = filterModel.getFilterMatrix().length;
		this.kernel = filterModel.getFilterMatrix();
	}

	/**
	 * Calls performConvolution method
	 * 
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	@Override
	public BufferedImage call() throws Exception {

		return performConvolution();
	}

	/**
	 * 
	 * Perform convolution on the Image matrix using the kernel matrix
	 * 
	 * @return BufferedImage of the output image
	 * 
	 */
	  private BufferedImage performConvolution() {
	        BufferedImage output;

	        int WIDTH = input.getWidth();
	        int HEIGHT = input.getHeight();
	        output = new BufferedImage(WIDTH, HEIGHT, input.getType());
	        System.out.println("[*] Rendering the image...");
	        for (int x = 0; x < WIDTH; x++) {
	            for (int y = 0; y < HEIGHT; y++) {
	                Color color = null;
	                if (filterModel.getFilterId() == 0) {
	                    color = writeGrayScalePixel(x, y);
	                } else {
	                    color = writePixel(x, y);
	                }
	                output.setRGB(x, y, color.getRGB());
	            }
	        }
	        return output;

	    }
	/**
	 * 
	 * This method write pixels at specific index of the image matrix
	 * 
	 * @param x		row index of a pixel  
	 * @param y		column index of a pixel
	 *            
	 * 
	 * @return Color the new color of the pixel at index x,y
	 * 
	 */

	  private Color writePixel(int x, int y) {
	        double multi_factor = 1.0;
	        int WIDTH = input.getWidth();
	        int HEIGHT = input.getHeight();
	        float red = 0f, green = 0f, blue = 0f;
	        for (int i = 0; i < order; i++) {
	            for (int j = 0; j < order; j++) {
	                // Calculating X and Y coordinates of the pixel to be multiplied with current kernel element
	                // In case of edges of image the '% WIDTH' wraps the image and the pixel from opposite edge is used
	                int imageX = (x - order / 2 + i + WIDTH) % WIDTH;
	                int imageY = (y - order / 2 + j + HEIGHT) % HEIGHT;

	                int RGB = input.getRGB(imageX, imageY);
	                int R = (RGB >> 16) & 0xff; // Red Value
	                int G = (RGB >> 8) & 0xff;    // Green Value
	                int B = (RGB) & 0xff;        // Blue Value

	                // The RGB is multiplied with current kernel element and added on to the variables red, blue and green
	                red += (R * kernel[i][j]);
	                green += (G * kernel[i][j]);
	                blue += (B * kernel[i][j]);
	            }
	        }
	        int outR, outG, outB;
	        // The value is truncated to 0 and 255 if it goes beyond
	        outR = Math.min(Math.max((int) (red * multi_factor), 0), 255);
	        outG = Math.min(Math.max((int) (green * multi_factor), 0), 255);
	        outB = Math.min(Math.max((int) (blue * multi_factor), 0), 255);
	        // Pixel is written to output image

	        return new Color(outR, outG, outB);
	    }


	/**
	 * This method is used to obtain a gray scale effect by multiplying rgb
	 * color component to a specified value
	 * 
	 * 
	 * @param x		 row index of a pixel
	 * @param y		 column of a pixel
	 *           
	 * @return Color the new color of the pixel at index x,y
	 * 
	 * 
	 */

	  private Color writeGrayScalePixel(int x, int y) {
	        Color c = new Color(input.getRGB(x, y));
	        int red = (int) (c.getRed() * 0.299);
	        int green = (int) (c.getGreen() * 0.587);
	        int blue = (int) (c.getBlue() * 0.114);
	        Color newColor = new Color(red + green + blue,
	                red + green + blue, red + green + blue);

	        return newColor;
	    }

}
