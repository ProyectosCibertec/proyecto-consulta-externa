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

	public void message(JFrame window, String message, String... title) {
		String setTitle = title.length > 0 ? title[0] : "aviso";
		JOptionPane.showMessageDialog(window, message, setTitle, 2);
	}

	public void message(MouseAdapter mouseAdapter, String message, String... title) {
		String setTitle = title.length > 0 ? title[0] : "aviso";
		JOptionPane.showMessageDialog(window, message, setTitle, 2);
	}

}
