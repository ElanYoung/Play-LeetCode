public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        ListNode head = new ListNode(arr);
        System.out.println(head);
        (new Solution()).removeElements(head, val);
        System.out.println(head);
    }
}
