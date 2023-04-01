package TestTask.BaltInfocom.cynteka;

import java.io.*;
import java.util.*;

public class MainCynteka2 {

    public static void main(String[] args) {

        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();

        File fileInput = new File("src/main/java/TestTask/BaltInfocom/cynteka/input.txt");
        File fileOutput = new File("src/main/java/TestTask/BaltInfocom/cynteka/output2.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(fileInput));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileOutput))) {
            int quantityList1 = Integer.parseInt( br.readLine());

            for (int i = 0; i < quantityList1; i++) {
                list1.add(br.readLine());
            }

            int quantityList2 = Integer.parseInt( br.readLine());
            String line;

            for (int i = 0; i < quantityList2; i++) {
                line = br.readLine();
                Iterator<String> iterator = list1.iterator();
                while (iterator.hasNext()){
                    String thisString = iterator.next();
                    if(comparingString(thisString,line)){
                        bw.write(thisString + ":" + line + "\n");
                        bw.flush();
                        iterator.remove();
                        line = null;
                        break;
                    }
                }
                if(line != null) {
                    list2.add(line);
                }
            }

            if(list2.size() > 0){
                for (String s:list2  ) {
                    bw.write(s + ":?" + "\n");
                    bw.flush();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean comparingString (String line1, String line2){
        String[] row1 = line1.split(" ");
        for (String s : row1) {
            if (line2.contains(s)) {
                return true;
            }
        }
        return false;
    }

}
