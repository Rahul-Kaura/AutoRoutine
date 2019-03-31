package jrJava.GUI_usingHashCode3;

public class Thing {

	private int x1;
	private int x2;
	private int x3;
	// ....
	
	
	
	
	public int hashCode(){
		return x1*1000000 + x2*1000 + x3;
		//return x1<<16 + x2<<8 + x3;
	}
	
}
