package leetCode.regular.addTwoNumbers;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersAndReach(l1,l2,0);
    }

    private ListNode addTwoNumbersAndReach(ListNode l1, ListNode l2, int reach) {
        if(l1 == null && l2 == null){
            if(reach != 0){
                return new ListNode(1);
            }
            return null;
        }
        if(l1 == null){
            l1 = new ListNode(0);
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }
        ListNode result = new ListNode(l1.val + l2.val + reach);
        reach = 0;
        if(result.val > 9){
            result.val %= 10;
            reach = 1;
        }
        result.next = addTwoNumbersAndReach(l1.next,l2.next,reach);
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode result = new Solution().addTwoNumbers(l1,l2);
        while(result !=  null){
            System.out.print(result.val);
            result = result.next;
        }
    }


}
