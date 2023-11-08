package data_structures;

public interface PriorityQueue<T> {
  public void insert(Comparable<T> item);

  public Comparable<T> remove();

  public boolean empty();
}
