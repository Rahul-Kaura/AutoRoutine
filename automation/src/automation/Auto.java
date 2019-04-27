package automation;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
public class Auto {
	// Incomplete Auto class that should be able to automate tasks
	// Currently working on implementing Key and Mouse Listeners using System Hook
	
	public void roboAuto() throws AWTException {
		//This is supposed to open up a txt containing the preprogrammed routines and do it
		Robot rb = new Robot();
		
	}
//	public void learnRoutine() {
		//This tracks the mouse and keyboard actions and writes to a txt file 
	//}
//	public static FFmpegFrameRecorder getRecorder() throws Exception
	//{
		// if(recorder!=null)
		 //{
			// return recorder;
		 //}
		 //recorder = new FFmpegFrameRecorder(outputVideo,videoWidth,videoHeight);
		 //recorder.setFrameRate(videoFrameRate);
		 //recorder.setVideoCodecName("mpeg4");
         //recorder.setVideoBitrate(videoBitRate);
         //recorder.setFormat("mp4");
         //recorder.setVideoQuality(videoQuality);; 
         //recorder.start();
         //return recorder;
	//}
	private static Point getMouseLocation() {
		//mouse tracker
		return MouseInfo.getPointerInfo().getLocation();
	}
	public static void main (String[] args) throws InterruptedException {
		for (int i = 0;i<100;i++) {
			System.out.println(getMouseLocation());
			Thread.sleep(1000);
		}
	}
}
