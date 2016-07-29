package alg.sort;

public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
		Print.printArray(A);
		CountingSort countingSort = new CountingSort();
		int n = A.length;
		int k = 5;
		int[] B = new int[n];
		countingSort.countingSort(A,B,k);
		Print.printArray(B);
	}
	public void countingSort(int[] A,int [] B,int k){
		int[] C = new int[k+1];
		for(int i=0;i<A.length;i++){
			C[A[i]]++; // 记录 A[i] 元素出现的次数
		}
		for(int i = 1;i<=k;i++){
			C[i] = C[i] + C[i-1]; // 记录小于等于i的元素个数
		}
		int value,pos;
		for(int i = A.length-1;i>=0;i--){
			value = A[i]; // A[i] 元素的值
            pos = C[value]; // 记录出现的次数
            B[pos-1] = value; // pos-1 是新的位置
            C[value]--; // 出现次数-1
		}
	}

}
