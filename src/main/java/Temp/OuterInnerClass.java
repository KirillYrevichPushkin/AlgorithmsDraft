package Temp;

public class OuterInnerClass {
    public int flat;
     private class Inner{
        public int age;

    }

    public Inner getInner(){
         return new Inner();
    }

    public int getAge(){
         Inner inner = this.getInner();
         return inner.age;
    }
}
