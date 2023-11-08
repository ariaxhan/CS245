package data_structures;

public class Heap<T> implements PriorityQueue<T> {

  Comparable<T>[] arr;
  int count;
  int parent;
  int child;

  // heapsort runtime is nlog n
  public void sort(T[] arr) {
    // make a heap
    Comparable<T>[] new_arr = (Comparable<T>[]) new Object[arr.length];
    // insert each element into the heap
    for (int i = 0; i < arr.length; i++) {
      insert(new_arr[i]);
      // reheap each time through, this has to be a max heap
    }
    // work backwards, remove and put it into the last position in array
    for (int i = arr.length - 1; i <= 0; i--) {
      new_arr[i] = remove();
    }
  }

  @Override
  public void insert(Comparable<T> item) {
    if (count == arr.length) {
      grow_array(); // check if you need to grow
    }
    // insert item, increment count
    arr[count++] = item;
    // move child up (minheap version)
    int child = count - 1;
    // if the parent is bigger than the child, swap
    // for a max head, swap if parent is less than child
    while (child > 0 && arr[parent(child)] > arr[child]) {
      swap(arr, parent(child), child);
      child = parent(child);
    }
  }
  private void grow_array() {
    Comparable<T>[] new_arr = (Comparable<T>[]) new Object[arr.length * 2];
    for (int i = 0; i < arr.length; i++) {
      new_arr[i] = arr[i];
    }
    arr = new_arr;
  }

  @Override
  public Comparable<T> remove() {
    // put highest priority thing into item to return
    Comparable item = arr[0];
    arr[0] = arr[--count]; // put last item into root
    shiftDown(0); // maintains head
    return item;
  }
  // reheapify
  private void shiftDown(int i) {
    // find the highest priority child (minheap version)
    int child = left(parent);
    if (child >= count)
      return; // no children
    // if the right child is smaller, use that one
    if (child + 1 < count && arr[child + 1] < arr[child]) {
      child = child + 1;
    }
    // recursively swap parent and child, if appropriate
    if (arr[child] < arr[parent]) {
      swap(arr, child, parent);
      shiftDown(child);
    }
  }

  public boolean empty() {
    return count == 0;
  }

  private int left(int parent) {
    return parent * 2 + 1;
  }
  private int right(int parent) {
    return parent * 2 + 2;
  }
  private int parent(int i) {
    return (i - 1) / 2;
  }
  private void swap(Comparable<T>[] arr, int i, int j) {
    Comparable<T> temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
