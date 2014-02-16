package GUI;

import javax.swing.JPanel;

public class MainFrameSingleton {
	private final static Object o = new Object();
	private static MainFrame main;


	public static MainFrame getFrame() {
		synchronized(o) {
			if (main == null) {
				main = new MainFrame();
			}
			return main;
		}
	}

	public static class MainFrame {
		JPanel contentPane;

		private MainFrame() {
			// TODO: implement the main frame
			this.contentPane = new ContentPane();
		}
	}
}
