package com.kma.ImageTool.ViewComponents;

import java.awt.Color;
import java.awt.Font;
//import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class MetroTextView extends JTextField {

	public MetroTextView() {
		super();
		setFont(new Font("Segoe UI", Font.PLAIN, 11));

		/**
		 * to repaint border in white color after update
		 */
		this.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				Color highlight = Color.WHITE;
				Border border = BorderFactory.createSoftBevelBorder(1,
						highlight, highlight);
				setBorder(border);

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void setBorder(Border border) {
		super.setBorder(BorderFactory.createEmptyBorder());
	}

	/**
	 * To show com.kma.ImageTool.Error by surrounding it by red border
	 */
	public void showError() {

		Color highlight = new Color(255, 67, 67);
		Border border = BorderFactory.createSoftBevelBorder(1, highlight,
				highlight);
		this.setBorder(border);
	}

}
