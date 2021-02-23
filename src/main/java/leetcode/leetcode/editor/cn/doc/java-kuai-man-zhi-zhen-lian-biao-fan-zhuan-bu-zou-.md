# 解题步骤

1. 先利用快慢指针找到链表的中间位置
2. 将后半段链表翻转
3. 将链表从中间切开(使中间位置的.next=null,便于之后判断结束条件)
4. 比较两个链表的内容,得出结果

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode maxSubBSTHead) {
        if(maxSubBSTHead==null||maxSubBSTHead.next==null){
            return true;
        }
        //利用快慢指针找到链表的中间位置
        ListNode fast=maxSubBSTHead;
        ListNode slow=maxSubBSTHead;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast.next!=null)slow=slow.next;//偶数节点,让slow指向下一节点
        ListNode newHead=reverseList(slow);
        //System.out.println(slow.val);
        //System.out.println(newHead.val);
        slow.next=null;//把链表从中间切开
        //比较两个链表是否相等
        while(newHead!=null){
            if(newHead.val!=maxSubBSTHead.val)return false;
            maxSubBSTHead=maxSubBSTHead.next;
            newHead=newHead.next;
        }
        return true;
    }
    //翻转链表
    public ListNode reverseList(ListNode maxSubBSTHead) {
        if(maxSubBSTHead==null||maxSubBSTHead.next==null) return maxSubBSTHead;
        ListNode next=maxSubBSTHead.next;
        ListNode newHead=reverseList(next);
        next.next=maxSubBSTHead;
        maxSubBSTHead.next=null;
        return newHead;
    }
}
```
