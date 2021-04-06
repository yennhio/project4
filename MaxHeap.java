import java.util.Arrays;

public class MaxHeap<T extends Comparable<? super T>>
                                implements MaxHeapInterface<T> 
{
    private T[] heap;
    private int lastIndex;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private boolean integrityOK = false;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY)
            initialCapacity = DEFAULT_CAPACITY;
        else
            checkCapacity(initialCapacity);
        
        @SuppressWarnings("unchecked")
        T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
        heap = tempHeap;
        lastIndex = 0;
        integrityOK = true;
    }

    public MaxHeap(T[] entries){
        this(entries.length);
        lastIndex = entries.length;
        for (int index=0; index<entries.length;index++)
            heap[index + 1] = entries[index];
        for (int rootIndex=lastIndex/2; rootIndex>0;rootIndex--)
            reheap(rootIndex);
    }

    public T getMax() {
        checkIntegrity();
        T root = null;
        if (!isEmpty())
            root = heap[1];
        return root;
    }

    public boolean isEmpty() {
        return lastIndex < 1;
    }

    public int getSize() {
        return lastIndex;
    }

    public void clear() {
        checkIntegrity();
        while (lastIndex > -1) {
            heap[lastIndex] = null;
            lastIndex--;
        }
        lastIndex = 0;
    }

    public void add(T newEntry) {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    public T removeMax() {
        checkIntegrity();
        T root = null;
        if(!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            }
            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }
            else
                done = true;
        }
        heap[rootIndex] = orphan;
    }

    // Throws an exception if the client requests a capacity that is too large.
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a MaxHeap whose " +
                    "capacity exeeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    // Throws an exception if this object is not initialized.
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("MaxHeap object is corrupt.");
    } // end checkIntegrity

    private void ensureCapacity()
    {
        if (lastIndex >= heap.length)
        {
            int newCapacity = 2 * (heap.length - 1);
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap, newCapacity);
        } // end if
    } // end ensureCapacity
}
