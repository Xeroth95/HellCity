package start;

import gui.MainFrame;
import gui.MainMenuPane;

import javax.swing.JFrame;

public class start {
	public static void main(String[] args) {
		JFrame mainFrame = MainFrame.getMainFrame();
		MainFrame.setCurrentFrame(new MainMenuPane());
		mainFrame.setVisible(true);
		System.out.println("Start the game, please ?! NO!");
	}
}
