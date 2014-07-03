package com.kma.ImageTool.DTO;

import com.kma.ImageTool.Panels.ExtendedPanel;
import com.kma.ImageTool.Panels.HalfManual;
import com.kma.ImageTool.View.XmlWrapper;

/**
 * class will write info if extended mode selected
 * 
 * @author yaroslav
 * 
 */
public class HExtended implements Handler {

	@Override
	public void execute(XmlWrapper wr, ImageParametrs ip) {

		// check what modify height or width

		ExtendedPanel p = wr.getPnlExtended();
		HalfManual height = p.getPnlHeight();
		HalfManual width = p.getPnlWidth();

		// height part
		// which chck boxe's selected LESS
		if (height.getChkbxLessHeight().isSelected()) {
			ip.setLessHeight(true);
		}

		// LESS HEIGHT CHECK

		// compared
		ip.setLessCompareHeight(height.getPanelLessHeight().getCompared());
		ip.setTypeOfLessHeightToCheck(height.getPanelLessHeight()
				.getComboBoxFirst().getSelectedItem().toString());

		// resize to
		ip.setLessResizeToHeight(height.getPanelLessHeight().getResize());
		ip.setTypeOfLessHeightToChange(height.getPanelLessHeight()
				.getComboBoxSecond().getSelectedItem().toString());

		// between

		// BETWEEN
		if (height.getChkbxBetweenHeight().isSelected()) {
			ip.setBetweenHeight(true);
		}

		ip.setBetweenFirstCompareHeight(height.getPanelBetweenHeight()
				.getFirst());
		ip.setBetweenSecondCompareHeight(height.getPanelBetweenHeight()
				.getSecond());
		ip.setBetweenResizeHeight(height.getPanelBetweenHeight().getResizeTo());

		// px and pt
		ip.setTypeOfBetweenHeightToCheck(height.getPanelBetweenHeight()
				.getComboBox().getSelectedItem().toString());

		// between type is the same that means last set the rule
		ip.setTypeOfBetweenHeightToCheck(height.getPanelBetweenHeight()
				.getComboBox_1().getSelectedItem().toString());

		// resize type to

		ip.setTypeOfBetweenHeightToChange(height.getPanelBetweenHeight()
				.getComboBox_2().getSelectedItem().toString());

		// MORE HEIGHT
		if (height.getChkbxMoreHeight().isSelected()) {
			ip.setMoreHeight(true);
		}

		// more HEIGHT CHECK

		// compared
		ip.setMoreComparedHeight(height.getPanelMoreHeight().getCompared());
		ip.setTypeOfMoreHeightToCheck(height.getPanelMoreHeight()
				.getComboBoxFirst().getSelectedItem().toString());

		// resize to
		ip.setMoreResizeHeight(height.getPanelMoreHeight().getResize());
		ip.setTypeOfMoreHeightToChange(height.getPanelMoreHeight()
				.getComboBoxSecond().getSelectedItem().toString());

		// // WIDTH SECTION ////////////////

		// which chck boxe's selected LESS
		if (width.getChkbxLessHeight().isSelected()) {
			ip.setLessWidth(true);
		}

		// LESS HEIGHT CHECK

		// compared
		ip.setLessCompareWidth(width.getPanelLessHeight().getCompared());
		ip.setTypeOfLessWidthToCheck(width.getPanelLessHeight()
				.getComboBoxFirst().getSelectedItem().toString());

		// resize to
		ip.setLessResizeToWidth(width.getPanelLessHeight().getResize());
		ip.setTypeOfLessWidthToChange(width.getPanelLessHeight()
				.getComboBoxSecond().getSelectedItem().toString());

		// between

		// BETWEEN
		if (width.getChkbxBetweenHeight().isSelected()) {
			ip.setBetweenWidth(true);
		}

		ip.setBetweenFirstCompareWidth(width.getPanelBetweenHeight().getFirst());
		ip.setBetweenSecondCompareWidth(width.getPanelBetweenHeight()
				.getSecond());
		ip.setBetweenResizeWidth(width.getPanelBetweenHeight().getResizeTo());

		// px and pt
		ip.setTypeOfBetweenWidthToCheck(width.getPanelBetweenHeight()
				.getComboBox().getSelectedItem().toString());

		// between type is the same that means last set the rule
		ip.setTypeOfBetweenWidthToCheck(width.getPanelBetweenHeight()
				.getComboBox_1().getSelectedItem().toString());

		// resize type to

		ip.setTypeOfBetweenWidthToChange(width.getPanelBetweenHeight()
				.getComboBox_2().getSelectedItem().toString());

		// MORE HEIGHT
		if (width.getChkbxMoreHeight().isSelected()) {
			ip.setMoreWidth(true);
		}

		// more HEIGHT CHECK

		// compared
		ip.setMoreComparedWidth(width.getPanelMoreHeight().getCompared());
		ip.setTypeOfMoreWidthToCheck(width.getPanelMoreHeight()
				.getComboBoxFirst().getSelectedItem().toString());

		// resize to
		ip.setMoreResizeWidth(width.getPanelMoreHeight().getResize());
		ip.setTypeOfMoreWidthToChange(width.getPanelMoreHeight()
				.getComboBoxSecond().getSelectedItem().toString());

	}
}
