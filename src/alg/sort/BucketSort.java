package alg.sort;
class ListNode{
	double value;
	ListNode next;
	ListNode(){
		this.value = -1.0; // 头结点
		this.next = null;
	}
	ListNode(double v){
		this.value = v;
		this.next = null;
	}
}
public class BucketSort {
	public static void main(String[] args){
		double[] A = new double[] {23,56,80,4,-2,-45,6,7,91,94,35,76,37} ;//{49,38,65,97,76,13,27,49};
		Print.printArray(A);

		BucketSort bucketSort = new BucketSort();
		bucketSort.bucketSort2(A);
		Print.printArray(A);
	}
	public void bucketSort2(double[] A){
		int n = A.length;
		int a = 0;
		int b = n/4;
		double[] maxMin = new double[2];
		maxMin(A,maxMin);
		double max = maxMin[0];
		double min = maxMin[1];
		int index = 0;
		ListNode[] bucket = new ListNode[b+1];
		for(int i=0;i< b+1;i++){
			bucket[i] = new ListNode();
		}
	    for(int i=0;i<b+1;i++){
	        bucket[i] = new ListNode(-1);
	    }
	    for(int i=0;i<n;i++){
	    	double val = A[i];
	    	if(val<=0)
	    		index = 0;
	    	else{
	    		index = (int) (b - (b-a)*(max-val)/(max-min));    		
	    	}
	    	insertListNode(bucket[index],val);
	    }
	    int k =0;
		for(int i=0;i<b+1;i++){
			ListNode curHead = bucket[i];
			while(curHead.next!=null){
				A[k++] = curHead.next.value;
				curHead = curHead.next;
			}
		}
	}
	public void bucketSort(double[] A){
		int n = A.length;
		int numBucket = n/4; // 默认桶的个数
		double[] maxMin = new double[2];
		maxMin(A,maxMin);
		double max = maxMin[0];
		double min = maxMin[1];
		double d = (max - min)/numBucket;
		ListNode[] bucket = new ListNode[numBucket];
		for(int i=0;i< numBucket;i++){
			bucket[i] = new ListNode();
		}
		for(int i=0;i< numBucket;i++){
			double low = min + i*d;
			double high = min + (i+1) *d;
			if(i==numBucket-1){ // 最后一个桶要包括右边界
				high++;
			}
			for(int j = 0;j<n;j++){
				double num = A[j];
				if(low<= num && num<high){
					insertListNode(bucket[i],num);
				}
			}
		}
		int k =0;
		for(int i=0;i<numBucket;i++){
			ListNode curHead = bucket[i];
			while(curHead.next!=null){
				A[k++] = curHead.next.value;
				curHead = curHead.next;
			}
		}
	}
	public  void insertListNode(ListNode head ,double value){
		ListNode insertNode = new ListNode(value);
		// 空
		if(head.next==null){
			head.next = insertNode;
			return;
		}
		// 插入在头
		if(head.next.value >= value){
			insertNode.next = head.next;
			head.next = insertNode;
			return;
		}
		// 插入在中间
		ListNode p = head;
		ListNode pre = p;
		while(p!=null){
			if(p.value>=value){
				insertNode.next = p;
				pre.next = insertNode;
				return;
			}else{
				pre = p;
				p = p.next;
			}
		}
		//插入在末尾
		if(p==null){ // 遍历到空结点，说明没有插入,pre 是最后一个结点
			pre.next = insertNode;
		}

	}
	public void maxMin(double[] A,double[] maxMin){
		maxMin[0] = Double.MIN_NORMAL;
		maxMin[1] = Double.MAX_VALUE;
		for(double a:A){
			if(a>= maxMin[0]){
				maxMin[0] = a;
			}else if(a<maxMin[1]){
				maxMin[1] = a;
			}
		}
	}
}
