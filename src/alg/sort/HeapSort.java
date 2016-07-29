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
		buildMaxHeap(A,n);// �����󶥶ѣ�0 λ�������ֵ
		for(int i =n;i>=1;i--){
			swap(A,i,0); // 0 λ�������ֵ������Ϊ����0λ��Ԫ�غ;ֲ����idλ�ý��н���
			heap1(A,i-1,0); // �����󣬿��ܲ��Ǵ󶥶ѣ����е���  
		}
	}
	/**
	 * �������Ե����ϵĹ���
	 * @param A
	 * @param n
	 */
	public void buildMaxHeap(int[] A,int n){
		for(int i=n/2;i>=0;i--){
			heap1(A,n,i);
		}
	}
	/**
	 * i λ��Ԫ�ز��뵽���У�����Ϊ�󶥶�
	 * �ݹ�ʵ��
	 * @param A
	 * @param n
	 * @param i
	 */
	public void heap(int[] A,int n,int i){
		// ����
		int l = left(i);
		// �Һ���
		int r = right(i);
		// ������±�
		int largest = -1;
		// i l r �ҵ����ֵ���±꣬�ҵ�����н���
		if(l<=n && A[l] >A[i])
			largest = l;
		else
			largest = i;
		if(r<=n && A[r]>A[largest])
			largest = r;
		if(largest!=i){
			swap(A,largest,i); // ���ֵ�±��i��ֵ���н���
			heap(A,n,largest); // ������largest ���ڵ�����ҲӦ���Ǵ󶥶ѣ�����һ���ݹ�Ĺ�����
		}
	}
	public void heap1(int[] A,int n,int i){
		// ����
		int l = left(i);
		// �Һ���
		int r = right(i);
		// ������±�
		int largest = -1;
		// i l r �ҵ����ֵ���±꣬�ҵ�����н���
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
