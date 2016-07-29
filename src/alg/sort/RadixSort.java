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
		int[][] B = new int[10][n]; // 10个桶
		int[] order = new int[10]; // 记录每个桶内的数的个数
		int pos = 1;// 从个位开始遍历
		int radix = 0;//基数，桶号
		int num;
		boolean flag = true;
		while(flag){
			B = new int[10][n]; // 每次初始10个桶
			order = new int[10]; // 每次初始每个桶内的数的个数
			for(int i=0;i<n;i++){ // 遍历所有元素
				num = A[i];
				radix = getRadix(num,pos); // 求出基数，或者说桶号
				B[radix][order[radix]] = num;
				order[radix]++;
				// 数据都放在一个桶内，结束
				if(order[radix]==n){
					flag=false;
				}
			}
			if(flag)// 更新数组
				updateA(A,B,order);
			pos++;
		}
	
		
	}
	/**
	 * 利用桶更新序列
	 * @param A 原始数组
	 * @param B 桶
	 * @param order 每个桶有效数据个数
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
	 * 获取基数
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
