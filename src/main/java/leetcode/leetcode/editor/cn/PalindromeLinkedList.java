//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 661 👎 0


package leetcode.leetcode.editor.cn;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		Solution solution = new PalindromeLinkedList().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			
			ListNode current = head;
			ListNode pre = null;
			
			while (current != null) {
				ListNode next = current.next;
				current.next = pre;
				pre = current;
				current = next;
			}
			return pre;
		}
		
		public boolean isPalindrome(ListNode head) {
			if (head == null) {
				return true;
			}
			ListNode n1 = head;
			ListNode n2 = head;
			
			while (n2.next != null && n2.next.next != null) {
				n1 = n1.next;
				n2 = n2.next.next;
			}
			// n1 中点位置
			ListNode n3 = n1.next;
			n1.next = null;
			
			ListNode startNode = reverseList(n3);
			boolean res = true;
			n2 = head;
			while (head != null && startNode != null) {
				if (head.val != startNode.val) {
					res = false;
					break;
				}
				head = head.next;
				startNode = startNode.next;
			}
			return res;
		}
		
		public class ListNode {
			int val;
			ListNode next;
			
			ListNode(int x) {
				val = x;
			}
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}