package alg.sort;

import java.util.List;

public class Print {
	public  static void printArray(int[] A){
		for(int a:A){
			System.out.print(a+"\t");
		}
		System.out.println();
	}
	public  static void printArray(double[] A){
		for(double a:A){
			System.out.print(a+"\t");
		}
		System.out.println();
	}
	public  static void printArray(List<Integer> A){
		for(int a:A){
			System.out.print(a+"\t");
		}
		System.out.println();
	}
}
