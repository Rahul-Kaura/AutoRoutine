package automation;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class GUI {
	// Gui 
	private static JFrame frame = new JFrame("Auto Routine");
	private static JPanel mainpanel = new JPanel(new CardLayout());
	private static CardLayout c1 = new CardLayout();
	static class buttonListener implements ActionListener{
		private JPanel nextpanel;
		public buttonListener(JPanel panel) {
			nextpanel = panel;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			mainpanel.add(nextpanel, "nextpanel");
			c1.show(mainpanel, "nextpanel");
		}
		
	}
	public static void guiInit() throws AWTException, IOException {
		//Creates JFame with panel and buttons
		 
		frame.setBounds(200, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainpanel = new JPanel(c1);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE);
		GUI.loginGUI(panel);
		mainpanel.add(panel, "Login Card");
		frame.add(mainpanel);
		
		frame.setVisible(true);
	}
	private static void loginGUI(JPanel panel) throws AWTException, IOException {
		JPanel mainpanel = GUI.mainGUI();
		JPanel logininput = new JPanel();
		JLabel label = new JLabel("Auto Routine");
		logininput.setLayout(new BoxLayout(logininput, BoxLayout.Y_AXIS));
		logininput.add(label);
		GUI.createForm(logininput, "Username");
		GUI.createForm(logininput, "Password");
		panel.add(logininput, BorderLayout.PAGE_START);
		
		JButton button=new JButton("Login");
		button.addActionListener(new buttonListener(mainpanel));
		JButton button1=new JButton("New User");
		JPanel loginbuttons = new JPanel();
		loginbuttons.add(button); 
		loginbuttons.add(button1);
		panel.add(logininput);
		panel.add(loginbuttons, BorderLayout.PAGE_END);
	}
	private static JPanel mainGUI() throws AWTException, IOException {
		JPanel mainpane = new JPanel();
		JButton execroutine = new JButton("Execute Routine");
		JButton newroutine = new JButton("Add new Routine");
		mainpane.add(execroutine);
		mainpane.add(newroutine);
		return mainpane;
	}
	private static void createForm(JPanel panel, String name) {
		JPanel temppanel = new JPanel();
		JLabel label= new JLabel(name);
        JTextField textfield = new JTextField(20);
        label.setLabelFor(textfield);
        temppanel.add(label);
        temppanel.add(textfield);
        panel.add(temppanel);
	}
	private boolean authenticate(String username, String pass) throws AWTException, IOException {
		String salt = Auth.generateSalt(256).toString();
		String hashed_pass=Auth.hashPassword(pass, salt).toString();
		String stuff=username+" "+hashed_pass;
		FileReader file = new FileReader("data.txt");
		BufferedReader data = new BufferedReader(file);
		String line = data.readLine();
		while (line!=null) {
			if (stuff == data.readLine()) {
				data.close();
				return true;
			}
			data.readLine();
		}
		data.close();
		return false;
	}
	public void createNewUser(String username, String hashed_pass) throws IOException {
		FileWriter file = new FileWriter("data.txt", true);
		file.append(username+" "+hashed_pass+"\n");
		file.close();
	}
	public static void main(String[] args) throws AWTException, IOException {
		Auto robo = new Auto();
		GUI.guiInit();
	}
}