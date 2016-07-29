package alg.sort;

public class RadixSort {
	public static void main(String[] args){
		int[] A = new int[]{49,38,65,97,76,13,27,49};
		Print.printArray(A);
		RadixSort radixSort = new RadixSort();
		radixSort.radixSort(A);
		Print.printArray(A);
	}
	public void radixSort(int[] A){
		int n = A.length;
		int[][] B = new int[10][n]; // 10��Ͱ
		int[] order = new int[10]; // ��¼ÿ��Ͱ�ڵ����ĸ���
		int pos = 1;// �Ӹ�λ��ʼ����
		int radix = 0;//������Ͱ��
		int num;
		boolean flag = true;
		while(flag){
			B = new int[10][n]; // ÿ�γ�ʼ10��Ͱ
			order = new int[10]; // ÿ�γ�ʼÿ��Ͱ�ڵ����ĸ���
			for(int i=0;i<n;i++){ // ��������Ԫ��
				num = A[i];
				radix = getRadix(num,pos); // �������������˵Ͱ��
				B[radix][order[radix]] = num;
				order[radix]++;
				// ���ݶ�����һ��Ͱ�ڣ�����
				if(order[radix]==n){
					flag=false;
				}
			}
			if(flag)// ��������
				updateA(A,B,order);
			pos++;
		}
	
		
	}
	/**
	 * ����Ͱ��������
	 * @param A ԭʼ����
	 * @param B Ͱ
	 * @param order ÿ��Ͱ��Ч���ݸ���
	 */
	public void updateA(int[]A,int[][] B,int[] order){
		int i=0;
		for(int r=0;r<=9;r++){
			if(order[r]==0)
				continue;
			for(int j=0;j<order[r];j++){
				A[i++] = B[r][j];
			}
		}
	}
	/**
	 * ��ȡ����
	 * @param num
	 * @param pos
	 * @return
	 */
	public int getRadix(int num,int pos){
		int tmp = 1;
		for(int i=0;i<pos-1;i++)
			tmp*=10;
		return (num/tmp)%10;
	}
}
