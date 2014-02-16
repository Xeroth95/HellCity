package start;

import gui.MainFrameSingleton;

import javax.swing.JFrame;

public class start {
	public static void main(String[] args) {
		JFrame mainFrame = MainFrameSingleton.getFrame();
		mainFrame.setVisible(true);
		System.out.println("Start the game!");
	}
}
