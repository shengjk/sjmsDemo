//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 937 👎 0


package leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LruCache1 {
	private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	private int size;
	
	private int capacity;
	private DLinkedNode head, tail;
	
	public LruCache1(int capacity) {
		this.capacity = capacity;
		size = 0;
		// 使用伪头部和伪尾部节点
		head = new DLinkedNode();
		tail = new DLinkedNode();
		head.next = tail;
		tail.prev = head;
	}
	
	
	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (Objects.isNull(node)) {
			return -1;
		}
		moveToHead(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (Objects.isNull(node)) {
			DLinkedNode newNode = new DLinkedNode(key, value);
			cache.put(key, newNode);
			addToHead(newNode);
			size++;
			if (size > capacity) {
				DLinkedNode tail = removeTail();
				cache.remove(tail.key);
				--size;
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}
	
	private DLinkedNode removeTail() {
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}
	
	
	private void addToHead(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	private void removeNode(DLinkedNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	public void moveToHead(DLinkedNode node) {
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;
		prev.next = next;
		next.prev = prev;
		
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
		
		public DLinkedNode() {
		}
		
		public DLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
}