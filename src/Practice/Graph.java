package Practice;

public class Graph {
	private final int v;
	private int e = 0;
	private Bag<Integer>[] adj;
	
	public Graph(int v) {
		this.v = v;
		adj = (Bag<Integer>[]) new Bag[v];
		for(int i = 0; i < v; i++) 
			adj[i] = new Bag<Integer>();
	}
	
	public int V() { 
		return v;
	}
	
	public int E() {
		return e;
	}
	
	public void addEdge(int a, int b) {
		adj[a].add(b);
		adj[b].add(a);
		e++;
	}
	
	public Iterable<Integer> adj(int a) {
		return adj[a];
	}
}
