package data_structures;
public class ArrayStack<T> implements Stack<T> {

  private int size;
  private T[] arr;

  // constructor
  public ArrayStack() {
    arr = (T[]) new Object[10];
    size = 0;
  }

  @Override
  public void push(T item) {
    // add to the end
    if (size == arr.length) grow_array();
    arr[size++] = item;
  }
  @Override
  public T pop() throws Exception {
    // remove from the end
    if (size == 0) throw new Exception("Stack is empty");
    return arr[--size];
  }
  @Override
  public T peek() throws Exception {
    // returns the last element
    if (size == 0) {
      throw new Exception("Stack is empty");
    } else {
      return arr[size - 1]; 
    }
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

  public void grow_array() {
    T[] new_arr = (T[]) new Object[arr.length * 3 / 2 + 1];
    for (int i = 0; i < arr.length; i++) {
      new_arr[i] = arr[i];
    }
    arr = new_arr;
  }
}
