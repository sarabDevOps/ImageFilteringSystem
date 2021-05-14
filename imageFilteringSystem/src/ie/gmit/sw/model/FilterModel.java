package ie.gmit.sw.model;

import java.util.Arrays;

/**
 * This class is a Model Class , to store Kernel Matrix , id and
 * filter name and contains getters and setters methods
 *  
 * @author sarab jeet
 *@version 1.0
 */
public class FilterModel {
	
	private int FilterId;
	private String FilterName;
	private double[][] FilterMatrix;
	
	/**
	 * parameterized constructor
	 * 
	 * @param filterId 		id of the filter type is int
	 * @param filterName 	name of the filter type is String
	 * @param filterMatrix  Kernel matrix on which convolution will be performed 
	 */
	public FilterModel(int filterId , String filterName, double [][] filterMatrix){
		FilterId = filterId;
		FilterName = filterName;
		FilterMatrix = filterMatrix;
	}

	public int getFilterId() {
		return FilterId;
	}

	public void setFilterId(int filterId) {
		FilterId = filterId;
	}

	public String getFilterName() {
		return FilterName;
	}

	public void setFilterName(String filterName) {
		FilterName = filterName;
	}

	public double[][] getFilterMatrix() {
		return FilterMatrix;
	}

	public void setFilterMatrix(double[][] filterMatrix) {
		FilterMatrix = filterMatrix;
	}

	@Override
    public String toString() {
        return "FilterModel{" +
                "FilterId=" + FilterId +
                ", FilterName='" + FilterName + '\'' +
                ", filterMatrix=" + Arrays.toString(FilterMatrix) +
                '}';
    }
	
	
	

}
