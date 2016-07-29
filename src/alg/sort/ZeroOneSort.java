package alg.sort;

public class ZeroOneSort {
	public static void main(String[] args){
		int[] A = new int[]{0,1,1,1,0,0,1,0,1,0,0,1,0,1,1,0,0};
		Print.printArray(A); // 0:9 
		ZeroOneSort zeroOneSort = new ZeroOneSort();
		zeroOneSort.zeroOneSort4(A);
		Print.printArray(A);
	}
	public void zeroOneSort4(int[] A){
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
	public void zeroOneSort3(int[] A){
		int n = A.length;
		int[] B = new int[n];
		int k =0;
		for(int i=0;i<n;i++){
			if(A[i]==0)
				B[k++]=A[i];
		}
		for(int i=0;i<n;i++){
			if(A[i]==1)
				B[k++]=A[i];
		}
		for(int i=0;i<n;i++){
			A[i] = B[i];
		}
	}
	public void zeroOneSort2(int[] A){
		int n = A.length;
		int low = 0;
		int high = n-1;
		while(low<high){
			while(low<high && A[low]==0) low ++;
			while(low<high && A[high]==1) high--;
			if(low<high){
				swap(A,low,high);
			}
			low++;
			high--;
		}
	}
	public void swap(int[] A,int i,int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	public void quickSort(int[] A,int low ,int high){
		
		
	}
	public void zeroOneSort1(int[] A){
		int zero = 0;
		int n = A.length;
		for(int i=0;i<n;i++){
			if(A[i]==0)
				zero++;
		}
		for(int i=0;i<zero;i++)
			A[i]=0;
		for(int i=zero;i<n;i++)
			A[i]=1;
	}
}
