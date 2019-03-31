package jrJava.practice8;

public class MultiplicationTables {

	public static void main(String[] args) {
		
	/*	
		int sum = 0;
		int i;
		int j;
		
		for(i=2; i<=9; i++) {
			for(j=2;j<=9; j++) {
		
		
			System.out.println(i + "x" +j + " = " + i*j);
		///Let's avoid duplicate entries
	*/		
		int sum = 0;
		int i;
		int j;
		
		for(i=2; i<=9; i++) {
			for(j=i;j<=9; j++) {
		
		
			System.out.println(i + "x" +j + " = " + i*j);
		
	}
		}
	}
}
