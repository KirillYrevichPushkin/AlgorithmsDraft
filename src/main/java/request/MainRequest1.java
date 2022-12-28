package request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainRequest1 {

    public static void main(String[] args) throws IOException {
       // URL url = new URL("http://jsonplaceholder.typicode.com/posts?_limit=10");
        URL url = new URL("http://jsonplaceholder.typicode.com/posts");
       // URL url = new URL("https://api.hh.ru/vacancies?text=java&page=1&per_pege=100 ");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestMethod("GET");
   //     con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(1000);
        con.setReadTimeout(1000);


        String responseGet ="";
        responseGet = response(con);
        System.out.println(responseGet);



        URL url2 = new URL("http://jsonplaceholder.typicode.com/posts");
        HttpURLConnection con2 = (HttpURLConnection)url2.openConnection();
        con2.setRequestMethod("POST");
      //  con2.setRequestProperty("Content-Type", "application/json");

        con2.setConnectTimeout(1000);
        con2.setReadTimeout(1000);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "1");
        parameters.put("title", "foo");
        parameters.put("body", "bar");
        parameters.put("userId", "12");

        con2.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con2.getOutputStream());
        out.writeBytes(getParamsString(parameters));
        out.flush();
        out.close();

        System.out.println("POST++++");
        String responsePost ="";
       // responsePost = response(con2);
        System.out.println(responsePost);

        writeToFile(responseGet + "\n" + responsePost);

        con.disconnect();
        con2.disconnect();
    }

    public static String response(HttpURLConnection con){
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                content.append("\n");
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }



    public static String getParamsString(Map<String,String> params){
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            try {
                result.append(URLEncoder.encode(name, "UTF-8"));
                result.append('=');
                result.append(URLEncoder.encode(value, "UTF-8"));
                result.append('&');
            } catch (final UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });

        final String resultString = result.toString();
        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;

    }

    public static void writeToFile(String msg){
        File file = new File("src/main/java/request/response.txt");

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {

            dos.writeUTF(msg);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
