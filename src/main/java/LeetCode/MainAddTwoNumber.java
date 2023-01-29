package LeetCode;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*Вам дается два непустой связанные списки, представляющие два неотрицательных целых числа. Цифры хранятся в обратный порядок, и каждый из их узлов содержит одну цифру.
 * Добавьте два числа и верните сумму в виде связанного списка.
 *
 * Вы можете предположить, что два числа не содержат никакого начального нуля, кроме самого числа 0.
 *
 * Ввод: l1 = [2,4,3], l2 = [5,6,4] Вывод: [7,0,8]
 * Объяснение: 342 + 465 = 807.
* */
public class MainAddTwoNumber {


    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();


        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

//        ListNode l1 = new ListNode(0, null);
//        ListNode l2 = new ListNode(0, null);




        System.out.println(addTwoNumbers(l1,l2).toString());

    }

/**
* сам не додумался до красивого решения..((
* */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int dec = 0;
        while (l1 != null || l2 != null || dec != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = dec + x + y;
            dec = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


}
