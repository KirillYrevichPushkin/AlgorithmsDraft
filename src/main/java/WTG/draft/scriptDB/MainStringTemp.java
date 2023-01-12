package WTG.draft.scriptDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStringTemp {
    public static void main(String[] args) {
//        String str = new String("{\"type\":\"FeatureCollection\",\"properties\":{\"ResponseMetaData\":{\"SearchResponse" +
//                "\":{\"found\":1,\"display\":\"single\",\"boundedBy\":[[38.971055,45.041343],[38.979266,45.047164]]}," +
//                "\"SearchRequest\":{\"request\":\"Рашпилевская_улица,_130/1,_Краснодар,_Краснодарский_край,_Россия,_350020\"," +
//                "\"skip\":0,\"results\":10,\"boundedBy\":[[37.048427,55.43644866],[38.175903,56.04690174]]}}}," +
//                "\"features\":[{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\"," +
//                "\"coordinates\":[38.97,45.0443]},\"properties\":{\"name\":\"Рашпилевская улица, 130/1\"," +
//                "\"description\":\"Краснодар, Россия\",\"boundedBy\":[[38.971055,45.041343],[38.979266,45.047164]]," +
//                "\"GeocoderMetaData\":{\"precision\":\"exact\",\"text\":\"Россия, Краснодар, Рашпилевская улица, 130/1\"," +
//                "\"kind\":\"house\"}}}]}\n");

        String str = new String("Витаминкомбинат,_Краснодарский_край,_Россия,_350031&type=geo&lang=ru_RU&apikey=56a66ddf-edfc-40a0-b66e-f59f7826e136\n" +
                "{\"type\":\"FeatureCollection\",\"properties\":{\"ResponseMetaData\":{\"SearchResponse\":" +
                "{\"found\":7,\"display\":\"single\",\"boundedBy\":[[38.984575,45.142962],[39.003529,45.15298]]}," +
                "\"SearchRequest\":{\"request\":\"Tselinogradskaya_Ulitsa,_32,_Витаминкомбинат,_Краснодарский_край,_Россия,_350031\"," +
                "\"skip\":0,\"results\":10,\"boundedBy\":[[37.048427,55.43644866],[38.175903,56.04690174]]}}}," +
                "\"features\":[{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\"," +
                "\"coordinates\":[38.992893,45.148429]}," +
                "\"properties\":{\"name\":\"микрорайон Витаминкомбинат\",\"description\":\"посёлок Берёзовый, муниципальное образование Краснодар, Россия\"," +
                "\"boundedBy\":[[38.984575,45.142962],[39.003529,45.15298]],\"GeocoderMetaData\":{\"precision\":\"other\"," +
                "\"text\":\"Россия, муниципальное образование Краснодар, посёлок Берёзовый, микрорайон Витаминкомбинат\"," +
                "\"kind\":\"district\"}}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\"," +
                "\"coordinates\":[39.003457,45.151944]}," +
                "\"properties\":{\"name\":\"остановочный пункт Берёзовый\",\"description\":\"Тимашевское направление, Краснодарский край, Россия\"," +
                "\"boundedBy\":[[38.995229,45.146121],[39.011686,45.157766]],\"GeocoderMetaData\":{\"precision\":\"other\"," +
                "\"text\":\"Россия, Краснодарский край, Тимашевское направление, остановочный пункт Берёзовый\"," +
                "\"kind\":\"railway_station\"}}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\"," +
                "\"coordinates\":[38.989623,45.161789]}," +
                "\"properties\":{\"name\":\"посёлок Берёзовый, 34\",\"description\":\"муниципальное образование Краснодар, Россия\"," +
                "\"boundedBy\":[[38.985518,45.158885],[38.993728,45.164694]],\"GeocoderMetaData\":{\"precision\":\"near\"," +
                "\"text\":\"Россия, муниципальное образование Краснодар, посёлок Берёзовый, 34\",\"kind\":\"house\"}}},{\"type\":\"Feature\"," +
                "\"geometry\":{\"type\":\"Point\",\"coordinates\":[39.041645,45.086556]},\"properties\":{\"name\":\"посёлок Краснодарский, 32\"," +
                "\"description\":\"муниципальное образование Краснодар, Россия\",\"boundedBy\":[[39.037539,45.083648],[39.04575,45.089464]]," +
                "\"GeocoderMetaData\":{\"precision\":\"exact\",\"text\":\"Россия, муниципальное образование Краснодар, посёлок Краснодарский, 32\"," +
                "\"kind\":\"house\"}}},{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\"," +
                "\"coordinates\":[38.315168,45.282868]}," +
                "\"properties\":{\"name\":\"посёлок Краснодарский\",\"description\":\"Октябрьское сельское поселение, Красноармейский район, Россия\"," +
                "\"boundedBy\":[[38.310685,45.281283],[38.323298,45.288873]],\"GeocoderMetaData\":{\"precision\":\"other\",\"text\":" +
                "\"Россия, Красноармейский район, Октябрьское сельское поселение, посёлок Краснодарский\",\"kind\":\"locality\"}}},{" +
                "\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[41.216888,45.394277]},\"properties\":{" +
                "\"name\":\"хутор Краснодарский\",\"description\":\"Новоалександровский городской округ, Ставропольский край, Россия\"," +
                "\"boundedBy\":[[41.20742,45.386738],[41.22827,45.399099]],\"GeocoderMetaData\":{\"precision\":\"other\",\"text\":" +
                "\"Россия, Ставропольский край, Новоалександровский городской округ, хутор Краснодарский\",\"kind\":\"locality\"}}},{" +
                "\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[38.948903,45.006629]},\"properties\":{" +
                "\"name\":\"остров Краснодарский\",\"description\":\"Яблоновское городское поселение, Тахтамукайский район, Республика Адыгея, Россия\"," +
                "\"boundedBy\":[[38.947771,45.004079],[38.950097,45.009879]],\"GeocoderMetaData\":{\"precision\":\"other\"," +
                "\"text\":\"Россия, Республика Адыгея, Тахтамукайский район, Яблоновское городское поселение, остров Краснодарский\"," +
                "\"kind\":\"other\"}}}]}\n");
        //[38.97516,45.044253]

        System.out.println(str);

        List<Double> coordinateList = new ArrayList<>();
        coordinateList =  Arrays.stream((str.substring(str.indexOf("coordinate") +14, str.lastIndexOf("]},", str.indexOf("coordinate") +14 + 21)))
                .split(","))
                .map( s -> {
                    String st = s.replace("]","0");
                    return Double.parseDouble(st);
                }).collect(Collectors.toList());



        System.out.println("coordinate = " + coordinateList.get(0) + ", " + coordinateList.get(1));

        System.out.println("indexOf " + str.indexOf("coordinate"));
        System.out.println("lastIndexOf " + str.lastIndexOf("]},"));



    }

}
