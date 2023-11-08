package data_structures;
public interface list<T> {
  public int size();
  public T get(int pos) throws Exception;
  public boolean add(T item);
  public void add(int pos, T item) throws Exception;
  public T remove(int pos);
}
