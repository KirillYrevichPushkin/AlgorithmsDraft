package TestTask.BaltInfocom;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainBalt3 {
    static Pattern pattern1 = Pattern.compile("\"\\d{1,10}\"");
    static Pattern pattern2 = Pattern.compile("\"\\d{12,}\"");
    static Matcher matcher1;
    static Matcher matcher2;

    static int numberGroup = 0;

    public static void main(String[] args) {
        File file = new File("D:\\Download\\lng.txt");
        Set<String> stringSet = new TreeSet<>();
        List<Row> rows = new ArrayList<>(300);
        Map<String, List<Row>> stringListMap = new HashMap<>();

        long t1 = System.currentTimeMillis();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line = br.readLine();
            while (line != null) {
             //   System.out.println(line);
                matcher1 = pattern1.matcher(line);
                matcher2 = pattern2.matcher(line);
                if(matcher1.find() || matcher2.find()){
                    System.out.println(line);
                    line = br.readLine();
                    continue;
                }
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

        Iterator<String> stringIterator = stringSet.iterator();
        long t3 = System.currentTimeMillis();
        while (stringIterator.hasNext()) {
            tempString = stringIterator.next().split(";");
            tempRow = new Row(tempString);

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

                setNumberGroup(me);

            }
        }

        long t6 = System.currentTimeMillis()-t5;

        Map<Integer, List<Row>> rowGroups = rows.stream().filter(r->{ return r.getSizeGroup()>=0;})
                .sorted(new Comparator<Row>() {
                    @Override
                    public int compare(Row o1, Row o2) {
                        return o1.getSizeGroup()-o2.getSizeGroup();
                    }
                })
                .collect(Collectors.groupingBy(Row::getSizeGroup));


        TreeMap<Integer, List<Row>> treeMapRows = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (Map.Entry<Integer, List<Row>> me: rowGroups.entrySet()) {

            treeMapRows.put(me.getKey(), me.getValue().stream().sorted(new Comparator<Row>() {
                @Override
                public int compare(Row o1, Row o2) {
                    return o1.getGroupNumber()-o2.getGroupNumber();
                }
            }).collect(Collectors.toList()));
        }



//        for (Map.Entry<Integer, List<Row>> merg: rowGroups.entrySet() ) {
//            if(merg.getValue().size()>1) {
//                System.out.println("Count Group = " + merg.getKey());
//                merg.getValue().stream().forEach(System.out::println);
//            }
//        }

        for (Map.Entry<Integer, List<Row>> merg: treeMapRows.entrySet() ) {
            if(merg.getKey()>=2) {
                System.out.println("Size Group = " + merg.getKey());
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



    public static void  setNumberGroup(Map.Entry<String, List<Row>> me){
        List<Row> rowList = me.getValue().stream().filter(r-> r.getGroupNumber()==-1).collect(Collectors.toList());
        if(rowList.size()<2){
            return;
        }

        int[] arrIndexKey = new int[rowList.size()];

        for (int i = 0; i < rowList.size(); i++) {
            for (int j = 0; j < rowList.get(i).getStringRow().length; j++) {
                if(rowList.get(i).getStringRow()[j].equals(me.getKey())) {
                    arrIndexKey[i] = j;
                    break;
                }
            }
        }

        int sizeGroup = 0;

            for (int i = 0; i < arrIndexKey.length; i++) {
                for (int j = i+1; j < arrIndexKey.length ; j++) {
                    if(arrIndexKey[i] == arrIndexKey[j]){
                        if(rowList.get(i).getGroupNumber()!=-1 && rowList.get(j).getGroupNumber()!=-1){
                            continue;
                        }
                        if(rowList.get(i).getGroupNumber()==-1 && rowList.get(j).getGroupNumber()==-1) {
                            rowList.get(i).setGroupNumber(numberGroup);
                            rowList.get(j).setGroupNumber(numberGroup);
                            numberGroup++;
                            sizeGroup = 2;
                        }else if(rowList.get(i).getGroupNumber()==-1 && rowList.get(j).getGroupNumber()!=-1){
                            rowList.get(i).setGroupNumber(rowList.get(j).getGroupNumber());
                            sizeGroup++;
                        }else if(rowList.get(j).getGroupNumber()==-1 && rowList.get(i).getGroupNumber()!=-1){
                            rowList.get(j).setGroupNumber(rowList.get(i).getGroupNumber());
                            sizeGroup++;
                        }

                    }
                }
            }

            for (int i = 0; i < arrIndexKey.length; i++) {
               if(rowList.get(i).getGroupNumber()!=-1) {
                   rowList.get(i).setSizeGroup(sizeGroup);
               }
            }
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

