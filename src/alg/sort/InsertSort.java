package alg.sort;

public class InsertSort {
	public void sort(int A[]){
		int n = A.length;
		for(int i=1;i<n;i++){
			int x = A[i];
			int j=i-1;
			while(j>=0 && A[j]>x){ // 0 - j内的元素比 i处的元素小则后移
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = x; // 插入位置
		}
	}
	public  static void main(String[] args){
		int[] A = new int[]{49,38,65,97,76,13,27,49};
		Print.printArray(A);
		InsertSort insertSort = new InsertSort();
		insertSort.sort(A);
		Print.printArray(A);
		
	}
}
