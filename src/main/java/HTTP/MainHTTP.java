package HTTP;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;

import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class MainHTTP {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                //.uri(new URI("https://postman-echo.com/get"))
//              .uri(new URI("https://search-maps.yandex.ru/v1/?text=улица 1 Мая, 214, Краснодар, Краснодарский край, Россия&type=geo&lang=ru_RU&apikey=56a66ddf-edfc-40a0-b66e-f59f7826e136"))
                .uri(new URI("https://search-maps.yandex.ru/v1/?text=улица_1_Мая,_214,_Краснодар,_Краснодарский_край,_Россия&type=geo&lang=ru_RU&apikey=56a66ddf-edfc-40a0-b66e-f59f7826e136"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .proxy(ProxySelector.getDefault())
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());


        System.out.println(request.toString());
        System.out.println(response.toString());
        System.out.println(response.body().toString());

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> tempJson = objectMapper.readValue(response.body().toString(), new TypeReference<>(){});




        String[] coordinate = response.body().toString().split("coordinates\":\\[");
        System.out.println("coordinate 0" + coordinate[0]);
        System.out.println("coordinate 1" + coordinate[1]);
        String[] coordinatelast = coordinate[1].split("\\]");
        String[] coordinateEnd = coordinatelast[0].split(",");
        System.out.println("long = " + coordinateEnd[0] + " lat = " + coordinateEnd[1]);
        for ( Map.Entry<String, Object> entry: tempJson.entrySet()  ) {
            System.out.println("key = " + entry.getKey() + " value " + entry.getValue());
        }




    }



}
