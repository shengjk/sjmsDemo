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
// 👍 940 👎 0

package leetcode.editor.cn;

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
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public boolean isPalindrome(ListNode head) {
			//快慢指针
			ListNode slow = head;
			ListNode fast = head;

			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			//slow 反转
			ListNode reversaNode = reversal(slow);
			fast = head;
			while (reversaNode != null && fast != null) {
				if (reversaNode.val != fast.val) {
					return false;
				}
				reversaNode = reversaNode.next;
				fast = fast.next;
			}
			return true;
		}

		public ListNode reversal(ListNode node) {
			if (node == null) {
				return null;
			}
			ListNode pre = null;
			ListNode cur = node;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			return pre;
		}
	}

	//leetcode submit region end(Prohibit modification and deletion)
	public class ListNode {
		int      val;
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
