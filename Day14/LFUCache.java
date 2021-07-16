package Day14;

import java.util.HashMap;

class LFUCache{
	final int capacity;
	int size;
	int minFreq;
	HashMap<Integer,DLLNode> cache;
	HashMap<Integer,DoubleLinkedList> frequencyMap;
	public LFUCache(int capacity){
		this.capacity = capacity;
		size = 0;
		minFreq =0;
		cache = new HashMap<>();
		frequencyMap = new HashMap<>();
	}
	public int get(int key){
		DLLNode node = cache.get(key);
		if(node==null){
			return -1;
		}
		update(node);
		return node.val;
	}
	public void put(int key, int value){
		if(capacity==0) return;
		if(cache.containsKey(key)){
			DLLNode node = cache.get(key);
			node.val = value;
			update(node);
		}else{
			size++;
			if(size>capacity){
				DoubleLinkedList min = frequencyMap.get(minFreq);
				cache.remove(min.tail.prev.key);
				min.removeNode(min.tail.prev);
				size--;
			}
			minFreq = 1;
			DLLNode node = new DLLNode(key, value);
			DoubleLinkedList curr = frequencyMap.getOrDefault(1,new DoubleLinkedList());
			curr.addNode(node);
			cache.put(key, node);
		}
	}
	private void update(DLLNode node){
		int freq = node.frequency;
		DoubleLinkedList list = frequencyMap.get(freq);
		list.removeNode(node);
		if(freq==minFreq && list.listSize==0){
			minFreq++;
		}
		node.frequency++;
		DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
		newList.addNode(node);
		frequencyMap.put(node.frequency, newList);
	}
}
class DLLNode{
	int key;
	int val;
	int frequency;
	DLLNode prev;
	DLLNode next;

	public DLLNode(int key, int val) {
		this.key = key;
		this.val = val;
		this.frequency = 1;
	}
}
class DoubleLinkedList {
	int listSize;
	DLLNode head;
	DLLNode tail;
	public DoubleLinkedList() {
		this.listSize = 0;
		this.head = new DLLNode(0, 0);
		this.tail = new DLLNode(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	/** add new node into head of list and increase list size by 1 **/
	public void addNode(DLLNode curNode) {
		DLLNode nextNode = head.next;
		curNode.next = nextNode;
		curNode.prev = head;
		head.next = curNode;
		nextNode.prev = curNode;
		listSize++;
	}

	/** remove input node and decrease list size by 1**/
	public void removeNode(DLLNode curNode) {
		DLLNode prevNode = curNode.prev;
		DLLNode nextNode = curNode.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		listSize--;
	}

}
