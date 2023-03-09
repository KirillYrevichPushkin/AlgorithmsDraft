package TestTask.BaltInfocom.cynteka;

import java.io.*;
import java.util.*;

public class MainCynteka {

    public static Map<String, String> mapString = new HashMap<>();

    public static void main(String[] args) {
        File fileInput = new File("src/main/java/TestTask/BaltInfocom/cynteka/input.txt");
        File fileOutput = new File("src/main/java/TestTask/BaltInfocom/cynteka/output.txt");
        List<String> stringToAdd = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileInput))) {
            int countList1 = Integer.parseInt( br.readLine());

            for (int i = 0; i < countList1; i++) {
                mapString.put(br.readLine(), "?");
            }

            for (Map.Entry<String, String> me: mapString.entrySet() ) {
                System.out.println("key = " + me.getKey() + " value = " + me.getValue());
            }

            int countList2 = Integer.parseInt( br.readLine());
            String line;
            String [] arrString;
            for (int i = 0; i < countList2; i++) {
                line = br.readLine();
                arrString = line.split(" ");

                for (Map.Entry<String, String> me: mapString.entrySet() ) {
                    for (int j = 0; j < arrString.length; j++) {
                        if(me.getKey().contains(arrString[j])){
                                me.setValue(line);
                                break;
                        }
                        if(j == arrString.length){
                            stringToAdd.add(line);
                        }
                    }
                }
            }
            for (int i = 0; i < stringToAdd.size(); i++) {
                mapString.put(stringToAdd.get(i),"?");
            }


            System.out.println("----");
            for (Map.Entry<String, String> me: mapString.entrySet() ) {
                System.out.println("key = " + me.getKey() + " value = " + me.getValue());
            }







        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileOutput));){
            for (Map.Entry<String, String> me: mapString.entrySet() ) {
            bw.write(String.format(me.getKey() + ":" + me.getValue()));
            bw.newLine();
            bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
