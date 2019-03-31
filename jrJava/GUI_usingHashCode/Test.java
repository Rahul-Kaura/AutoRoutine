package jrJava.GUI_usingHashCode;

public class Test {

	public static void main(String[] args) {
		/*
		Student s = new Student(105, "ABC");
		
		int hashCode = s.hashCode();
		System.out.println(hashCode); 
		System.out.println(Integer.toHexString(hashCode));
		
		System.out.println(s);
		*/
		
		Student s1 = new Student(101, "Student 101");
		Student s2 = new Student(102, "Student 102");
		Student s3 = new Student(103, "Student 103");
		Student s4 = new Student(104, "Student 104");
		Student s5 = new Student(105, "Student 105");
		
		Student[] students = new Student[5];
		students[s1.hashCode()] = s1;
		students[s2.hashCode()] = s2;
		students[s3.hashCode()] = s3;
		students[s4.hashCode()] = s4;
		students[s5.hashCode()] = s5;
		
		int id = 102;
		int target = id - 101;
		System.out.println(students[target].getDescription());
		
		Student s = new Student(102, "");
		System.out.println(students[s.hashCode()].getDescription());
		
	}

}
 





