package jrJava.GUI_actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PQR implements ActionListener {

	// field1
	// field2
	// ...
	
	// method1(..){ ...}
	// method2(..){ ...}
    // ....
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("myBuyButton")) {
			System.out.println("I am PQR. I just bought 3000 google stock.");
		}
		else if(e.getActionCommand().equals("mySellButton")) {
			System.out.println("I am PQR. I just sold 3000 google stock.");
		}
	}

}






