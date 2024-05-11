package ML;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class DetMatr {

  public static void main(String[] args) {
    double[][] data = {
        {5.0,  7.0, -5.0},
        {0.0, -2.0,  2.0},
        {-4.0, -8.0, -7.0},
        {1.0,  1.0,  2.0},
        {2.0, -1.0,  2.0},
        {4.0,  1.0,  4.0}
    };

    double[]vec = {-47.0, 10.0, 63.0, -1.0, -4.0, -2.0};

    RealMatrix rm = new Array2DRowRealMatrix(data);

    RealVector rv = new ArrayRealVector(vec);
    RealMatrix rmT = rm.transpose();

    RealMatrix mul = rmT.multiply(rm);
    LUDecomposition multyLUD = new LUDecomposition(mul);
    System.out.println(multyLUD.getDeterminant());
    RealMatrix preMinverse = MatrixUtils.inverse(mul,0);

    RealMatrix pseudoInverse = preMinverse.multiply(rmT);
    RealVector bestPoint = pseudoInverse.operate(rv);


    System.out.println(bestPoint);

  }

}
