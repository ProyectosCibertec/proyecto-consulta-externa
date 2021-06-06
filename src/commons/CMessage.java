package commons;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CMessage {

	private JFrame window;
	private String message, title;

	public CMessage() {
	}

	public CMessage(JFrame window, String message) {
		this.window = window;
		this.message = message;
	}

	public CMessage(JFrame window, String message, String title) {
		this.window = window;
		this.message = message;
		this.title = title;
	}

	public void message(JFrame window, String message) {
		JOptionPane.showMessageDialog(window, message, "Aviso", 2);
	}

	public void message(JFrame window, String message, String title) {
		JOptionPane.showMessageDialog(window, message, title, 2);
	}

	public void message(MouseAdapter mouseAdapter, String message) {
		JOptionPane.showMessageDialog(window, message, "Aviso", 2);
	}

	public void message(MouseAdapter mouseAdapter, String message, String title) {
		JOptionPane.showMessageDialog(window, message, title, 2);
	}

}
