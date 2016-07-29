package alg.sort;

public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[]{49,38,65,97,76,13,27,49};
        Print.printArray(A);
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(A);
        Print.printArray(A);

	}
	public int parent(int i){
		int p = (i-1)/2;
		return p;
	}
	public int left(int i){
		int l = i*2+1;
		return l;
	}
	public int right(int i){
		int r = i*2+2;
		return r;
	}
	public void heapSort(int[] A){
		int n = A.length - 1;
		buildMaxHeap(A,n);// 建立大顶堆，0 位置是最大值
		for(int i =n;i>=1;i--){
			swap(A,i,0); // 0 位置是最大值，调整为升序，0位置元素和局部最大id位置进行交换
			heap1(A,i-1,0); // 交换后，可能不是大顶堆，进行调整  
		}
	}
	/**
	 * 建堆是自底向上的过程
	 * @param A
	 * @param n
	 */
	public void buildMaxHeap(int[] A,int n){
		for(int i=n/2;i>=0;i--){
			heap1(A,n,i);
		}
	}
	/**
	 * i 位置元素插入到堆中，调整为大顶堆
	 * 递归实现
	 * @param A
	 * @param n
	 * @param i
	 */
	public void heap(int[] A,int n,int i){
		// 左孩子
		int l = left(i);
		// 右孩子
		int r = right(i);
		// 最大结点下标
		int largest = -1;
		// i l r 找到最大值的下标，找到后进行交换
		if(l<=n && A[l] >A[i])
			largest = l;
		else
			largest = i;
		if(r<=n && A[r]>A[largest])
			largest = r;
		if(largest!=i){
			swap(A,largest,i); // 最大值下标和i处值进行交换
			heap(A,n,largest); // 交换后，largest 所在的子树也应该是大顶堆，下面一个递归的过程了
		}
	}
	public void heap1(int[] A,int n,int i){
		// 左孩子
		int l = left(i);
		// 右孩子
		int r = right(i);
		// 最大结点下标
		int largest = -1;
		// i l r 找到最大值的下标，找到后进行交换
		if(l<=n && A[l] >A[i])
			largest = l;
		else
			largest = i;
		if(r<=n && A[r]>A[largest])
			largest = r;
		while(largest!=i){
			swap(A,largest,i);
			i = largest;
			l = left(i);
			r = right(i);
			if(l<=n && A[l] >A[i])
				largest = l;
			else
				largest = i;
			if(r<=n && A[r]>A[largest])
				largest = r;
		}
	}
	public void swap(int[] A,int i,int j){
		int tmp= A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

}
