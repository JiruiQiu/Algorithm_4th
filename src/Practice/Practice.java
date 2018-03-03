package Practice;

public class Practice {
	public static void main(String[] args) {
		Bag<Integer> myStack = new Bag<Integer>();

		for(int i = 0; i < 10; i++) {
			myStack.add((int)(Math.random()*100));
		}
		
		myStack.printBag();
		for(int i: myStack) {
			System.out.println(i);
		}
		
	}
}
