package jrJava.practice8;

public class ComplexSum {

	public static void main(String[] args) {

		// !+2 + 1+2+3

		int sum = 0;
		
		int i;
		int j;
		for(i=1; i<=100; i++) {
			for(j=2;j<=i; j++) {
			sum += j;
			}
			System.out.println("The sum is " + sum);

		
		
		///Let's try this at home!!!!
		//100+(99+98+97.......) until 1
		
		
		
		}
	}

}
