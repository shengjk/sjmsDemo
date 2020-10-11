//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 762 👎 0


package leetcode.leetcode.editor.cn;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		Solution solution = new ReverseNodesInKGroup().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	
	//leetcode submit region end(Prohibit modification and deletion)
	
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
		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			
			ListNode pre = dummy;
			ListNode end = dummy;
			
			while (end.next != null) {
				for (int i = 0; i < k && end != null; i++) {
					end = end.next;
					if (end == null) {
						break;
					}
				}
				ListNode start = pre.next;
				ListNode next = end.next;
				end.next = null;
				pre.next = reverse(start);
				start.next = next;
				start = pre;
				
				end = pre;
			}
			return dummy.next;
		}
		
		private ListNode reverse(ListNode head) {
			ListNode pre = null;
			ListNode curr = head;
			while (curr != null) {
				ListNode next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			}
			return pre;
		}
		
		public class ListNode {
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
}