package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainJSONParser {

    public static void main(String[] args) {
        File file = new File("src/main/java/HTTP/MKRF/requestJSON.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file));) {
            String json = br.readLine();

            System.out.println(json);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            Map<String, Object> objectMap = om.readValue(json, new TypeReference<>(){});

           // List<Datum> datum = om.readValue( (List<String>)objectMap.get("data"), new TypeReference<List<Datum>>(){});
            String datumList =  objectMap.get("data").toString();
            System.out.println(datumList.length());
            System.out.println("Datum ");
            System.out.println(datumList.toString());

            System.out.println("with converter");
            Welcome welcome = Converter.fromJsonString(json);
            System.out.println(welcome.toString());

            System.out.println();
            List<Datum> dl = welcome.getData();

            System.out.println();
            System.out.println(dl.get(0).getData().getGeneral().getName());
            System.out.println(dl.get(0).getData().getGeneral().getDescription());
            System.out.println(dl.get(0).getData().getGeneral().getStart());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
