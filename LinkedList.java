package data_structures;
public class LinkedList<T> implements list<T> {

  private class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      next = null;
    }
  }

  // LinkedList
  int size;
  Node<T> head;

  public LinkedList() {
    size = 0;
    head = null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T get(int pos) throws Exception {
    if (pos < 0 || pos > size) throw new Exception("List index OOB");
    Node<T> current = head;
    for (int i = 0; i < pos; i++) {
      current = current.next;
    }
    return current.data;
  }

  @Override
  public boolean add(T item) {
    if (head == null) {
      head = new Node<T>(item);
      ++size;
      return true;
    }
    Node<T> current = head;
    for (int i = 0; i < size; i++) {
      current = current.next;
    }
    Node<T> node = new Node<T>(item);
    current.next = node;
    ++size;
    return true;
  }

  @Override
  public void add(int pos, T item) throws Exception {
    if (pos < 0 || pos > size) throw new Exception("List index OOB");
    if (pos == 0) {
      Node<T> node = new Node<>(item);
      node.next = head;
      head = node;
      ++size;
    } else {
      // find the node before the position
      Node<T> previous = head;
      // pos - 1 because we want the node before the position
      for (int i = 0; i < pos - 1; i++) {
        previous = previous.next;
      }
      Node<T> node = new Node<>(item);
      node.next = previous.next;
      previous.next = node;
      ++size;
    }
  }

  @Override
  public T remove(int pos) {
    if (pos == 0) {
      Node<T> node = head;
      head = head.next;
      --size;
      return node.data;
    }
    Node<T> previous = head;
    for (int i = 0; i < pos - 1; i++) {
      previous = previous.next;
    }
    Node<T> current = previous.next;
    previous.next = current.next;
    --size;
    return current.data;
  }
}
