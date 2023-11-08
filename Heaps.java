package data_structures;

public class Heaps {
	public T[] arr = (T[]) new Object[5];
	int count = 0;

	// this is a min heap
	// insert 10 so it goes in position 0 
	// count = 1
	// insert 8 so it goes in position 1
	// but swap with 10 because 8 < 10
	// count = 2
	// insert 24 so it goes in position 2
	// count = 3
	// insert 16 so it goes in position 3
	// a child of 10
	// count = 4
	// insert 7 so it goes in position 4
	// child of 10
	// but swap with 10 because 7 < 10
	//now 7 is at position 1
	//10 is at position 4
	// swap 7 with 8 because 7 < 8
	// now 7 is at position 0
	// 10 is at position 4
	// count = 5

	// function to insert into the heap
	void insert(int key) {
		if (count == arr.length) {
			grow_array();
		}
		arr[count++] = key;
		// now compare key against its parent
		int child = count - 1;
		while (arr[child] < arr[parent(child)]{
			swap(arr, child, parent(child));
			child = parent(child);
		}
	}

// check slides for this code 
	void remove(int key) {
		// find the index of the key
		int index = 0;
		for (int i = 0; i < count; i++) {
			if (arr[i] == key) {
				index = i;
			}
		}
		// swap the key with the last element
		swap(arr, index, count - 1);
		// now compare the key with its children
		int parent = index;
		int child = 0;
		while (arr[parent] > arr[child]) {
			swap(arr, parent, child);
			parent = child;
			child = parent(parent);
		}
	}

	// parent is a function that gives the index of the parent of a node given the index for its child


	public void swap(T arr, int child, int parent) {
		T temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
	}

	// heapsort runtime is nlog n 
	public void sort(T[] arr) {
		// make a heap 
		
		// insert each element into the heap
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
// reheap each time through, this has to be a max heap
		}
		for(int i = arr.length - 1; i <= 0; i--) {
			arr[i] = remove();
			// remove and put it into the last position in array 
		}
	}

}
