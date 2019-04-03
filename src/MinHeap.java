/**
 * @author Joshua Chen
 * Date Created: Apr 02, 2019
 */
public class MinHeap {
    private HeapNode[] heap;
    private int maxSize;
    private int currentSize;
    private static final int DEFAULT_SIZE = 20;

    public MinHeap() {
        this(DEFAULT_SIZE);
    }

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heap = new HeapNode[maxSize];
    }

    public boolean insert(int cityNum, int distToNext) {
        if (currentSize == maxSize) {
            return false;
        }
        heap[currentSize] = new HeapNode(cityNum, distToNext);
        trickleUp(currentSize);
        currentSize += 1;
        return true;
    }

    public HeapNode remove() {
        HeapNode root = heap[0];
        currentSize -= 1;
        heap[0] = heap[currentSize];
        trickleDown(0);
        return root;
    }

    /**
     * Trickles value up the heap at given index.
     *
     * @param index
     */
    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        HeapNode bottom = heap[index];

        while (index > 0 && heap[parent].getDistToNext() > bottom.getDistToNext()) {
            heap[index] = heap[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heap[index] = bottom;
    }

    /**
     * Trickles value down the heap at given index.
     *
     * @param index
     */
    private void trickleDown(int index) {
        HeapNode root = heap[index];

        while (index < currentSize / 2) {
            int largerChild;
            int leftChild = (2 * index) + 1;
            int rightChild = leftChild + 1;

            // Determine Larger Child
            if (rightChild < currentSize && heap[leftChild].getDistToNext() > heap[rightChild].getDistToNext()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (root.getDistToNext() <= heap[largerChild].getDistToNext()) {
                break;
            }

            heap[index] = heap[largerChild];
            index = largerChild;
        }
        heap[index] = root;
    }
}
