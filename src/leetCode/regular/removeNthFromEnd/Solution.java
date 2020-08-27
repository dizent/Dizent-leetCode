package leetCode.regular.removeNthFromEnd;


public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode root = head;
        while (root.next != null){
            root = root.next;
            length += 1;
        }
        int index = length - n;
        return removeNthListNode(head,index,0);
    }

    public ListNode removeNthListNode(ListNode head, int n,int occu){
        if(n == occu){
            return head.next;
        }
        head.next = removeNthListNode(head.next,n,occu+1);
        return head;
    }


    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3,4,5};
        ListNode listNode = arrToListNode(arr,0);
        System.out.println(new Solution().removeNthFromEnd(listNode,2));

    }

    public static ListNode arrToListNode(int[] arr, int index) {
        if (arr.length > index) {
            ListNode root = new ListNode(arr[index]);
            index += 1;
            root.next = arrToListNode(arr,index);
            return root;
        }
        return null;
    }
}
