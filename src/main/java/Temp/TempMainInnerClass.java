package Temp;

public class TempMainInnerClass {

    public static void main(String[] args) {
        OuterInnerClass outerInnerClass = new OuterInnerClass();
       // OuterInnerClass.Inner inner = outerInnerClass.getInner();  //, не скомпилируется, так как нет доступа к приватному полу (в данном случае классу)
        System.out.println(outerInnerClass.getAge());
    }





}
