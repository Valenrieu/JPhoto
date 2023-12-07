package jphoto;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		IconManager iconManager = new IconManager();

		JFrame window = new JFrame("JPhoto");
		window.setIconImages(iconManager.iconList);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}
}
