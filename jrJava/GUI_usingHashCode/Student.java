package jrJava.GUI_usingHashCode;

public class Student {

	private int id;
	private String allOtherDescriptions;
	
	
	public Student(int id, String allOtherDescriptions){
		this.id = id;
		this.allOtherDescriptions = allOtherDescriptions;
	}
	
	
	public String getDescription(){
		return allOtherDescriptions;
	}
	
	
	public int hashCode(){
		return id - 101;
	}
	
}
