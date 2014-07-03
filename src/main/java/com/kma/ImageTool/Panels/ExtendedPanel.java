package com.kma.ImageTool.Panels;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.kma.ImageTool.View.Config;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class holding multy - chooser panel If image's height, If image's width
 * pnlWidth, pnlHeight deploy this components
 * 
 * 
 */
public class ExtendedPanel extends JPanel implements ActionListener {

	private HalfManual pnlWidth;
	private HalfManual pnlHeight;

	public ExtendedPanel() {
		setBackground(Config.bColor);
		setSize(628, 216);
		setLayout(null);

		pnlWidth = new HalfManual("width");
		pnlWidth.setLocation(10, 0);
		add(pnlWidth);

		pnlHeight = new HalfManual("height");
		pnlHeight.setLocation(10, 108);
		add(pnlHeight);

		ButtonGroup btngrp = new ButtonGroup();
		btngrp.add(pnlWidth.getRdbtnMode());
		btngrp.add(pnlHeight.getRdbtnMode());

		// to disallow input into the height panel
		pnlWidth.getRdbtnMode().setSelected(true);
		pnlHeight.freaze();

		pnlWidth.getRdbtnMode().addActionListener(this);
		pnlHeight.getRdbtnMode().addActionListener(this);

		// set visiable
		pnlHeight.setVisible(false);
		pnlHeight.getRdbtnMode().setVisible(false);

	}

	public void clean() {
		pnlHeight.clean();
		pnlWidth.clean();
	}

	/**
	 * to allow input data only in one particular part height or width
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (pnlWidth.getRdbtnMode().isSelected()) {
			pnlHeight.clear();
			pnlWidth.rise();
			pnlHeight.freaze();
		} else {
			pnlWidth.clear();
			pnlWidth.freaze();
			pnlHeight.rise();
		}

	}

	public HalfManual getPnlWidth() {
		return pnlWidth;
	}

	public HalfManual getPnlHeight() {
		return pnlHeight;
	}
}
