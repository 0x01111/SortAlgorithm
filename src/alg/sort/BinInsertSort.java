package alg.sort;

public class BinInsertSort {
	public void sort(int[] A){
		int n = A.length;
		for(int i=1;i<n;i++){
			int left = 0;
			int right = i-1;
			int x = A[i];
			int id = binaryId(A,left,right,x);// 二分查找找到对应的插入位置
			for(int j=right;j>=id;j--){ // 移动元素
				A[j+1] = A[j];
			}
			A[id] = x;
		}
	}
	// 二分查找找到对应的插入位置
	public int binaryId(int[] A,int left,int right,int x){
		if(left>=right)
			return left;
		while(left<= right){
			int mid = left + (right - left)/2;
			if(A[mid]==x)
				return mid;
			else if(A[mid]<x)
				left = mid + 1;
			else 
				right = mid - 1;
		}
		return left;
	}
	public static void main(String[] args){
		int[] A = new int[]{49,38,65,97,76,13,27,49};
		Print.printArray(A);
		BinInsertSort binInsertSort = new BinInsertSort();
		binInsertSort.sort(A);
		Print.printArray(A);
	}
}	
