package Algorithm.Stack;

public class MainStack {

    public static void main(String[] args) {
        StackX<Integer> stackX1 = new StackX<Integer>(10);
        StackX<String> stackX2 = new StackX<>(10);
        SimpleStack simpleStack = new SimpleStack(10);

        stackX1.push(15);
        stackX1.push(7);
        stackX1.push(96);
        stackX1.push(21);
        stackX1.push(18);

        stackX2.push("afaf");
        stackX2.push("aafs");
        stackX2.push("r233");
        stackX2.push("76756");
        stackX2.push("14");

        simpleStack.push(5);
        simpleStack.push(2);
        simpleStack.push(14);
        simpleStack.push(44);
        simpleStack.push(26);
        simpleStack.push(99);
        simpleStack.push(116);
        simpleStack.push(4636);

        while (!stackX1.isEmpty()){
            System.out.println(stackX1.pop());
        }

        while (!stackX2.isEmpty()){
            System.out.println(stackX2.pop());
        }

        while (!simpleStack.isEmpty()){
            System.out.println(simpleStack.pop());
        }


    }





}
