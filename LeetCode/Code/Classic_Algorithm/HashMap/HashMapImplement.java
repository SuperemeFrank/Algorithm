
public class HashMap<K, V> {
	private Entry<K, V>[] array;
	private int size;
	private static final int INIT_CAPACITY = 11;
	private static final double LOAD_FACTOR = 0.75;
	private static final int DEFAULT_EXPAND_RATE = 2;
	
	public HashMap() {
		this.array = (Entry<K, V>[]) new Entry[INIT_CAPACITY];
		this.size = 0;
	}


	public V get(K key) { // checked
		int index = findIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> node = head;
		while (node != null) {
			if (isEquals(node.getKey(), key)) {
				return node.getValue();
			}
			node = node.next;
		}
		return null;
	}

	public boolean containsKey(K key) { // checked
		int index = findIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> node = head;
		while (node != null) {
			if (isEquals(node.getKey(), key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public V put(K key, V value) { // if override the old value, return it or return null
		int index = findIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> dummy = new Entry<>(null, null);
		dummy.next = head;
		Entry<K, V> prev = dummy;
		while (prev.next != null) {
			if (isEquals(prev.next.getKey(), key)) {
				V reValue = prev.next.getValue();
				prev.next.setValue(value);
				return reValue;
			}
			prev = prev.next;
		}
		if (needRehash()) {
			reHash();
		}
		Entry<K, V> newNode = new Entry<>(key, value);
		newNode.next = array[index];
		array[index] = newNode;
		size++;
		return null;
	}

	public V remove(K key) { // if success return value, else return null
		int index = findIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> dummy = new Entry<>(null, null);
		dummy.next = head;
		Entry<K, V> prev = dummy;
		while (prev.next != null) {
			if (isEquals(prev.next.getKey(), key)) {
				V reValue = prev.next.getValue();
				prev.next = prev.next.next;
				array[index] = dummy.next; // change the head in array
				size--;
				return reValue;
			}
			prev = prev.next;
		}
		return null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private boolean needRehash() {
		return size >= LOAD_FACTOR * array.length;
	}

	private int findIndex(K key) {
		if (key == null) {
			return 0;
		}
		int hash = key.hashCode();
		int hashNum = hash & 0x7FFFFFFF;
		return hashNum % array.length;
	}

	private void reHash() {
		Entry<K, V>[] oldArray = this.array;
		this.array = (Entry<K, V>[]) new Entry[this.array.length * DEFAULT_EXPAND_RATE]; // important, or the findIndex would not change
		for (Entry<K, V> e : oldArray) {
			while (e != null) {
				int newBucket = findIndex(e.getKey());
				Entry<K, V> newEntry = e;
				e = e.next;	
				newEntry.next = array[newBucket];
				array[newBucket] = newEntry;
			}
		}
	}

	private boolean isEquals(K key1, K key2) {
		if (key1 == null) {
			return key2 == null;
		}
		return key1.equals(key2);
	}

	public static class Entry<K, V> {
		private final K key;
		private V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
}

/*
	Care: 1. key might be null
		  2. if put or remove, size will change
		  3. when put, you might expand the array
		  4. when calculate the index of bucket, % array.length instead of INIT_CAPACITY
		  5. The way to new a generics array
*/

