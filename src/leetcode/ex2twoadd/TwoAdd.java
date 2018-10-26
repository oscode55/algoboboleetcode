package leetcode.ex2twoadd;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
   输出：7 -> 0 -> 8
   原因：342 + 465 = 807
 */
import data_struct.QueueCustomer;
import data_struct.StackCustomer;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class TwoAdd {
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyNode = new ListNode(0);
//        ListNode curr = dummyNode,p1 = l1,p2 = l2;
//        int carry = 0;//进位标志 只可能1或者0
//        while(p1!=null || p2!=null){
//            int x = p1==null?0:p1.val;
//            int y = p2==null?0:p2.val;
//            int sum = x + y +carry;
//            carry = sum /10;
//            curr.next = new ListNode(sum%10);
//            curr = curr.next;
//            if(p1!=null) p1 = p1.next;
//            if(p2!=null) p2 = p2.next;
//        }
//        return dummyNode.next;
//    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy,p1=l1,p2=l2;
        int carry = 0 ;//进位标志 只能0或1
        while(p1!=null || p2!=null ){
            int x = p1!=null?p1.val:0;
            int y = p2!=null?p2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p1!=null) p1=p1.next;
            if(p2!=null) p2=p2.next;
        }
        if(carry!=0){
            curr.next=new ListNode(carry);
        }
        return dummy.next;
    }
    public static void printListNode(ListNode head){
        ListNode p = head;
        while(p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }
    public static ListNode createListNode(int[] arr){
        ListNode p = new ListNode(0);
        ListNode head = p;
        for(int item:arr){
            ListNode temp=new ListNode(item);
            p.next=temp;
            p=temp;
        }
        return head.next;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{5};
        int[] arr2 = new int[]{5};
        ListNode list1=createListNode(arr1);
        ListNode list2=createListNode(arr2);
        printListNode(addTwoNumbers(list1,list2));
    }
}
