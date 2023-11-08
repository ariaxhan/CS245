package data_structures;
public class LLStack<T> implements Stack<T> {

  private class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      next = null;
    }
  }

  private Node<T> head;
  private int size;

  public LLStack() {
    head = null;
    size = 0;
  }

  @Override
  public void push(T item) {
    Node<T> current = head;
    while (current.next != null) {
      current = current.next;
    }
    Node<T> node = new Node<T>(item);
    current.next = node;
    node.data = item;
    ++size;
  }
  @Override
  public T pop() throws Exception {
    // remove the last item
    if (size == 0) {
      throw new Exception("Stack is empty");
    }
    Node<T> current = head;
    while (current.next.next != null) {
      current = current.next;
    }
    T temp = current.next.data;
    current.next = null;
    --size;
    return temp;
  }
  @Override
  public T peek() throws Exception {
    // returns the last element without deleting it
    if (size == 0) {
      throw new Exception("Stack is empty");
    }
    Node<T> current = head;
    while (current.next != null) {
      current = current.next;
    }
    return current.data;
  }
  @Override
  public boolean empty() {
    if (head == null) {
      return true;
    } else {
      return false;
    }
  }
}
