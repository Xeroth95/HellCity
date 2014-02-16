package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MainMenuPane extends JPanel{
	public MainMenuPane() {
		setBackground(Color.WHITE);
		this.setPreferredSize(new java.awt.Dimension(640, 480));
		setLayout(null);
		
		JLabel titleName = new JLabel("Hell City");
		titleName.setBounds(0, 0, 640, 65);
		titleName.setHorizontalTextPosition(SwingConstants.CENTER);
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setFont(new Font("Dialog", Font.BOLD, 20));
		add(titleName);
		
		JButton btnNewGame = new JButton("New game");
		btnNewGame.setActionCommand("New game");
		btnNewGame.setBounds(220, 95, 200, 25);
		add(btnNewGame);
		
		JButton btnLoadGame = new JButton("Load game");
		btnLoadGame.setBounds(220, 145, 200, 25);
		add(btnLoadGame);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(220, 195, 200, 25);
		add(btnHelp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(220, 245, 200, 25);
		add(btnExit);
	}
}
