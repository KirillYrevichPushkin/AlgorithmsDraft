package WTG.draft.scriptDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStringTemp {
    public static void main(String[] args) {
        String str = new String("{\"type\":\"FeatureCollection\",\"properties\":{\"ResponseMetaData\":{\"SearchResponse" +
                "\":{\"found\":1,\"display\":\"single\",\"boundedBy\":[[38.971055,45.041343],[38.979266,45.047164]]}," +
                "\"SearchRequest\":{\"request\":\"Рашпилевская_улица,_130/1,_Краснодар,_Краснодарский_край,_Россия,_350020\"," +
                "\"skip\":0,\"results\":10,\"boundedBy\":[[37.048427,55.43644866],[38.175903,56.04690174]]}}}," +
                "\"features\":[{\"type\":\"Feature\",\"geometry\":{\"type\":\"Point\"," +
                "\"coordinates\":[38.97,45.0443]},\"properties\":{\"name\":\"Рашпилевская улица, 130/1\"," +
                "\"description\":\"Краснодар, Россия\",\"boundedBy\":[[38.971055,45.041343],[38.979266,45.047164]]," +
                "\"GeocoderMetaData\":{\"precision\":\"exact\",\"text\":\"Россия, Краснодар, Рашпилевская улица, 130/1\"," +
                "\"kind\":\"house\"}}}]}\n");
        //[38.97516,45.044253]

        System.out.println(str);

        List<Double> coordinateList = new ArrayList<>();
        coordinateList =  Arrays.stream((str.substring(str.indexOf("coordinate") +14, str.lastIndexOf("]},")))
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
