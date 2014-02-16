package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	private final static Object o = new Object();
	private static MainFrameSingleton main;
	
	
	public static JFrame getMainFrame() {
		synchronized(o) {
			if (main == null) {
				main = new MainFrameSingleton();
			}
			return main;
		}
	}
	
	public static void setCurrentFrame(JPanel contentPane) {
		assert (main != null) : "Mainframe was not initialized!";
		main.switchContentPane(contentPane);
	}
	
	private static class MainFrameSingleton extends JFrame {
		private static final long	serialVersionUID	= 1218619392791954880L;
		JPanel contentPane;
		
		private MainFrameSingleton() {
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
		
		public void switchContentPane(JPanel contentPane) {
			this.contentPane = contentPane;
			this.setContentPane(this.contentPane);
			this.pack();
		}
	}
}
