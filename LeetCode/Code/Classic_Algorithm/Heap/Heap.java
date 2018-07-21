import java.util.Arrays;


public class Heap {
	private int[] array;
	int size;


	public Heap() {
		this.array = new int[11];
		this.size = 0;
	}
	

	public Heap(int[] array) {
		this.array = array;
		this.size = array.length;
		this.heapify();
	}

	private void percolateUp(int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[parentIndex] > array[index]) {
				swap(parentIndex, index);
				index = parentIndex;
			} else {
				break;
			}
		}
	}

	private void percolateDown(int index) {
		while (index * 2 + 1 < size) { // index is parent node
			int leftChild = index * 2 + 1;
			int rightChild = index * 2 + 2;
			int candidate = leftChild;
			if (rightChild < size && array[rightChild] < array[leftChild]) {
				candidate = rightChild;
			}
			if (array[index] > array[candidate]) {
				swap(index, candidate);
				index = candidate;
			}else {
				break;
			}
		}
	}


	private void heapify() {	// heapify array  O(n)
		for (int i = (size - 2) / 2; i >= 0; i--) {
			percolateDown(i);
		}
	}

	private int findFirstPosition(int ele) {
		for (int i = 0; i < size; i++) {
			if (array[i] == ele) {
				return i;
			}
		}
		return -1;
	}

	private void swap(int indexA, int indexB) {
		int tmp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = tmp;
	}

	public void offer(int ele) {
		if (size == array.length) {
			int[] newArray = Arrays.copyOf(array, array.length * 2);
			this.array = newArray;
		}
		array[size] = ele;
		percolateUp(size);
		size++;
	}

	public int poll() {
		if (size == 0) {
			return -1;
		}
		int result = array[0];
		array[0] = array[size - 1];
		size--;
		percolateDown(0);
		return result; 
	}

	public boolean update(int oldEle, int newEle) { 
		int pos = findFirstPosition(oldEle);
		if (pos == -1) {
			return false;
		}
		array[pos] = newEle;
		int parent = (pos - 1) / 2;
		if (array[parent] > array[pos]) {
			percolateUp(pos);
		}else {
			percolateDown(pos);
		}
		return true;
	}





	public void printArray() {
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = {3, 2, 5, 3, 1, 5, 8};
		Heap heap = new Heap(array);
		//heap.heapify();
		heap.update(2, 9);
		heap.printArray();
		
	}	
}
