package Algorithm.Tree;

import java.util.Comparator;

public class MyBinaryTree<E> {

    private Comparator<E> comp;

    private class Node<E>{
        Node<E> leftChild;
        Node<E> rightChild;
        E e;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node<E> root;

    public MyBinaryTree(Comparator<E> comparator) {
        this.root = null;
        this.comp = comparator;
    }

    public void insert(E e){
        if(root==null){
            root = new Node<>(e);
        }else {
            Node<E> tempRoot = root;
            while (true){
                if(comp.compare(e, tempRoot.e)>0){
                   if(tempRoot.rightChild==null){
                       tempRoot.rightChild = new Node<>(e);
                       return;
                   }else {
                       tempRoot = tempRoot.rightChild;
                   }
                }
                else if(comp.compare(e, tempRoot.e)<0){
                    if(tempRoot.leftChild==null){
                        tempRoot.leftChild = new Node<>(e);
                        return;
                    }else {
                        tempRoot = tempRoot.leftChild;
                    }
                } else {
                    return;
                }
            }
        }
    }

//    public E find(E e){
//        Node<E> tempRoot = root;
//        while (true){
//            if (comp.compare(tempRoot.e, e)==0){
//                return tempRoot.e;
//            }else if (comp.compare(e, tempRoot.e)>0){
//                if(tempRoot.rightChild == null){
//                    return null;
//                }else {
//                    tempRoot = tempRoot.rightChild;
//                }
//            }else if (comp.compare(e, tempRoot.e)<0){
//                if(tempRoot.leftChild == null){
//                    return null;
//                }else {
//                    tempRoot = tempRoot.leftChild;
//                }
//            }else {
//                return null;
//            }
//        }
//    }

    public E find(E e){
        return findNode(e)!= null ? findNode(e).e : null;
    }

    private Node<E> findNode(E e){
        Node<E> tempRoot = root;
        while (true){
            if (comp.compare(tempRoot.e, e)==0){
                return tempRoot;
            }else if (comp.compare(e, tempRoot.e)>0){
                if(tempRoot.rightChild == null){
                    return null;
                }else {
                    tempRoot = tempRoot.rightChild;
                }
            }else if (comp.compare(e, tempRoot.e)<0){
                if(tempRoot.leftChild == null){
                    return null;
                }else {
                    tempRoot = tempRoot.leftChild;
                }
            }else {
                return null;
            }
        }
    }



    public void inOrderTravers(Node<E> current) {
        if (current != null) {
            System.out.println(current.e.toString());
            inOrderTravers(current.leftChild);
            inOrderTravers(current.rightChild);
        }
    }

    public void display(){
        inOrderTravers(root);
    }

    public boolean delete (E e){
        Node<E>current = root;
        Node<E>tempRoot = root;
        boolean isLeftChild = true;

        while (comp.compare(current.e,e)!=0){
            tempRoot = current;
            if(comp.compare(e, current.e)<0){
                current = current.leftChild;
                isLeftChild = true;
            }else {
                current = current.rightChild;
                isLeftChild = false;
            }
            if(current==null){
                return false;
            }
        }

        if(current.leftChild == null && current.rightChild == null){
            if(isLeftChild){
                tempRoot.leftChild = null;
            }else {
                tempRoot.rightChild = null;
            }
        }else if(current.leftChild == null){
            if(isLeftChild){
                tempRoot.leftChild = current.rightChild;
            }else {
                tempRoot.rightChild = current.rightChild;
            }
        }else if(current.rightChild ==null){
            if(isLeftChild){
                tempRoot.leftChild = current.leftChild;
            }else {
                tempRoot.rightChild = current.leftChild;
            }
        }else {
            Node<E> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                tempRoot.leftChild = successor;
            } else {
                tempRoot.rightChild = successor;
            }
            successor.leftChild = tempRoot.leftChild;
        }
        return true;
    }

    private Node<E> getSuccessor(Node<E> deleted) {
        Node<E> successorParent = deleted;
        Node<E> successor = deleted;
        Node<E> flag = deleted.rightChild;

        while (flag != null) {
            successorParent = successor;
            successor = flag;
            flag = flag.leftChild;
        }
        if (successor != deleted.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deleted.rightChild;
        }
        return successor;
    }






}






