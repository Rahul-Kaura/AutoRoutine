package main.java.listener;
import java.util.ArrayList;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
public class KeyListener implements NativeKeyListener {
	private ArrayList<Integer> keys;
	public void nativeKeyPressed(NativeKeyEvent e) {
		keys.add(e.getKeyCode());
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		//System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		//System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}
	public ArrayList<Integer> returnKeys() {
		return keys;
	}
}
