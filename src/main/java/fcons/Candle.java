package fcons;

import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candle implements Comparable{

  private String name;
  private Enum <Period> period;
  private LocalDateTime dateTime;
  private double open;
  private double high;
  private double low;
  private double close;
  private double vol;




  public boolean isMaxClose(){
    double percent = 0.07;
    double maxPercent = (Math.abs(high - low))*100/Math.min(high,low);
    double per = maxPercent * percent;
    double v = (Math.abs(close - high)) * 100 / close;
    return  (Math.abs(close-high))*100/close < per;
  }

  public boolean isMinClose(){
    double percent = 0.07;
    double maxPercent = (Math.abs(high - low))*100/Math.min(high,low);
    double per = maxPercent * percent;
    double v = (Math.abs(close - low)) * 100 / close;
    return  (Math.abs(close-low))*100/close < per;
  }

  public boolean isBigCandle(Candle c){
    return open < c.getOpen() && close > c.getClose();
  }

  @Override
  public int compareTo(Object o) {
    Candle another = (Candle) o;
    return this.getDateTime().compareTo(another.getDateTime());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Candle candle = (Candle) o;
    return name.equals(candle.name) && period.equals(candle.period) && dateTime.equals(
        candle.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dateTime);
  }




}

enum Period {
  DAY,
  HOUR,
  WEEK
}

