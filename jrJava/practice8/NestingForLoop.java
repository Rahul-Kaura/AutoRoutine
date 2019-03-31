package jrJava.practice8;

public class NestingForLoop {

	public static void main(String[] args) {

		int i;//counting variable for outer loop
		int j;//counting variable for inner loop

		for(i=1; i<=4; i++) {
			for(j=1; j<=3; j++) {
				System.out.println(i + ","+ j);
			}

		}

		for(i=1; i<=4; i++) {
			for(j=1; j<=i; j++) {
				System.out.println(i + ","+ j);
			}

		}



		for(i=1; i<=4; i++) {
			for(j=i; j<=4; j++) {
				System.out.println(i + ","+ j);
			}

		}

	}
}

