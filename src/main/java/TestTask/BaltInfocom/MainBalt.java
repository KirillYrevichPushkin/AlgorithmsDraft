package TestTask.BaltInfocom;

import java.io.*;
import java.util.*;

public class MainBalt {
    public static void main(String[] args) {

        File file = new File("D:\\Download\\lng1.txt");
        Set<String> stringSet = new TreeSet<>();
        List<Group> groups = new ArrayList<>(300);

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            long t1 = System.currentTimeMillis();
        String line = br.readLine();
        while (line!=null){
            System.out.println(line);
            stringSet.add(line);

            line = br.readLine();
        }
            long t2 = System.currentTimeMillis()- t1;
            System.out.println("time = " + t2);
            System.out.println(stringSet.size());

            Iterator<String> stringIterator = stringSet.iterator();
            String [] stringsTemp;
            boolean add;
            long t3 = System.currentTimeMillis();
            while (stringIterator.hasNext()){
                add=false;
               // System.out.print("!");
                stringsTemp = stringIterator.next().split(";");


                for (Group g:groups ) {
                    add = g.addStringArr(stringsTemp);
                    if(add) break;
                }
                if(!add){
                    groups.add(new Group(stringsTemp));
                }

            //    System.out.print("/");
            }
            long t4 = System.currentTimeMillis()- t3;


            System.out.println("-*-*-*-*-*-*-");
            groups.stream().forEach(System.out::println);
            System.out.println("time = " + t4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;



    }
}

class Group{

    int count;
    List<String[]> listStrings;

    public Group(String[] strings) {
        this.count = 1;
        this.listStrings = new ArrayList<>();
        listStrings.add(strings);
    }

    public int getCount() {
        return count;
    }

    public boolean addStringArr(String[] strings){
        for (String[] sArr: listStrings ) {
            for (int i = 0; i < sArr.length && i < strings.length; i++) {
                if(sArr[i].equals(strings[i])&& !(sArr[i].equals(""))){
                    listStrings.add(strings);
                    count++;
                    return true;
                }
            }
        }
        return false;
    }

    public List<String[]> getListStrings() {
        return listStrings;
    }

    public void setListStrings(List<String[]> listStrings) {
        this.listStrings = listStrings;
    }

    @Override
    public String toString() {
        return "Group{" +
                "count=" + count +
                ", listStrings=" + listStrings +
                '}';
    }
}
