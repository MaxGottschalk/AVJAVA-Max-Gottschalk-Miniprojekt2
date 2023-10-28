package main;

import javax.swing.SwingUtilities;

import view.GUI;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUI().showGUI());
	}
	
}
