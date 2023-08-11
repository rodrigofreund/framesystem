package br.com.rodrigofreund.framesystem.view;

import java.awt.Component;

import javax.swing.JPanel;

abstract class AbstractView {

	private JPanel panel;

	AbstractView() {
		panel = new JPanel();
	}

	void addComponent(Component comp) {
		panel.add(comp);
	}
	
	void open() {
		panel.setVisible(true);
	}
	
	void close() {
		panel.setVisible(false);
	}
	
	Component getWindow() {
		return this.panel;
	}
	

}
