package Practice;

public class FixedCapacityStack <Item>{
	private Item[] a;
	private int n;
	
	public FixedCapacityStack(int capacity) {
		a = (Item[]) new Object[capacity];
	}
	
	public boolean isEmpty() { return n == 0;}
	public int size() {return n;}
	
	public void push(Item item) {
		a[n++] = item;
	}
	
	public Item pop() {
		return a[--n];
	}
	
	public void printStack() {
		for(int i =0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
