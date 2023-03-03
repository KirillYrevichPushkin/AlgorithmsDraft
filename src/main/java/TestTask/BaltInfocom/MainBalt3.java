package TestTask.BaltInfocom;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainBalt3 {
//    static Pattern pattern1 = Pattern.compile("\"\\d{1,10}\"");
//    static Pattern pattern2 = Pattern.compile("\"\\d{12,}\"");
//    static Matcher matcher1;
//    static Matcher matcher2;

    public static void main(String[] args) {
        File file = new File("D:\\Download\\lngmaxtest2.txt");
        Set<String> stringSet = new TreeSet<>();
        List<Row> rows = new ArrayList<>(300);
        //Map<String, List<Row>> stringListMap = new HashMap<>(6000000);
        Map<String, List<Row>> stringListMap = new HashMap<>(6000000);
        int maxSize = 0;

        long t1 = System.currentTimeMillis();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line = br.readLine();
            while (line != null) {
             //   System.out.println(line);
//                matcher1 = pattern1.matcher(line);
//                matcher2 = pattern2.matcher(line);
//                if(matcher1.find() || matcher2.find()){
//                    System.out.println(line);
//                    continue;
//                }
                stringSet.add(line);
                line = br.readLine();
            }

            long t2 = System.currentTimeMillis()- t1;
            System.out.println("time2 добавление в сет = " + t2);
            System.out.println("stringSet = " + stringSet.size());

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        String[] tempString;
        Row tempRow;
        int numberGroup = 0;
        Iterator<String> stringIterator = stringSet.iterator();
        long t3 = System.currentTimeMillis();
        while (stringIterator.hasNext()) {
            tempString = stringIterator.next().split(";");
            tempRow = new Row(tempString);
            if(tempString.length > maxSize) maxSize = tempString.length;
            rows.add(tempRow);
            for (int i = 0; i < tempString.length; i++) {
                List<Row> rowList;
                if(tempString[i].equals("\"\"")) continue;
                if(stringListMap.containsKey(tempString[i])){
                    rowList = stringListMap.get(tempString[i]);
                }else {
                    rowList = new ArrayList<>();
                }
                rowList.add(tempRow);
                stringListMap.put(tempString[i], rowList);
            }

        }
        long t4 = System.currentTimeMillis() - t3;
        long t5 = System.currentTimeMillis();

        for (Map.Entry<String, List<Row>> me: stringListMap.entrySet()) {
            if(me.getValue().size()==1){
                continue;
            }else {
                int maxLength = 0;
                Row tempRowMap;
                for (int i = 0; i < me.getValue().size(); i++) {
                    tempRowMap = me.getValue().get(i);
                    if(tempRowMap.getStringRow().length > maxLength) maxLength = tempRowMap.getStringRow().length;
                }
                int[] arrIndexKey = new int[me.getValue().size()];
                for (int i = 0; i < me.getValue().size(); i++) {
                    tempRowMap = me.getValue().get(i);
                    for (int j = 0; j < tempRowMap.getStringRow().length; j++) {
                        if(tempRowMap.getStringRow()[j].equals(me.getKey())) {
                            arrIndexKey[i] = j;
                            break;
                        }
                    }
                }
                int sizeGroup = 0;
                for (int i = 0; i < arrIndexKey.length; i++) {
                    for (int j = i+1; j <arrIndexKey.length ; j++) {
                        if(arrIndexKey[i] == arrIndexKey[j]){
                            if(me.getValue().get(i).getGroupNumber()==-1 && me.getValue().get(j).getGroupNumber()==-1) {
                                me.getValue().get(i).setGroupNumber(numberGroup);
                                me.getValue().get(j).setGroupNumber(numberGroup);
                                numberGroup++;
                                sizeGroup = 2;
                            }else if(me.getValue().get(i).getGroupNumber()==-1){
                            me.getValue().get(i).setGroupNumber(me.getValue().get(j).getGroupNumber());
                                sizeGroup++;
                            }else if(me.getValue().get(j).getGroupNumber()==-1){
                            me.getValue().get(j).setGroupNumber(me.getValue().get(i).getGroupNumber());
                                sizeGroup++;
                            }

                        }
                    }
                }

                for (int i = 0; i < arrIndexKey.length; i++) {
                    me.getValue().get(i).setSizeGroup(sizeGroup);
                }
            }
        }

        long t6 = System.currentTimeMillis()-t5;

        Map<Integer, List<Row>> rowGroups = rows.stream().filter(r->{ return r.getSizeGroup()>=0;})
                .sorted(new Comparator<Row>() {
                    @Override
                    public int compare(Row o1, Row o2) {
                        return o2.getSizeGroup()-o1.getSizeGroup();
                    }
                })
                .collect(Collectors.groupingBy(Row::getSizeGroup));


        for (Map.Entry<Integer, List<Row>> merg: rowGroups.entrySet() ) {
            if(merg.getValue().size()>1) {
                System.out.println("Count Group = " + merg.getKey());
                merg.getValue().stream().forEach(System.out::println);
            }
        }

//        for (Row r :sortedListRow   ) {
//            System.out.println(r.toString());
//        }


        long tFinish = System.currentTimeMillis() - t1;
        System.out.println("stringSet = " + stringSet.size());
        System.out.println("List rows size = " + rows.size());
        System.out.println("numberGroup = " + numberGroup);
        System.out.println("stringListMap.size() = " + stringListMap.size());
        System.out.println("time4 группировка по номеру телефона и расставление нумерации групп в мапе = " + t4);
        System.out.println("time6 группировка строк по группам в новой мапе = " + t6);
        System.out.println("tFinish = " + tFinish);
//        System.out.println("количество групп с более 1 элемента = " + sortedListRow.size());

    }

}

class Row{
    private int groupNumber;
    private int sizeGroup;
    private int nColumns;
    private String[] stringRow;

    public Row(String[] stringRow) {
        this.nColumns = stringRow.length;
        this.stringRow = stringRow;
        this.groupNumber = -1;
        this.sizeGroup = 0;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getnColumns() {
        return nColumns;
    }

    public void setnColumns(int nColumns) {
        this.nColumns = nColumns;
    }

    public String[] getStringRow() {
        return stringRow;
    }

    public void setStringRow(String[] stringRow) {
        this.stringRow = stringRow;
    }

    public int getSizeGroup() {
        return sizeGroup;
    }

    public void setSizeGroup(int sizeGroup) {
        this.sizeGroup = sizeGroup;
    }

    public void addSizeGroup(){
        this.sizeGroup++;
    }

    @Override
    public String toString() {
        return "Row{" +
                "groupNumber=" + groupNumber +
                ", sizeGroup=" + sizeGroup +
                ", nColumns=" + nColumns +
                ", stringRow=" + Arrays.toString(stringRow) +
                '}';
    }
}

