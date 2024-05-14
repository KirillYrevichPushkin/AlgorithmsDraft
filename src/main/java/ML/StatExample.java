package ML;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;

public class StatExample {

  public static void main(String[] args) {
    double[] values = new double[] { 2.3, 5.4, 6.2, 7.3, 23.3 };

    System.out.println("min: " + StatUtils.min(values));
    System.out.println("max: " + StatUtils.max(values));
    System.out.println("mean: " + StatUtils.mean(values));
    System.out.println("product: " + StatUtils.product(values));
    System.out.println("sum: " + StatUtils.sum(values));
    System.out.println("variance: " + StatUtils.variance(values));

    // Measures from previous example
    Min min = new Min();
    System.out.println("min: " + min.evaluate(values));
    Max max = new Max();
    System.out.println("max: " + max.evaluate(values));
    Mean mean = new Mean();
    System.out.println("mean: " + mean.evaluate(values));
    Product product = new Product();
    System.out.println("product: " + product.evaluate(values));
    Sum sum = new Sum();
    System.out.println("sum: " + sum.evaluate(values));
    Variance variance = new Variance();
    System.out.println("variance: " + variance.evaluate(values));

    // New measures
    Percentile percentile = new Percentile();
    System.out.println("80 percentile value: " + percentile.evaluate(values, 80.0));
    GeometricMean geoMean = new GeometricMean();
    System.out.println("geometric mean: " + geoMean.evaluate(values));
    StandardDeviation stdDev = new StandardDeviation();
    System.out.println("standard dev: " + stdDev.evaluate(values));
    Skewness skewness = new Skewness();
    System.out.println("skewness: " + skewness.evaluate(values));
    Kurtosis kurtosis = new Kurtosis();
    System.out.println("kurtosis: " + kurtosis.evaluate(values));

  }
}
