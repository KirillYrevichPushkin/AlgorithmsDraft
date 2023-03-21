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
        BufferedReader reader = null;
        String payload = "body ";
        String request ="";
        File file = new File("src/main/java/HTTP/MKRF/requestJSON.txt");
 //       String baseUrl = "https://opendata.mkrf.ru/v2/events/$?f={\"data.general.start\":{\"$gt\":\"2017-03-22T00:00:00Z\"},\"data.general.organizerPlace.name\":{\"$contain\":\"Краснодар\"}}&l=10";

        String baseUrl = "http://95.163.237.3:8179/wtg/api/v1/locations/manualTitle?manualTitle=";
        byte[] englishBytes = baseUrl.getBytes();


        String newUrl = null;
        try {
            newUrl = new String(englishBytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
 //       newUrl = "http://95.163.237.3:8179/wtg/api/v1/locations/manualTitle?manualTitle=музей";

        try(
            BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
 //           URL url = new URL("https://opendata.mkrf.ru/v2/events/$?f={\"data.general.start\":{\"$gt\":\"2017-03-22T00:00:00Z\"},\"data.general.organizerPlace.name\":{\"$contain\":\"Краснодар\"}}&l=10");
 //           URL url = new URL("http://localhost:8180/locations-events/api/v1?page=1&pageSize=5");
  //          URL url = new URL("https://opendata.mkrf.ru/v2/events/$?l=10");

           // URL url = new URL( String.format( newUrl + "%s", URLEncoder.encode("музей", "utf-8")));
            URL url = new URL( String.format( "https://opendata.mkrf.ru/v2/events/$?f={\"data.general.start\":{\"$gt\":\"2017-03-22T00:00:00Z\"},\"data.general.organizerPlace.name\":{\"$contain\":\"%s\"}}&l=10", URLEncoder.encode("Краснодар", "utf-8")));


            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(3 * 1000);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
  //          connection.setRequestProperty("User-Agent", "PostmanRuntime/7.29.2");
            connection.setRequestProperty("Accept", "*/*");
 //           connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Connection", "keep-alive");
//            connection.setRequestProperty("page", "1");
//            connection.setRequestProperty("pageSize", "5");
            connection.setRequestProperty("X-API-KEY", "af350147e9f8b7c07c1bcd5f44f7727e1db576b92fe1a59c5ec089e40c48ea63");

            BufferedReader br = new BufferedReader( new InputStreamReader( connection.getInputStream()), 65536);

//            if (payload != null) {
//                OutputStream os = connection.getOutputStream();
//
//                os.write(payload.getBytes(StandardCharsets.UTF_8));
//
//                os.flush();
//                os.close();
//            }




       //     for (int i = 0; i < 2; i++) {
                request = br.readLine();
           //     System.out.println("request " + request);
                bw.write(request);
         //   }



            System.out.println(" url " + connection.getURL());

            int responseCode = connection.getResponseCode();

            System.out.println("responseCode " + responseCode);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Map<String, Object> objectMap = om.readValue(request, new TypeReference<>(){});

//            for (Map.Entry me:objectMap.entrySet()  ) {
//
//            }

//            for (String key: objectMap.keySet() ) {
//                System.out.println("key = " + key);
//            }

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
