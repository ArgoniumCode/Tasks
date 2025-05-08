package Hashes;

class MyHashMap {
	private static class Node {
		int key;
		int value;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private static final int SIZE = 10000;
	private final Node[] nodes;

	public MyHashMap() {
		nodes = new Node[SIZE];
	}

	private int getIndex(int key) {
		return key % SIZE;
	}

	private Node findNode(Node head, int key) {
		var current = head;
		Node prev = null;

		while (current != null && current.key != key) {
			prev = current;
			current = current.next;
		}

		return prev;
	}

	public void put(int key, int value) {
		var index = getIndex(key);
		if (nodes[index] == null) {
			nodes[index] = new Node(key, value);
			return;
		}

		var prev = findNode(nodes[index], key);
		if (prev == null)
			nodes[index].value = value;
		else if (prev.next == null)
			prev.next = new Node(key, value);
		else
			prev.next.value = value;
	}

	public int get(int key) {
		var index = getIndex(key);
		if (nodes[index] == null) return -1;

		var prev = findNode(nodes[index], key);
		if (prev == null)
			return nodes[index].value;
		else if (prev.next == null)
			return -1;
		else
			return prev.next.value;
	}

	public void remove(int key) {
		var index = getIndex(key);
		if (nodes[index] == null) return;

		var prev = findNode(nodes[index], key);
		if (prev == null)
			nodes[index] = nodes[index].next;
		else if (prev.next != null)
			prev.next = prev.next.next;
	}
}