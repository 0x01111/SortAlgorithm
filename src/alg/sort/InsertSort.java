package alg.sort;

public class InsertSort {
	public void sort(int A[]){
		int n = A.length;
		for(int i=1;i<n;i++){
			int x = A[i];
			int j=i-1;
			while(j>=0 && A[j]>x){ // 0 - j�ڵ�Ԫ�ر� i����Ԫ��С�����
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = x; // ����λ��
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
