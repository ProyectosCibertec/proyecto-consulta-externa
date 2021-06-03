package Yarns;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YarnArrayList extends Thread {
	private JFrame window;

	public YarnArrayList() {
	}

	public YarnArrayList(JFrame window) {
		this.window = window;
	}

	public Boolean validateInputs(String[][] array) {

		for (String[] element : array) {
			for (int i = 0; i < element.length; i++) {
				if (element[0] == null) {
					JOptionPane.showMessageDialog(window, "El campo de " + element[1] + " no debe estar vacío", "Aviso",
							2);
					return true;
				}
				break;
			}
		}
		return false;
	}
}
