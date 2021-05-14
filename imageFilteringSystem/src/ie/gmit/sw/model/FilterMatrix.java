package ie.gmit.sw.model;

/**
 * This class contains different kernel Matrix
 * 
 * @author Sarab jeet
 * @version 1.0
 */


public class FilterMatrix {
	
	public static final double[][] IdentityMatrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };

    public static final double[][] EdgeDetectionMatrixType1 = {
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
    };
    public static final double[][] EdgeDetectionMatrixType2 = {
            {1, -0, -1},
            {0, 0, 0},
            {-1, 0, 1}
    };
    public static final double[][] LaplacianMatrix = {
            {0, -1, 0},
            {-1, 4, -1},
            {0, -1, 0}
    };

    public static final double[][] SharpenMatrix = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
    };
    public static final double[][] HorizontalLinesMatrix = {
            {-1, -1, -1},
            {2, 2, 2},
            {-1, -1, -1}
    };
    public static final double[][] VerticalLinesMatrix = {
            {-1, 2, -1},
            {-1, 2, -1},
            {-1, 2, -1}
    };
    public static final double[][] DiagonalLinesMatrix = {
            {-1, -1, 2},
            {-1, 2, -1},
            {2, -1, -1}
    };
    public static final double[][] SobelHorizontalMatrix = {
            {-1, -2, -1},
            {0, 0, 0},
            {1, 2, 1}
    };
    public static final double[][] SobelVerticalMatrix = {
            {-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}
    };
    public static final double[][] BoxBlurMatrix = {
            {0.11, 0.11, 0.11},
            {0.11, 0.11, 0.11},
            {0.11, 0.11, 0.11}
    };

    public static final double[][] GaussianBlurMatrix = {
            {0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}
    };

	

}
