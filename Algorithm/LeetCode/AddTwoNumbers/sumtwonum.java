package AddTwoNumbers;

public class sumtwonum {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode temp = new ListNode(998);
		ListNode top = temp;

		int count = 0, v1, v2, forward = 0;
		while (l1 != null || l2 != null) {
			ListNode r1 = null;

			v1 = (l1 != null ? l1.val : 0);
			v2 = (l2 != null ? l2.val : 0);

			count = (v1 + v2 + forward) % 10;
			forward = (v1 + v2 + forward) / 10;

			r1 = new ListNode(count);
			temp.next = r1;
			temp = temp.next;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (forward > 0) {
			ListNode r1 = new ListNode(forward);
			temp.next = r1;
		}

		return top.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		ListNode l12 = new ListNode(9);
		l1.next = l12;
		ListNode l2 = new ListNode(9);
		// l1.next=l2;
		sumtwonum s = new sumtwonum();
		ListNode r = s.addTwoNumbers(l1, l2);
		while (r != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}

}
