package data_structures;
public class LLQueue<T> implements Queue<T> {

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

  public LLQueue() {
    head = null;
    size = 0;
  }
  public void enqueue(T item) {
    // add to the tail
    Node<T> current = head;
    while (current != null) {
      current = current.next;
    }
    Node<T> node = new Node<T>(item);
    current.next = node;
    node.data = item;
    ++size;
  }
  public T dequeue() throws Exception {
    // remove from the head
    if (size == 0) {
      throw new Exception("Queue is empty");
    }
    T temp = head.data;
    head = head.next;
    return temp;
  }
  public boolean empty() {
    if (head == null) {
      return true;
    } else {
      return false;
    }
  }
}
