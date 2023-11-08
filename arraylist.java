package data_structures;

public class arraylist<T> implements list<T> {

  protected int size;
  protected T[] arr;

  public arraylist() {
    arr = (T[]) new Object[10];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int pos) throws Exception {
    if (pos < 0 || pos >= size) throw new Exception("Illegal insert");
    return arr[pos];
  }

  @Override
  public boolean add(T item) {
    if (size == arr.length) grow_array();
    arr[size++] = item;
    return true;
  }

  @Override
  public void add(int pos, T item) throws Exception {
    if (pos < 0 || pos > size) throw new Exception("Illegal position");
    if (size == arr.length) grow_array();
    // shift everything over to the right
    for (int i = size; i > pos; i--) {
      arr[i + 1] = arr[i];
    }
    ++size;
  }

  public void grow_array() {
    T[] new_arr = (T[]) new Object[arr.length * 2];
    for (int i = 0; i < arr.length; i++) {
      new_arr[i] = arr[i];
    }
    arr = new_arr;
  }

  @Override
  public T remove(int pos) throws Exception {
    if (pos < 0 || pos > size) throw new Exception("Illegal position");
    // save the item to return
    T temp = arr[pos];
    // shift everything over to the left
    for (int i = pos; i < size - 1; i++) {
      arr[pos] = arr[pos + 1];
    }
    --size;
    return temp;
  }
}
