package fcons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FCMain {

  public static void main(String[] args) throws IOException {

    Path p = Path.of("src/main/java/fcons/SBER_190209_240210.csv");
    Path plog = Path.of("src/main/java/fcons/test.log");

    FileReader fr = new FileReader(p.toFile());
    BufferedReader br = new BufferedReader(fr);

    List<Candle> candles = getCandles(p);
    List<Candle> bigCandles = new ArrayList<>();
    for (int i = 1; i < candles.size(); i++) {
      if(candles.get(i).isBigCandle(candles.get(i-1))){
        bigCandles.add(candles.get(i));
      }
    }

    List<Candle> candleMax = candles.stream().filter(Candle::isMaxClose)
        .collect(Collectors.toList());

    List<Candle> candleMin = candles.stream().filter(Candle::isMinClose)
        .collect(Collectors.toList());

    Map<LocalDateTime, Double> rsiMap = FCUtils.evalRSI(candles, 9);

    Map<LocalDateTime, Double> mapExpAVG = FCUtils.expAVG(candles, 9, 0.8);

    Map<LocalDateTime, Double> expAVG26 = FCUtils.expAVG(candles, 26, 0.8);
    Map<LocalDateTime, Double> expAVG12 = FCUtils.expAVG(candles, 12, 0.8);
    Map<LocalDateTime, Double> KDSS = FCUtils.evalDifference(expAVG12, expAVG26);
    List<Candle> kdssList = getDeprecatedCandle(KDSS);
    Map<LocalDateTime, Double> signalLine = FCUtils.expAVG(kdssList, 9, 0.8);

    Map<LocalDateTime, Double> MACD = FCUtils.evalDifference(KDSS, signalLine);

    clearLog(plog);



    System.out.println("hi!");


  }


  private static List<Candle> getDeprecatedCandle(Map<LocalDateTime, Double> src){
    List<Candle> response = new ArrayList<>();
    for (Entry<LocalDateTime, Double> es : src.entrySet()) {
      Candle c = new Candle();
      c.setDateTime(es.getKey());
      c.setClose(es.getValue());
      response.add(c);
    }
    return response;
  }




  private static List<Candle> getCandles(Path path) throws FileNotFoundException {
    BufferedReader br = new BufferedReader(new FileReader(path.toFile()));

    return br.lines()
        .filter(l -> !l.contains("TICKER"))
        .map(l -> {
          String[] el = l.split(",");
          String date = "20"+el[2];
          LocalDate ld = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
          Period p;

          if(el[1].equals("D")){
            p = Period.DAY;
          }else {
            p = Period.HOUR;
          }

          return new Candle(el[0], p, ld.atStartOfDay(),
              Double.parseDouble(el[4]), Double.parseDouble(el[5]), Double.parseDouble(el[6]),
              Double.parseDouble(el[7]), Double.parseDouble(el[8]));
        })
        .sorted()
        .collect(Collectors.toList());
  }

  private static void clearLog(Path path) {
    String updatedLog1 = "";
    String updatedLog = "";
    try {
      try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
        updatedLog1 = br
            .lines()
//            .map(l -> l.replaceAll("CPLEX", "DEFAULT"))
//            .map(l -> l.replaceAll("Cplex", "Default"))
//            .map(l -> l.replaceAll("cplex", "default"))
//            .map(l -> l.replaceAll("Cpx", "df"))
            .map(l -> clearString(l))
            .reduce("", (l, c) -> l + " \n " + c);

        //updatedLog = clearString(updatedLog1);

        System.out.println("start");
        System.out.println(updatedLog);
        System.out.println("end");
      }
      //BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()));
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()))) {
        bw.write(updatedLog);
        bw.flush();
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  private static String clearString(String str){
    return str.replaceAll("CPLEX", "DEFAULT")
        .replaceAll("Cplex", "Default")
        .replaceAll("cplex", "default")
        .replaceAll("Cpx", "df");
  }




}


