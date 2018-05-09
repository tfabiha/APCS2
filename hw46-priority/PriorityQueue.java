public interface PriorityQueue<T>
{
    // Adds an item to this priority queue.
    void add(T obj);

    // Returns true if this stack is empty, otherwise returns false.
    boolean isEmpty();

    //Returns the smallest item stored in this priority queue without removing it.
    T peekMin();

    // Removes and returns the smallest item stored in this priority queue.
    T removeMin();
}
