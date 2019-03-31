package jrJava.GUI_usingHashCode2;

public class Student {

	private char classId;
	private int studentId;
	private String allOtherDescriptions;
	
	public Student(char classId, int studentId, String allOtherDescriptions){
		this.classId = classId;
		this.studentId = studentId;
		this.allOtherDescriptions = allOtherDescriptions;
	}
	
	public int hashCode(){
		return (classId - 'A')*3  + (studentId - 1);
	}
	
}
