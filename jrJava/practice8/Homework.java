package jrJava.practice8;

public class Homework {

	public static void main(String[] args) {
int i, j;

		
		// A)
		for(i=1; i<=5; i++) {
			for(j=1; j<=i; j++) {
				System.out.println("(" + i + ", " + j + ")");
			}
		}

		
		// B)
		for(i=1; i<=5; i++) {
			for(j=1; j<i; j++) {
				System.out.println("(" + i + ", " + j + ")");
			}
		}


		// C)
		for(i=1; i<=5; i++) {
			for(j=6-i; j<=5; j++) {
				System.out.println("(" + i + ", " + j + ")");
			}
		}


		// D)
		for(i=1; i<=5; i++) {
			for(j=1; j<=6-i; j++) {
				System.out.println("(" + i + ", " + j + ")");
			}
		}


		// E)
		for(i=1; i<=5; i++) {
			for(j=i; j<=5; j++) {
				System.out.println("(" + i + ", " + j + ")");
			}
		}
		 

		// F)
		for(i=1; i<=5; i++) {
			for(j=5; j>i; j--) {
				System.out.println("(" + i + ", " + j + ")");
		

	}

}
}
}