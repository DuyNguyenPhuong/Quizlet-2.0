/**
 * An interface for the Priority Queue ADT.  Note that relative priority of
 * elements is determined with the T.compareTo() method. E.g., if the letters
 * of the alphabet were stored in a queue, 'a' would be the item at the front
 * of the queue.
 * @param <T> the type of data the queue stores.
 * @author Jadrian Miles
 * @author Anna Rafferty
 * @author Anya Vostinar
 */
public interface PriorityQueue<T extends Comparable<? super T>> {
    
    /** Adds the given item to the queue. */
    public void add(T item);
    
    /** Removes the first item according to compareTo from the queue, and returns it.
     * Returns null if the queue is empty.
     */
    public T poll();
    
    /** Returns the first item according to compareTo in the queue, without removing it.
     * Returns null if the queue is empty.
     */
    public T peek();
    
    /** Returns true if the queue is empty. */
    public boolean isEmpty();
    
    /** Removes all items from the queue. */
    public void clear();

    /**
     * Creates a String of the priority queue to save to the file in the correct format
     * @return String to save to a file
     */
    public String toString();
}
