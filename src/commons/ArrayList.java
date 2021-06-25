package commons;

import javax.swing.JFrame;

public class ArrayList extends Thread {
	private JFrame window;

	public ArrayList() {
	}

	CMessage message = new CMessage();

	public ArrayList(JFrame window) {
		this.window = window;
	}

	public Boolean validateInputs(String[][] array) {

		for (String[] element : array) {
			for (int i = 0; i < element.length; i++) {
				if (element[0] == null) {
					message.message(window, "El campo de " + element[1] + " no debe estar vacío","Aviso");
					return true;
				}
				break;
			}
		}
		return false;
	}
}
