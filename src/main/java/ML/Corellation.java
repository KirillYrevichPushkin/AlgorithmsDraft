package ML;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.KendallsCorrelation;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

public class Corellation {

  public static void main(String[] args) {
    double [][]data =   {{0.00632,  18.0,   2.31,  0.538,  6.575,  65.2,  4.0900,  1.0,   4.98,   24.0},
                        {0.02731,   0.0,   7.07,  0.469,  6.421,  78.9,  4.9671,  2.0,   9.14,   21.6},
                        {0.02729,   0.0,   7.07,  0.469,  7.185,  61.1,  4.9671,  2.0,   4.03,   34.7},
                        {0.03237,   0.0,   2.18,  0.458,  6.998,  45.8,  6.0622,  3.0,   2.94,   33.4},
                        {0.06905,   0.0,   2.18,  0.458,  7.147,  54.2,  6.0622,  3.0,   5.33,   36.2}};

    RealMatrix dataMatrix = new Array2DRowRealMatrix(data);
    PearsonsCorrelation pc = new PearsonsCorrelation(dataMatrix);
    PearsonsCorrelation pcTemp = new PearsonsCorrelation();
    KendallsCorrelation kc = new KendallsCorrelation(dataMatrix);
    KendallsCorrelation kcTemp = new KendallsCorrelation();
    SpearmansCorrelation sc = new SpearmansCorrelation(dataMatrix);
    SpearmansCorrelation scTemp = new SpearmansCorrelation();
    RealMatrix correlationMatrix = pc.getCorrelationPValues();

    double[] price = getColumn(data, 9);
    double[] rm = getColumn(data, 4);
    double[] lstat = getColumn(data,8);
    double correlationRM = pcTemp.correlation(price, rm);
    double correlationLSTAT = pcTemp.correlation(price, lstat);

    double[]t1 = {1,2,3,4,5,4,3};
    double[]t2 = {2,1,0,-2,-3,-1,-2};
    double correlationTp = pcTemp.correlation(t1, t2);
    double correlationTk = kcTemp.correlation(t1, t2);
    double correlationTs = scTemp.correlation(t1, t2);

    System.out.println(pc);
    System.out.println(correlationMatrix);
    System.out.println("happyEnd");


  }

  private static double[] getColumn (double[][] srcArray , int numberColumn){
    double[] column = new double[srcArray.length];
    for (int i = 0; i < column.length; i++) {
      column[i] = srcArray[i][numberColumn];
    }
    return column;
  }

}
