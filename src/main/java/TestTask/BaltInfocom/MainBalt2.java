package TestTask.BaltInfocom;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MainBalt2 {
    public static void main(String[] args) {

        File file = new File("D:\\Download\\lng1.txt");
        Set<String> stringSet = new TreeSet<>();
        List<Row> rows = new ArrayList<>(300);
        int maxSize = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            long t1 = System.currentTimeMillis();
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                stringSet.add(line);
                line = br.readLine();
            }

            long t2 = System.currentTimeMillis()- t1;
            System.out.println("time = " + t2);
            System.out.println("stringSet = " + stringSet.size());

        } catch (
        FileNotFoundException e) {
        e.printStackTrace();
        } catch (
        IOException e) {
        e.printStackTrace();
        }

        String[] temp;
        Iterator<String> stringIterator = stringSet.iterator();
        while (stringIterator.hasNext()) {
            temp = stringIterator.next().split(";");
            if(temp.length > maxSize) maxSize = temp.length;
            rows.add(new Row(temp));
        }

        int i = 0;
        int numberGroup = 0;
        Row lastRow = null;
        Row thisRow = null;
        for (int j = 0; j < 1; j++) {
            int finalJ = j;
            rows.sort(new Comparator<Row>() {
                @Override
                public int compare(Row o1, Row o2) {
                    if(o1.getStringRow().length -1 < finalJ){
                        return -1;
                    }else if(o2.getStringRow().length -1 < finalJ){
                        return 1;
                    }
                    else {
                        return o1.getStringRow()[finalJ].compareTo(o2.getStringRow()[finalJ]);
                    }
                }
            });

            for (int k = 0; k < rows.size(); k++) {

                String tempStr = rows.get(k).getStringRow()[finalJ];
                //Row rowTemp = new Row();



            }


        }

//        rows.sort(new Comparator<Row>() {
//            @Override
//            public int compare(Row o1, Row o2) {
//
//                return o1.stringRow[i].compareTo(o2.stringRow[i]);
//            }
//        });




        rows.stream().forEach(System.out::println);
        System.out.println("stringSet = " + stringSet.size());
        System.out.println("List rows size = " + rows.size());
        System.out.println("numberGroup = " + numberGroup);

//        Map<String ,List<Row>> rowMap =  rows.stream().collect(Collectors.groupingBy(r -> { return r.stringRow[0]; }));
//
//        System.out.println("rowMap = " + rowMap.size());
//
//        for (Map.Entry<String ,List<Row>> es: rowMap.entrySet() ) {
//            System.out.println("es = " + es.getKey() + " value + " + es.getValue());
//        }

    }

}

//class Row{
//    private int groupNumber;
//    private int sizeGroup;
//    private int nColumns;
//    private String[] stringRow;
//
//    public Row(String[] stringRow) {
//        this.nColumns = stringRow.length;
//        this.stringRow = stringRow;
//        this.groupNumber = -1;
//        this.sizeGroup = 0;
//    }
//
//    public int getGroupNumber() {
//        return groupNumber;
//    }
//
//    public void setGroupNumber(int groupNumber) {
//        this.groupNumber = groupNumber;
//    }
//
//    public int getnColumns() {
//        return nColumns;
//    }
//
//    public void setnColumns(int nColumns) {
//        this.nColumns = nColumns;
//    }
//
//    public String[] getStringRow() {
//        return stringRow;
//    }
//
//    public void setStringRow(String[] stringRow) {
//        this.stringRow = stringRow;
//    }
//
//    public int getSizeGroup() {
//        return sizeGroup;
//    }
//
//    public void setSizeGroup(int sizeGroup) {
//        this.sizeGroup = sizeGroup;
//    }
//
//    public void addSizeGroup(){
//        this.sizeGroup++;
//    }
//
//    @Override
//    public String toString() {
//        return "Row{" +
//                "groupNumber=" + groupNumber +
//                ", sizeGroup=" + sizeGroup +
//                ", nColumns=" + nColumns +
//                ", stringRow=" + Arrays.toString(stringRow) +
//                '}';
//    }
//}
