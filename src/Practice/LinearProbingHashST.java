package Practice;

public class LinearProbingHashST<Key, Value> {
	private int n;
	private int m = 16;
	private Key[] keys;
	private Value[] vals;
	
	public LinearProbingHashST() {
		keys = (Key[]) new Object[m];
		vals = (Value[]) new Object[m];
	}
	
	public LinearProbingHashST(int cap) {
		m = cap;
		keys = (Key[]) new Object[m];
		vals = (Value[]) new Object[m];
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}
	
	private void resize(int cap) {
		LinearProbingHashST<Key, Value> t;
		t = new LinearProbingHashST<Key, Value>(cap);
		for(int i = 0; i < m; i++) {
			if (keys[i] != null) {
				t.put(keys[i], vals[i]);
			}
		}
		keys = t.keys;
		vals = t.vals;
		m = t.m;
	}
	
	public void put(Key key, Value val) {
		if(n >= m/2) resize(2*m);
		int i;
		for(i = hash(key); keys[i] != null; i = (i+1) %m) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		n++;
	}
	
	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i+1) % m)
			if (keys[i].equals(key))
				return vals[i];
		return null;
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public void delet(Key key) {
		if (!contains(key)) return;
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i+1) % m;
		keys[i] = null;
		vals[i] = null;
		i = (i+1) % m;
		while (keys[i] != null) {
			Key keyToRedo = keys[i];
			Value valToRedo = vals[i];
			keys[i] = null;
			vals[i] = null;
			n--;
			put(keyToRedo, valToRedo);
			i = (i + 1) % m;
		}
		n--;
		if (n > 2 && n <= m / 8) {
			resize(m/2);
		}
	}
}
