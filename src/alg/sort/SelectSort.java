package alg.sort;

public class SelectSort {
	public void sort(int[] A){
		int n = A.length;
		for(int i=0;i<n;i++){
			int minid = i; // 选择最小元素的id 
			for(int j=i+1;j<n;j++){
				if(A[j]<A[minid])
					minid = j;
			}
			int tmp = A[i];
			A[i] = A[minid];
			A[minid] = tmp;
		}
	}
	Object ob = new Object();
	public static void main(String[] args){
		int[] A = new int[]{49,38,65,97,76,13,27,49};
		Print.printArray(A);
		SelectSort selectSort = new SelectSort();
		selectSort.sort(A);
		Print.printArray(A);
	}
}
