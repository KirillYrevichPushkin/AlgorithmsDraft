package fcons;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FCUtils {


  public static Map<LocalDateTime, Double> evalRSI(List<Candle> candles, int period) {
    Map<LocalDateTime, Double> response = new TreeMap<>();
    if (candles.size() > period) {
      for (int i = period - 1; i < candles.size(); i++) {
        double up = 0;
        double down = 0;
        for (int j = i - (period - 2); j <= i; j++) {
          if (candles.get(j).getClose() > candles.get(j - 1).getClose()) {
            up += candles.get(j).getClose() - candles.get(j - 1).getClose();
          }
          if (candles.get(j).getClose() < candles.get(j - 1).getClose()) {
            down += candles.get(j - 1).getClose() - candles.get(j).getClose();
          }
        }
        response.put(candles.get(i).getDateTime(), up / (down + up) * 100);
      }
    }
    return response;
  }

  public static Map<LocalDateTime, Double> expAVG(List<Candle> candles, int period, double coeff) {
    Map<LocalDateTime, Double> response = new TreeMap<>();
    if (candles.size() > period) {
      for (int i = period - 1; i < candles.size(); i++) {
        response.put(candles.get(i).getDateTime(), exp(candles, i, i - (period - 1), coeff ));
      }
    }
    return response;
  }

  private static double exp(List<Candle> candles, int currentIndex, int endIndex, double coeff) {
    if (currentIndex == endIndex) {
      return candles.get(currentIndex).getClose();
    } else {
      return coeff * candles.get(currentIndex).getClose() + (1 - coeff) * exp(candles,
          currentIndex - 1, endIndex, coeff);
    }
  }


//  public static Map<LocalDateTime, Double> expAVG2(Map<LocalDateTime, Double> candles, int period, double coeff) {
//    Map<LocalDateTime, Double> response = new TreeMap<>();
//    if (candles.size() > period) {
//
//
//
//      for (LocalDateTime i = candles. period - 1; i < candles.size(); i =  i.plusDays(1L)) {
//        response.put(candles.get(i).getDateTime(), exp(candles, i, i - (period - 1), coeff ));
//      }
//    }
//    return response;
//  }

  public static Map<LocalDateTime, Double> evalDifference (Map<LocalDateTime, Double> a, Map<LocalDateTime, Double> b){
    Map<LocalDateTime, Double> response = new TreeMap<>();
    for (Entry<LocalDateTime, Double> as : a.entrySet()) {
      response.put(as.getKey(),as.getValue() - (b.getOrDefault(as.getKey(), 0.0)));
    }
    return response;
  }


}
