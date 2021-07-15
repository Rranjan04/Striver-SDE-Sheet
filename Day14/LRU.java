package Day14;

import java.util.HashMap;


public class LRU {
	// Insertion right after head
	// Removal before tail
	static class LRUCache{
		int capacity;
		HashMap<Integer,Node> map;
		Node head, tail;//dummy nodes to help avoid null pointer exception
		LRUCache(int capacity){
			capacity = this.capacity;
			map = new HashMap<>();
			head = new Node(0,0);
			tail = new Node(0,0);
		}
		public int get(int key){
			if(map.containsKey(key)){
				Node node = map.get(key);
				remove(node);
				insert(node);
				return node.value;
			}
			return -1;
		}
		public void put(int key, int value){
			if(map.containsKey(key)){
				remove(map.get(key));
			}
			if(map.size()==capacity){
				remove(tail.prev);//remove least used
			}
			insert(new Node(key,value));
		}
		private void insert(Node node){
			//at head
			map.put(node.key, node);
			node.next = head.next;
			head.next.prev = node;
			node.prev = node;
			head.next = node;
		}
		private void remove(Node node){
			// at tail
			map.remove(node.key, node);
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}
	static class Node{
		int key, value;
		Node prev, next;
		Node(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
}
