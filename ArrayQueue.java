package data_structures;

// we do not need to do this on the test

public class ArrayQueue<T> implements Queue<T> {

  private T[] arr;
  private int size;
  private int back;
  private int front;

  // constructor
  public ArrayQueue() {
    arr = (T[]) new Object[10];
    size = 0;
    front = 0;
    back = 0;
  }

  // make each of the operations constant runtime
  @Override
  public void enqueue(T item) throws Exception {
    // add to the tail
    if (full()) {
      throw new Exception("Queue is full");
    }
    arr[back++ % arr.length] = item;
    ++size;
  }

  @Override
  public T dequeue() throws Exception {
    // remove from the front
    if (size == 0) {
      throw new Exception("Queue is empty");
    }
    return arr[front++ % arr.length];
  }

  @Override
  public boolean empty() {
    // check if size is zero
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  private boolean full() {
    if (size == arr.length) {
      return true;
    } else {
      return false;
    }
  }
}
