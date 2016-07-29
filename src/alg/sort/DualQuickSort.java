package alg.sort;

public class DualQuickSort {
	public void dualQuickSort(int[] A,int left,int right){
		if(left>=right)
		{
//			System.out.println(left+"\t"+right);
			return;
		}
		if(A[left]>A[right])
		{
			swap(A,left,right);
		}
		int less = left;
		int great = right;
		int pivot1 = A[left];
		int pivot2 = A[right];
		while (A[++less] < pivot1);
        while (A[--great] > pivot2);
        
        /*
         * Partitioning:
         *
         *   left part           center part                   right part
         * +--------------------------------------------------------------+
         * |  < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2  |
         * +--------------------------------------------------------------+
         *               ^                          ^       ^
         *               |                          |       |
         *              less                        k     great
         *
         * Invariants:
         *
         *              all in (left, less)   < pivot1
         *    pivot1 <= all in [less, k)     <= pivot2
         *              all in (great, right) > pivot2
         *
         * Pointer k is the first index of ?-part.
         */
		outer:
		for(int k = less - 1;++k<= great;){
			int ak = A[k];
			if(ak<pivot1){ // ak С�� p1
				swap(A,k,less); // ����
				less++;
			}else if(ak>pivot2){ // ak > p2 
				 while (A[great] > pivot2) { // �ҵ�������������λ�� 
                     if (great-- == k) {
                    	 System.out.println("outer");
                         break outer;
                     }
                 }
				 if (A[great] < pivot1) { // a[great] <= pivot1��  
                     
					 A[k] = A[less];  // less�ŵ� k��λ��,  k λ�õ�Ԫ���������� ak��  
                     A[less] = A[great]; // great �ŵ�less��λ�� 
                     ++less;  // ���� less 
                 } else { // pivot1 <= a[great] <= pivot2
                     A[k] = A[great];
                 }
                 /*
                  * Here and below we use "a[i] = b; i--;" instead
                  * of "a[i--] = b;" due to performance issue.
                  */
                 A[great] = ak; // ak �ŵ� greatλ�� 
                 --great;
			} // ������������м�λ�ã����ÿ��� 
		}

		System.out.println("left :"+left+" less " + less + " great" + great+" right "+ right);
		Print.printArray(A);	
		
		dualQuickSort(A,left,less-1);
		dualQuickSort(A,less,great);
		dualQuickSort(A,great+1,right);
	}
	public void swap(int[] A,int i,int j){
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	public static void main(String[] args){
		int[] A = new int[]{13,3,65,97,76,10,35,71,5,7,3,27,49};
		Print.printArray(A);
		DualQuickSort dualQuickSort = new DualQuickSort();
		int l = 0;
		int r = A.length -1;
		dualQuickSort.dualQuickSort(A,l,r);
		Print.printArray(A);
	}
	
}

