
public class BinaryHeap {
	
	private int[] heap;
	private int size;
	
	public BinaryHeap() {
		heap = new int[10];
		heap[0] = Integer.MIN_VALUE;
		size = 0;
	}
	
	private int leftChild(int pos) {
		return 2*pos;
	}
	
	private int parent(int pos) {
		return pos/2;
	}
	
	private boolean isLeaf(int pos) {
		return ((pos > size/2) & (pos <= size));
	}
	
	private void swap(int pos1, int pos2) {
		int temp;
		temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}
	
	public void add(int item) {
		if(size >= heap.length-1) {
			grow();
		}
		size ++;
		int current = size;
		
		heap[size] = item;
		 
		 while(heap[current] < heap[parent(current)]) {
			 swap(current, parent(current));
			 current = parent(current);
		 }
	}

	public int remove() {
		swap(1, size);
		size--;
		if(size != 0) {
			bubbledown(1);
		}
		return heap[size+1];
	}
	
	private void bubbledown(int pos) {
		int smalest;
		while(!isLeaf(pos)) {
			smalest = leftChild(pos);
			if((smalest < size) && (heap[smalest] > heap[smalest+1])) {
				smalest = smalest+1;
			}
			if(heap[pos] <= heap[smalest]) {
				return;
			}
			swap(pos, smalest);
			pos = smalest;
		}
	}
	
	private void grow() {
		int[] temp = new int[(int) Math.pow(heap.length, 2)];
		System.arraycopy(heap,  0,  temp,  0,  heap.length);
		heap = temp;
	}

}
