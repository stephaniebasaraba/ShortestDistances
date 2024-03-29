// Exercise 3.1.2 (Solution published at http://algs4.cs.princeton.edu/)
package ShortestDistances;
import stdlib.*;
import algs13.Queue;

public class ArrayST<K, V> {
	private static final int INIT_SIZE = 8;

	private V[] vals;   // symbol table values
	private K[] keys;   // symbol table keys
	private int N = 0;  // number of elements in symbol table

	@SuppressWarnings("unchecked")
	public ArrayST() {
		keys = (K[]) new Object[INIT_SIZE];
		vals = (V[]) new Object[INIT_SIZE];
	}

	// return the number of key-value pairs in the symbol table
	public int size() { return N; }

	// is the symbol table empty?
	public boolean isEmpty() { return size() == 0; }

	// resize the parallel arrays to the given capacity
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		if (capacity <= N) throw new IllegalArgumentException ();
		K[] tempk = (K[]) new Object[capacity];
		V[] tempv = (V[]) new Object[capacity];
		for (int i = 0; i < N; i++) tempk[i] = keys[i];
		for (int i = 0; i < N; i++) tempv[i] = vals[i];
		keys = tempk;
		vals = tempv;
	}

	// insert the key-value pair into the symbol table
	public void put(K key, V val) {

		// to deal with duplicates
		delete(key);

		// double size of arrays if necessary
		if (N >= vals.length) resize(2*N);

		// add new key and value at the end of array
		vals[N] = val;
		keys[N] = key;
		N++;
	}

	public boolean contains(K key) { return get(key) != null; }
	public V get(K key) {
		for (int i = 0; i < N; i++)
			if (keys[i].equals(key)) return vals[i];
		return null;
	}

	public Iterable<K> keys() {
		Queue<K> queue = new Queue<>();
		for (int i = 0; i < N; i++)
			queue.enqueue(keys[i]);
		return queue;
	}

	// remove given key (and associated value)
	public void delete(K key) {
		for (int i = 0; i < N; i++) {
			if (key.equals(keys[i])) {
				keys[i] = keys[N-1];
				vals[i] = vals[N-1];
				keys[N-1] = null;
				vals[N-1] = null;
				N--;
				return;
			}
		}
	}
}
