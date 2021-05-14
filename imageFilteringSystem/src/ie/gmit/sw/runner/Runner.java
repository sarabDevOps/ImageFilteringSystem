package ie.gmit.sw.runner;

import ie.gmit.sw.utility.MenuController;

/**
 * This is the application starter classes
 * 
 * @author Sarab Jeet
 * @version 1.0
 *
 */

public class Runner {
	
	/**
	 * Main method is used to create the object of MenuController
	 * and calls the showMenu method
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		MenuController menuController = new MenuController();
		menuController.showMenu();
		
		
	}

}
