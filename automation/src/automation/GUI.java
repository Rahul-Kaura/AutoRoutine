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
	// GUI
	private static JPanel main;
	private static JFrame frame = new JFrame("Auto Routine");
	private static CardLayout c1 = new CardLayout();
	private static Auto robo = new Auto();
	static class buttonListener implements ActionListener{
		private JPanel nextpanel;
		private String name;
		public buttonListener(String panelname, JPanel ...panel) {
			if (panel.length!=0) {
				nextpanel = panel[0];
			} else {
				nextpanel = null;
			}
			name = panelname;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//for (int i=0;i<main.getComponentCount();i++) {
			//	if (main.getComponent(i).getName()==name) {
			//		c1.show(main, name);
			//	}
			//}
			if (nextpanel==null) {
				c1.first(main);
			}
			else {
				main.add(nextpanel, name);
				c1.show(main, name);
			}
		}
	
	}
	public static void guiInit() throws AWTException, IOException {
		//Creates JFame with panel and buttons
		 
		frame.setBounds(200, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main = new JPanel(c1);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE);
		GUI.loginGUI(panel);
		main.add(panel, "Login Card");
		frame.add(main);
		
		frame.setVisible(true);
	}
	private static void loginGUI(JPanel panel) throws AWTException, IOException {
		JPanel logininput = new JPanel();
		JLabel label = new JLabel("Auto Routine");
		JPanel usernamepanel = GUI.createForm("Username");
		JPanel passpanel = GUI.createForm("Password");
		logininput.setLayout(new BoxLayout(logininput, BoxLayout.Y_AXIS));
		logininput.add(label);
		logininput.add(usernamepanel);
		logininput.add(passpanel);
		panel.add(logininput, BorderLayout.PAGE_START);
		
		JButton button=new JButton("Login");
		button.addActionListener(new buttonListener("mainpanel", GUI.mainGUI()));
		JButton button1=new JButton("New User");
		button1.addActionListener(new buttonListener("newuserpanel", GUI.newUserGUI()));
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
		newroutine.addActionListener(new buttonListener("recordgui", GUI.recordingGUI()));
		mainpane.add(execroutine);
		mainpane.add(newroutine);
		return mainpane;
	}
	private static JPanel newUserGUI() throws AWTException, IOException {
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
		JPanel usernamepanel = GUI.createForm("New Username");
		JPanel passpanel = GUI.createForm("New Password");
		input.add(usernamepanel);
		input.add(passpanel);
		JButton button = new JButton("Create New User");
		button.addActionListener(new buttonListener("mainpanel"));
		input.add(button);
		return input;
	}
	private static JPanel recordingGUI() throws AWTException, IOException {
		JPanel recordGUI = new JPanel();
		JLabel recordtext = new JLabel("Recording Screen");
		recordGUI.add(recordtext);
		return recordGUI;
	}
	private static JPanel noUserGUI() throws AWTException, IOException {
		JPanel nouserGUI = new JPanel();
		JButton tryagainbutton = new JButton();
		JLabel text = new JLabel("Username or Password is incorrect");
		tryagainbutton.addActionListener(new buttonListener("mainpanel"));
		nouserGUI.add(text);
		nouserGUI.add(tryagainbutton);
		return nouserGUI;
	}
	private static JPanel createForm(String name) {
		JPanel temppanel = new JPanel();
		JLabel label= new JLabel(name);
        JTextField textfield = new JTextField(20);
        label.setLabelFor(textfield);
        temppanel.add(label);
        temppanel.add(textfield);
        return temppanel;
	}
	private static boolean authenticate(JPanel loginpanel,String username, String pass) throws AWTException, IOException {
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
	public void createNewUser(String username, String pass) throws IOException {
		String salt = Auth.generateSalt(256).toString();
		String hashed_pass=Auth.hashPassword(pass, salt).toString();
		FileWriter file = new FileWriter("data.txt", true);
		file.append(username+" "+hashed_pass+"\n");
		file.close();
	}
	public static void main(String[] args) throws AWTException, IOException {
		GUI.guiInit();
	}
}