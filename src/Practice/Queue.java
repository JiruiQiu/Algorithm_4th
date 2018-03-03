package Practice;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	private int n;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return n==0;}
	public int size() {return n;}
	
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		n++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		n--;
		if(isEmpty()) last = null;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		int i = n;
		Node copyFirst = first;
		public boolean hasNext() {return i != 0;}
		public Item next() {
			Item item = copyFirst.item;
			copyFirst = copyFirst.next;
			i--;
			return item;
		}
		public void remove() {}
	}
}
