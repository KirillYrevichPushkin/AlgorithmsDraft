package HTTP.MKRF;

import HTTP.MKRF.JsonClasses.Datum;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MainMKRF {




    public static void main(String[] args) {

        HttpURLConnection connection = null;
        String request ="";
        File file = new File("src/main/java/HTTP/MKRF/requestJSON.txt");
 //       String baseUrl = "https://opendata.mkrf.ru/v2/events/$?f={\"data.general.start\":{\"$gt\":\"2017-03-22T00:00:00Z\"},\"data.general.organizerPlace.name\":{\"$contain\":\"Краснодар\"}}&l=10";

        try(
            BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            URL url = new URL( String.format( "https://opendata.mkrf.ru/v2/events/$?f={\"data.general.start\":{\"$gt\":\"2017-03-22T00:00:00Z\"},\"data.general.organizerPlace.name\":{\"$contain\":\"%s\"}}&l=1000", URLEncoder.encode("Краснодар", "utf-8")));


            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(3 * 1000);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("X-API-KEY", "af350147e9f8b7c07c1bcd5f44f7727e1db576b92fe1a59c5ec089e40c48ea63");

            BufferedReader br = new BufferedReader( new InputStreamReader( connection.getInputStream()), 65536);

                request = br.readLine();
           //     System.out.println("request " + request);
                bw.write(request);



            System.out.println(" url " + connection.getURL());

            int responseCode = connection.getResponseCode();

            System.out.println("responseCode " + responseCode);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Map<String, Object> objectMap = om.readValue(request, new TypeReference<>(){});


            Datum datum = om.readValue( (String)objectMap.get("data"), Datum.class);
            System.out.println("Datum ");
            System.out.println(datum.toString());



            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }


    }

}
