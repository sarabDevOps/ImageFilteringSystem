package ie.gmit.sw.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import ie.gmit.sw.blockingqueue.BlockingQueueExecutor;
import ie.gmit.sw.model.FilterMatrix;
import ie.gmit.sw.model.FilterModel;

/**
 * this class is used to display and control the main menu 
 * 
 * @author Sarab jeet
 * @version 1.0
 * 
 */
public class MenuController {
	
	
	
	private ConsoleInput consoleInput;
	private Menu menu;
	
	/**
	 * this method display the main menu until user exit from the menu 
	 */
	
    public void showMenu() {
        int choice = 99;
        menu = new Menu();
        consoleInput = new ConsoleInput();
        while (choice != 4) {
            String choiceStr = menu.displayMenu();
            if (checkIfNumber(choiceStr)) {
                choice = Integer.valueOf(choiceStr);
            }
            switch (choice) {
                case 1:
                	selectSingleImage();
                    break;
                case 2:
                    selectSingleImage();
                    break;
                case 3:
                    AddACustomFilter();
                    break;
                case 4:
                    exitMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

	/**
	 * this method terminates the program
	 * 
	 * @return void
	 * 
	 */
	private void exitMenu(){
		System.out.println("Thank you !");
		System.exit(0);
	}
	
	
	/**
	 * this method handles the various user input
	 * like image directory path , output directory path and filter selected
	 * and input file to the blockingQueue
	 * 
	 * @return void
	 */
    private void selectImageDirectory() {
        File inputDirFile = consoleInput.acceptImageDirectoryAsInput();
        if (inputDirFile == null)
            return;
        String outputPath = consoleInput.acceptOutputFilePathAsInput();
        if (outputPath == null)
            return;
        int selectedFilterIndex = menu.displayFilterMenu();
        if (selectedFilterIndex == 999)
            return;
        File[] fileList = inputDirFile.listFiles((dir1, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") || name.toLowerCase().endsWith(".gif"));
        ArrayList<File> fileArrayList = new ArrayList<>(Arrays.asList(fileList));

        //apply all the filters
        if (selectedFilterIndex == 13) {

            initFilterModel().forEach(fm ->
                    BlockingQueueExecutor.addFilesToBlockingQueue(fileArrayList, fm, outputPath));
        } else { //apply only single selected filter

            FilterModel selectedFilterModel = initFilterModel().get(selectedFilterIndex);
            BlockingQueueExecutor.addFilesToBlockingQueue(fileArrayList, selectedFilterModel, outputPath);
        }
    }
	
	 /**
     * This method handles the various user input
     * like Image  path, output directory path and filter selected
     * and input file to the blockingqueue
     *
     * @return void
     */
    private void selectSingleImage() {
        File inputImageFile = consoleInput.acceptSingleImageFileAsInput();
        if (inputImageFile == null)
            return;
        String outputPath = consoleInput.acceptOutputFilePathAsInput();
        if (outputPath == null)
            return;
        int selectedFilterIndex = menu.displayFilterMenu();
        //if selected invalid filter
        if (selectedFilterIndex == 999)
            return;
        if (selectedFilterIndex == 13) {
            initFilterModel().forEach(fm ->
                    BlockingQueueExecutor.addFilesToBlockingQueue(new ArrayList<>(Arrays.asList(inputImageFile)), fm, outputPath));
        } else {
            FilterModel selectedFilterModel = initFilterModel().get(selectedFilterIndex);
            BlockingQueueExecutor.addFilesToBlockingQueue(new ArrayList<>(Arrays.asList(inputImageFile)), selectedFilterModel, outputPath);

        }
    }
    /**
     * This method handles the various user input
     * like Image  path, output directory path and a custom filter matrix
     * and input file to the blockingqueue
     *
     * @return void
     */
	
	  private void AddACustomFilter() {
		  double[][] customFilterMatrix = consoleInput.acceptCustomFilterMatrixAsInput();

	        File inputImageFile = consoleInput.acceptSingleImageFileAsInput();
	        if (inputImageFile == null)
	            return;
	        String outputPath = consoleInput.acceptOutputFilePathAsInput();
	        if (outputPath == null)
	            return;
	        //adding custom filter matrix to the filter model class
	        FilterModel selectedFilterModel = new FilterModel(999, "Custom_Filter", customFilterMatrix);
	        BlockingQueueExecutor.addFilesToBlockingQueue(new ArrayList<>(Arrays.asList(inputImageFile)), selectedFilterModel, outputPath);

	    }
	
	/**
	 * This method creates Filter model object and set values through parameterize constructor
	 * and those to a list
	 * 
	 * @return ArrayList<Filterdel> a list of filter model object
	 * 
	 */
	
	  private static ArrayList<FilterModel> initFilterModel() {
	        FilterModel fm0 = new FilterModel(0, "GrayScale_Filter", new double[0][0]);
	        FilterModel fm1 = new FilterModel(1, "Identity_Filter", FilterMatrix.IdentityMatrix);
	        FilterModel fm2 = new FilterModel(2, "EdgeDetection1_Filter", FilterMatrix.EdgeDetectionMatrixType1);
	        FilterModel fm3 = new FilterModel(3, "EdgeDetection2_Filter", FilterMatrix.EdgeDetectionMatrixType2);
	        FilterModel fm4 = new FilterModel(4, "Laplacian_Filter", FilterMatrix.LaplacianMatrix);
	        FilterModel fm5 = new FilterModel(5, "Sharpen_Filter", FilterMatrix.SharpenMatrix);
	        FilterModel fm6 = new FilterModel(6, "Horizontal_Lines_Filter", FilterMatrix.HorizontalLinesMatrix);
	        FilterModel fm7 = new FilterModel(7, "Vertical_Lines_Filter", FilterMatrix.VerticalLinesMatrix);
	        FilterModel fm8 = new FilterModel(8, "Diagonal_Lines_Filter", FilterMatrix.DiagonalLinesMatrix);
	        FilterModel fm9 = new FilterModel(9, "Sobel_Horizontal_Filter", FilterMatrix.SobelHorizontalMatrix);
	        FilterModel fm10 = new FilterModel(10, "Sobel_Vertical_Filter", FilterMatrix.SobelVerticalMatrix);
	        FilterModel fm11 = new FilterModel(11, "Box_Blur_Filter", FilterMatrix.BoxBlurMatrix);
	        FilterModel fm12 = new FilterModel(12, "Gaussian_Blur_Filter", FilterMatrix.GaussianBlurMatrix);
	        ArrayList<FilterModel> filterModelArrayList = new ArrayList<>();
	        filterModelArrayList.add(0,fm0);
	        filterModelArrayList.add(1, fm1);
	        filterModelArrayList.add(2, fm2);
	        filterModelArrayList.add(3, fm3);
	        filterModelArrayList.add(4, fm4);
	        filterModelArrayList.add(5, fm5);
	        filterModelArrayList.add(6, fm6);
	        filterModelArrayList.add(7, fm7);
	        filterModelArrayList.add(8, fm8);
	        filterModelArrayList.add(9, fm9);
	        filterModelArrayList.add(10, fm10);
	        filterModelArrayList.add(11, fm11);
	        filterModelArrayList.add(12, fm12);
	        return filterModelArrayList;
	    }
	

	
	
	/**
	 * this method check if the user selection is a number from 1 to 4
	 * 
	 * @param choiceStr user selection from main menu
	 * @return boolean return true if the chioceStr matches the regular expression else return false 
	 */
	  private boolean checkIfNumber(String choiceStr) {
	        if (choiceStr.matches("[1-4]")) {
	            return true;
	        }
	        return false;
	    }
    
}//MenuController


