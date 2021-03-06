package Practice;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int n;
		
		public Node(Key key, Value val, int n) {
			this.key = key;
			this.val = val;
			this.n = n;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null) return 0;
		else return x.n;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp > 0) return get(x.right, key);
		else if (cmp < 0) return get(x.left, key);
		else return x.val;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val , 1);
		int cmp = key.compareTo(x.key);
		if (cmp > 0) x.left = put(x.left, key, val);
		else if (cmp < 0) x.right = put(x.right, key, val);
		else x.val = val;
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	private boolean isEmpty() {
		return root == null;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
}
