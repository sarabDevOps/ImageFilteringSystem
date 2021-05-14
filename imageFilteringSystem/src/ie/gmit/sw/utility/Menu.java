package ie.gmit.sw.utility;

import java.util.Scanner;

/**
 * this class is used for display menus
 * 
 * @author Sarab Jeet
 * @version 1.0
 * 
 */

public class Menu {

	

	/**
	 * this method shows the menu to the user and takes the user choice
	 * 
	 * @return String
	 */
	protected String displayMenu() {

		String choice = "";

		Scanner console = new Scanner(System.in);
		System.out.println("*****************Image Filtering System************");
		System.out.println("1) Enter Image directory");
		System.out.println("2) Select Single Image");
		System.out.println("3) Add a Customer Filter");
		System.out.println("4) Exit");
		choice = console.next();
		return choice;

	}

	/**
	 * this method display the list of filter that can be applied to the image
	 * and accept the choice from the user
	 * 
	 * @return int the selected option
	 * 
	 */

	protected int displayFilterMenu() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Select Filter to Apply on Image");
		System.out.println("0) GrayScale Filter");
		System.out.println("1) Identity Filter");
		System.out.println("2) Edge Detection Filter1");
		System.out.println("3) Edge Detection Filter2");
		System.out.println("4) Laplacian Filter");
		System.out.println("5) Sharpen Filter");
		System.out.println("6) Horizontal Lines Filter");
		System.out.println("7) Vertical Lines Filter");
		System.out.println("8) Diagonal Lines Filter");
		System.out.println("9) Sobel Horizontal Filter");
		System.out.println("10) Sobel Vertical Filter");
		System.out.println("11) box Blur Filter");
		System.out.println("12) Gaussian Blur Filter");
		System.out.println("13) All the above");
		int filterChoice = sc.nextInt();
		if (!(filterChoice >= 0 && filterChoice <= 13)) {
			System.out.println("Invalid filter selected");
			filterChoice = 999;
		}
		return filterChoice;
	}

}
