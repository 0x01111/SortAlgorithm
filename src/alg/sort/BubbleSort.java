package alg.sort;

public class BubbleSort {
	public void sort(int[] A){
		int n = A.length;
		boolean flag = true;;
		for(int i=n-1;i>=0;i--){
			flag = true;
			for(int j=0;j<i;j++){
				if(A[j]>A[j+1]){
					int tmp = A[j];
					A[j] = A[j+1];
					A[j+1] = tmp;
					flag = false;
				}
			}
			if(flag)
				return;
		}
	}
	public static void main(String[] args){
		int[] A = new int[]{49,38,65,97,76,13,27,49};
		Print.printArray(A);
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(A);
		Print.printArray(A);
	}
}
