package alg.sort;

public class MergeSort {
	
	public static void main(String[] args){
		int[] A = new int[]{49,38,65,97,76,13,27,49};
        Print.printArray(A);
        MergeSort MergeSort = new MergeSort();
        MergeSort.mergeSort(A,0,A.length-1);
        Print.printArray(A);
	}
	public void mergeSort(int[] A,int low,int high){
		if(low>=high)
			return;
		int mid = low + (high - low)/2;
		mergeSort(A,low,mid);
		mergeSort(A,mid+1,high);
		merge(A,low,mid,high);
	}
	/**
	 * ��������������й鲢
	 * A�������������low - mid��mid+1-high���й鲢���������ֶ��������
	 * @param A
	 * @param low
	 * @param mid
	 * @param high
	 */
	public void merge(int[] A,int low ,int mid ,int high){
		int len = high - low + 1; 
		int[] C = new int[len]; // ��ʱ����м�鲢����
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid || j<=high){
			if(i<=mid && j<=high){
				if(A[i]<A[j]){
					C[k]=A[i];
					k++;
					i++;
				}else{
					C[k]=A[j];
					k++;
					j++;
				}
			}else if(i<=mid){
				C[k] = A[i];
				k++;
				i++;
			}else if(j<=high){
				C[k] = A[j];
				k++;
				j++;
			}
		}
		for(k=0;k<len;k++){
			A[k+low] = C[k];
		}
		
	}
}
