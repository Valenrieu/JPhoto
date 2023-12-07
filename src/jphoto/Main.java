package jphoto;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import jphoto.ui.menu.CustomMenu;

public class Main {
	public static void main(String[] args) {
		IconManager iconManager = new IconManager();

		JFrame window = new JFrame("JPhoto");
		window.setIconImages(iconManager.iconList);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		JMenuBar menuBar = new CustomMenu();
		window.setJMenuBar(menuBar);

		MainPanel mainPanel = new MainPanel();
		window.add(mainPanel);

		window.setVisible(true);
	}
}
