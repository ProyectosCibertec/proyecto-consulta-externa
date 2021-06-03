package Yarns;

import javax.swing.JComponent;

public class YarnSetVisibleComponents extends Thread {

	public void hidden(JComponent[] component) {
		for (JComponent element : component) {
			element.setVisible(false);
		}
	}

	public void show(JComponent[] component) {
		for (JComponent element : component) {
			element.setVisible(true);
		}
	}
}
