package gui;

import javax.swing.JFrame;
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
	
	public static class MainFrame extends JFrame {
		JPanel contentPane;
		
		private MainFrame() {
			// TODO: implement the main frame
			super("HellCity v0.0.1");
			this.initComponents();
			this.pack();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		@Override
		public void setVisible(boolean b) {
			// TODO: check for validity
			assert (contentPane != null) : "Fehler beim Initialisieren der MainFrame (InitError: contentPane)";
			super.setVisible(b);
		}
		
		private void initComponents() {
			this.contentPane = new JPanel();
			this.contentPane.setPreferredSize(new java.awt.Dimension(640, 480));
			this.setContentPane(this.contentPane);
			this.contentPane.setBackground(java.awt.Color.WHITE);
		}
	}
}
