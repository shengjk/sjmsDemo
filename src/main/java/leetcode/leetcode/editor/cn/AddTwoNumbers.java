//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5110 👎 0


package leetcode.leetcode.editor.cn;

public class AddTwoNumbers {
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbers().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			int carryData = 0;
			ListNode head = null;
			ListNode cur = null;
			while (l1 != null || l2 != null) {
				int l1Value = l1 == null ? 0 : l1.val;
				int l2Value = l2 == null ? 0 : l2.val;
				
				int result = l1Value + l2Value;
				result = result + carryData;
				carryData = 0;
				if (result >= 10) {
					carryData = 1;
					result = result - 10;
				}
				if (head == null) {
					head = new ListNode(result, head);
					cur = head;
				} else {
					ListNode node = new ListNode(result);
					cur.next = node;
					cur = node;
				}
				l1 = l1 == null ? null : l1.next;
				l2 = l2 == null ? null : l2.next;
			}
			//最后 carryData 是否不为0 也就是最后一位是否进 1 了
			if (carryData != 0) {
				ListNode node = new ListNode(carryData);
				cur.next = node;
				cur = node;
			}
			return head;
		}
		
		class ListNode {
			int val;
			ListNode next;
			
			ListNode() {
			}
			
			ListNode(int val) {
				this.val = val;
			}
			
			ListNode(int val, ListNode next) {
				this.val = val;
				this.next = next;
			}
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}