package start;

import javax.swing.JFrame;

import GUI.MainFrameSingleton;

public class start {
	public static void main(String[] args) {
		JFrame mainFrame = MainFrameSingleton.getFrame();
		System.out.println("Start the game!");
	}
}
