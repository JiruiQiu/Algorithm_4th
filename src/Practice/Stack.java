package Practice;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	private Node first;
	private int n;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first == null; }
	public int size() {return n;}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item> {
		int i = n;
		Node copy = first;
		public boolean hasNext() {return i!=0;}
		public Item next() {
			Item item = copy.item;
			copy = copy.next;
			i--;
			return item;
		}
		public void remove() {} 
	}
}
