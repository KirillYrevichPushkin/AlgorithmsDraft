package Tree;

import java.util.Comparator;

public class MainTree {

    public static void main(String[] args) {
        Comparator<Dog> comparator = new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.compareTo(o2);
            }
        };

        MyBinaryTree<Dog> myBinaryTree = new MyBinaryTree<>(Dog::compareTo);
        Dog dog = new Dog("eps" , 7);
       // myBinaryTree.insert(dog);

        myBinaryTree.insert(new Dog("sam", 5));
        myBinaryTree.insert(new Dog("gor", 2));
        myBinaryTree.insert(new Dog("nik", 6));
        myBinaryTree.insert(new Dog("ewq", 1));
        myBinaryTree.insert(dog);
        myBinaryTree.insert(new Dog("poi", 3));
        myBinaryTree.insert(new Dog("miu", 9));
        myBinaryTree.insert(new Dog("god", 8));

        System.out.println(myBinaryTree.find(dog));
        System.out.println();
        myBinaryTree.display();
        myBinaryTree.delete(dog);
        System.out.println();
        myBinaryTree.display();

    }



}
