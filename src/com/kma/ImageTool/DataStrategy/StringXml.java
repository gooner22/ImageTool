package com.kma.ImageTool.DataStrategy;

import com.kma.ImageTool.DTO.ImageParametrs;

public class StringXml {

	private final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<!-- Edited by mintCar -->\n<IMAGES_FOR_EDIT>\n\n";

	private final String OPEN_RENAME = "<RENAME_IMAGE_TO>";
	private final String CLOSE_RENAME = "</RENAME_IMAGE_TO><!-- If this field exists than image would be renamed for this. RESTRICTION: You should not write an extension of the file, only NAME required without quotes. E.g.: <RENAME_IMAGE_TO>Native Kiev</RENAME_IMAGE_TO> -->\n\n";

	private final String OPEN_FORMAT = "\n<CHANGE_FORMAT_TO>";
	private final String CLOSE_FORMAT = "</CHANGE_FORMAT_TO><!-- If this field exists than image format would be changed for this. RESTRICTION: File format should be written without quotes and without previous dot."
			+ " All possible formt extensions: gif, png, tiff, tif, jpg, crw, cr2, dcr, sr2, srf, ico, icon,jpeg, erf E.g.: <CHANGE_FORMAT_TO>png</CHANGE_FORMAT_TO> -->\n\n";

	private final String OPEN_FOR_RESIZE_HEIGHT_LESS = "\n<PARAMETER_FOR_RESIZING_HEIGHT_LESS>";
	private final String CLOSE_FOR_RESIZE_HEIGHT_LESS = "</PARAMETER_FOR_RESIZING_HEIGHT_LESS>";

	private final String OPEN_FOR_RESIZE_HEIGHT_BETWEEN = "\n<PARAMETER_FOR_RESIZING_HEIGHT_BETWEEN>";
	private final String CLOSE_FOR_RESIZE_HEIGHT_BETWEEN = "</PARAMETER_FOR_RESIZING_HEIGHT_BETWEEN>";

	private final String OPEN_FOR_RESIZE_HEIGHT_MORE = "\n<PARAMETER_FOR_RESIZING_HEIGHT_MORE>";
	private final String CLOSE_FOR_RESIZE_HEIGHT_MORE = "</PARAMETER_FOR_RESIZING_HEIGHT_MORE>";

	private final String OPEN_FOR_RESIZE_WIDTH_LESS = "\n<PARAMETER_FOR_RESIZING_WIDTH_LESS>";
	private final String CLOSE_FOR_RESIZE_WIDTH_LESS = "</PARAMETER_FOR_RESIZING_WIDTH_LESS>";

	private final String OPEN_FOR_RESIZE_WIDTH_BETWEEN = "\n<PARAMETER_FOR_RESIZING_WIDTH_BETWEEN>";
	private final String CLOSE_FOR_RESIZE_WIDTH_BETWEEN = "</PARAMETER_FOR_RESIZING_WIDTH_BETWEEN>";

	private final String OPEN_FOR_RESIZE_WIDTH_MORE = "\n<PARAMETER_FOR_RESIZING_WIDTH_MORE>";
	private final String CLOSE_FOR_RESIZE_WIDTH_MORE = "</PARAMETER_FOR_RESIZING_WIDTH_MORE>";

	private final String OPEN_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS = "\n<SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS";
	private final String CLOSE_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS = "</SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS><!--\nHeight! If less or more and height should be: e.g. x540 If between and\nheight should be: e.g. x360,540-->";

	private final String OPEN_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN = "\n<SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN";
	private final String CLOSE_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN = "</SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN>";

	private final String OPEN_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE = "\n<SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE";
	private final String CLOSE_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE = "</SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE>";

	private final String OPEN_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS = "\n<SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS";
	private final String CLOSE_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS = "</SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS><!--\n Width! If less or more and width should be: e.g. 540 or 540x If between\nand width should de: e.g. 360,540 or 360,540x -->";

	private final String OPEN_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN = "\n<SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN";
	private final String CLOSE_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN = "</SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN>";

	private final String OPEN_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE = "\n<SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE";
	private final String CLOSE_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE = "</SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE>";

	private final String OPEN_CHANGE_SIZE = "\n<CHANGE_SIZE>";
	private final String CLOSE_CHANGE_SIZE = "</CHANGE_SIZE><!-- If this field exists than image size of\nwidth or height would be changed for this value. E.g.: for width\n<CH..TO>500x</CH..TO> or <CH..TO>500</CH..TO> or for height\n<CH..TO>x500</CH..TO> Could be both: <CH..TO>500x1000</CH..TO> Could be\nin percentage: E.g.: <CH..TO>50%</CH..TO> You will get the image changed \nby a given percentage \n(Should be from 1 to 100).-->";

	private final String OPEN_CHANGE_SIZE_OF_WIDTH_FOR_LESS = "\n<CHANGE_SIZE_OF_WIDTH_FOR_LESS";
	private final String CLOSE_CHANGE_SIZE_OF_WIDTH_FOR_LESS = "</CHANGE_SIZE_OF_WIDTH_FOR_LESS>";

	private final String OPEN_CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN = "\n<CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN";
	private final String CLOSE_CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN = "</CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN>";

	private final String OPEN_CHANGE_SIZE_OF_WIDTH_FOR_MORE = "\n<CHANGE_SIZE_OF_WIDTH_FOR_MORE";
	private final String CLOSE_CHANGE_SIZE_OF_WIDTH_FOR_MORE = "</CHANGE_SIZE_OF_WIDTH_FOR_MORE>";

	private final String OPEN_CHANGE_SIZE_OF_HEIGHT_FOR_LESS = "\n<CHANGE_SIZE_OF_HEIGHT_FOR_LESS";
	private final String CLOSE_CHANGE_SIZE_OF_HEIGHT_FOR_LESS = "</CHANGE_SIZE_OF_HEIGHT_FOR_LESS>";

	private final String OPEN_CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN = "\n<CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN";
	private final String CLOSE_CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN = "</CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN>";

	private final String OPEN_CHANGE_SIZE_OF_HEIGHT_FOR_MORE = "\n<CHANGE_SIZE_OF_HEIGHT_FOR_MORE";
	private final String CLOSE_CHANGE_SIZE_OF_HEIGHT_FOR_MORE = "</CHANGE_SIZE_OF_HEIGHT_FOR_MORE>";

	private final String OPEN_CHANGE_RESOLUTION = "\n<CHANGE_RESOLUTION_TO>";
	private final String CLOSE_CHANGE_RESOLUTION = "</CHANGE_RESOLUTION_TO><!-- If this field exists\nthan image resolution would be changed for this. RESTRICTION: Numbers\n should be more than 0. E.g.:\n<CHANGE_RESOLUTION_TO>1080</CHANGE_RESOLUTION_TO> -->";

	private final String OPEN_CREATE_THUMBNAIL = "\n<CREATE_THUMBNAIL_WITH_PARAMS>";
	private final String CLOSE_CREATE_THUMBNAIL = "</CREATE_THUMBNAIL_WITH_PARAMS><!-- If this\nfield exists than app would create a thumbnail from the original image\nwith parametrs in this field. RESTRICTION: NO more than 256x256. If #x*\n(#=0 or *=0 or both) no thumbnail would be created. There are only ONE\nway to fill in this field:\nE.g.: <CR..AMS>150x150</CR..AMS>. If you would fill in this field with\nsuch way as the size field than you get the thumbnail with the smaller\nnumber and by both sides.-->";

	private final String OPEN_COLOR = "\n<CHANGE_COLOR_MODEL>";
	private final String CLOSE_COLOR = "</CHANGE_COLOR_MODEL><!-- If this field exists\nand it contains one of values than color mode of original image would be\nchanged. RESTRICTION: This field can have only four values:\nsRGB,RGB,CMYK,CMY. If any other value would be here no changes would be\ndone. -->";

	private final String OPEN_MONO = "\n<CHANGE_TO_MONO>";
	private final String CLOSE_MONO = "</CHANGE_TO_MONO><!-- If this field exists, it contains\nthe true value and the original image is in colour than image would be\nchanged for mono type. RESTRICTION: This field can have only two values:\n0 or 1. If any other value would be here no changes would be done. -->";

	private final String OPEN_FLAT = "\n<FLATTENING_IMAGE>";
	private final String CLOSE_FLAT = "</FLATTENING_IMAGE><!-- If this field exists and it\ncontaints the true value than image would be flattened. RESTRICTION: This\nfield can have only two values: 0 or 1. If any other value would be here\nno changes would be done. -->";

	private final String OPEN_COMPRESSION = "\n<QUALITY_COMPRESSION_FOR_JPEG_IMAGES>";
	private final String CLOSE_COMPRESSION = "</QUALITY_COMPRESSION_FOR_JPEG_IMAGES><!--\nIf this field exists and it containts the value and image has a jpg,jpeg\nor tif,tiff extensions than image would be compressed. RESTRICTION: This\nfield can have only values from 1 to 100. If any other value would be\nhere no changes would be done. -->";

	private final String END = "\n</IMAGES_FOR_EDIT>";

	private String toReturn = "";

	public StringXml(ImageParametrs data) {

		init(data);
	}

	private void init(ImageParametrs a) {

		toReturn += HEADER;

		if (!a.newName.equals("")) {
			toReturn += OPEN_RENAME + a.getNewName() + CLOSE_RENAME;
		}

		toReturn += OPEN_FORMAT + a.getFormat() + CLOSE_FORMAT;

		if (!a.isSizeIsManual()) {

			// height is need to resize
			toReturn += OPEN_FOR_RESIZE_HEIGHT_LESS + a.isLessHeightChar()
					+ CLOSE_FOR_RESIZE_HEIGHT_LESS;

			toReturn += OPEN_FOR_RESIZE_HEIGHT_BETWEEN
					+ a.isBetweenHeightChar() + CLOSE_FOR_RESIZE_HEIGHT_BETWEEN;

			toReturn += OPEN_FOR_RESIZE_HEIGHT_MORE + a.isMoreHeightChar()
					+ CLOSE_FOR_RESIZE_HEIGHT_MORE;

			// width is need to resize

			toReturn += OPEN_FOR_RESIZE_WIDTH_LESS + a.isLessWidthChar()
					+ CLOSE_FOR_RESIZE_WIDTH_LESS;

			toReturn += OPEN_FOR_RESIZE_WIDTH_BETWEEN + a.isBetweenWidthChar()
					+ CLOSE_FOR_RESIZE_WIDTH_BETWEEN;

			toReturn += OPEN_FOR_RESIZE_WIDTH_MORE + a.isMoreWidthChar()
					+ CLOSE_FOR_RESIZE_WIDTH_MORE;

			// for what we check height
			if (a.isBetweenHeight()) {
				if (!a.getBetweenFirstCompareHeight().equals("")
						&& !a.getBetweenSecondCompareHeight().equals("")) {

					toReturn += OPEN_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN
							+ " type = \"" + a.getTypeOfBetweenHeightToCheck()
							+ "\">" + 'x' + a.getBetweenFirstCompareHeight()
							+ ',' + a.getBetweenSecondCompareHeight()
							+ CLOSE_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN;

					// change to
					toReturn += OPEN_CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN
							+ " type = \"" + a.getTypeOfBetweenHeightToChange()
							+ "\">" + 'x' + a.getBetweenResizeHeight()
							+ CLOSE_CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN;
				}
			}
			if (a.isLessHeight()) {

				if (!a.getLessCompareHeight().equals("")) {
					toReturn += OPEN_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS
							+ " type = \"" + a.getTypeOfLessHeightToCheck()
							+ "\">" + 'x' + a.getLessCompareHeight()
							+ CLOSE_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS;

					toReturn += OPEN_CHANGE_SIZE_OF_HEIGHT_FOR_LESS
							+ " type = \"" + a.getTypeOfLessHeightToChange()
							+ "\">" + 'x' + a.getLessResizeToHeight()
							+ CLOSE_CHANGE_SIZE_OF_HEIGHT_FOR_LESS;
				}
			}
			if (a.isMoreHeight()) {

				if (!a.getMoreComparedHeight().equals("")) {

					toReturn += OPEN_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE
							+ " type = \"" + a.getTypeOfMoreHeightToCheck()
							+ "\">" + 'x' + a.getMoreComparedHeight()
							+ CLOSE_SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE;

					toReturn += OPEN_CHANGE_SIZE_OF_HEIGHT_FOR_MORE
							+ " type = \"" + a.getTypeOfMoreHeightToChange()
							+ "\">" + 'x' + a.getMoreResizeHeight()
							+ CLOSE_CHANGE_SIZE_OF_HEIGHT_FOR_MORE;
				}
			}

			// the same story with width

			if (a.isBetweenWidth()) {
				if (!a.getBetweenFirstCompareWidth().equals("")
						&& !a.getBetweenSecondCompareWidth().equals("")) {
					toReturn += OPEN_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN
							+ " type = \"" + a.getTypeOfBetweenWidthToCheck()
							+ "\">" + a.getBetweenFirstCompareWidth() + ','
							+ a.getBetweenSecondCompareWidth() + 'x'
							+ CLOSE_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN;

					toReturn += OPEN_CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN
							+ " type = \"" + a.getTypeOfBetweenWidthToChange()
							+ "\">" + a.getBetweenResizeWidth()
							+ CLOSE_CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN;
				}
			}

			if (a.isLessWidth()) {
				if (!a.getLessCompareWidth().equals("")) {
					toReturn += OPEN_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS
							+ " type = \"" + a.getTypeOfLessWidthToCheck()
							+ "\">" + a.getLessCompareWidth()
							+ CLOSE_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS;

					toReturn += OPEN_CHANGE_SIZE_OF_WIDTH_FOR_LESS
							+ " type = \"" + a.getTypeOfLessWidthToChange()
							+ "\">" + a.getLessResizeToWidth()
							+ CLOSE_CHANGE_SIZE_OF_WIDTH_FOR_LESS;
				}
			}
			if (a.isMoreWidth()) {
				if (!a.getMoreComparedWidth().equals("")) {
					toReturn += OPEN_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE
							+ " type = \"" + a.getTypeOfMoreWidthToCheck()
							+ "\">" + a.getMoreComparedWidth()
							+ CLOSE_SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE;

					toReturn += OPEN_CHANGE_SIZE_OF_WIDTH_FOR_MORE
							+ " type = \"" + a.getTypeOfMoreWidthToChange()
							+ "\">" + a.getMoreResizeWidth()
							+ CLOSE_CHANGE_SIZE_OF_WIDTH_FOR_MORE;
				}
			}

		}// if we chose on our own
		else {
			if (a.isPerCent()) {
				if (a.getResizePercentage().equals("")) {
					toReturn += OPEN_CHANGE_SIZE + CLOSE_CHANGE_SIZE;
				} else {
					toReturn += OPEN_CHANGE_SIZE + a.getResizePercentage()
							+ '%' + CLOSE_CHANGE_SIZE;
				}
			} else {// if pixels
				if (a.getSizeHeight().equals("") && a.getSizeWidth().equals("")) {
					toReturn += OPEN_CHANGE_SIZE + CLOSE_CHANGE_SIZE;
				} else {
					toReturn += OPEN_CHANGE_SIZE + a.getSizeWidth() + 'x'
							+ a.getSizeHeight() + CLOSE_CHANGE_SIZE;
				}
			}
		}// end ELSE
			//

		toReturn += OPEN_CHANGE_RESOLUTION + a.getResolutionDPI()
				+ CLOSE_CHANGE_RESOLUTION;

		if (a.getThumbnailHeight().equals("")
				&& a.getThumbnailWidth().equals("")) {
			// do nothing
		} else if (a.getThumbnailHeight().equals("")) {// without height
			toReturn += OPEN_CREATE_THUMBNAIL + a.getThumbnailWidth()
					+ CLOSE_CREATE_THUMBNAIL;
		} else if (a.getThumbnailWidth().equals("")) {
			toReturn += OPEN_CREATE_THUMBNAIL + 'x' + a.getThumbnailHeight()
					+ CLOSE_CREATE_THUMBNAIL;
		} else {
			toReturn += OPEN_CREATE_THUMBNAIL + a.getThumbnailWidth() + 'x'
					+ a.getThumbnailHeight() + CLOSE_CREATE_THUMBNAIL;
		}

		if (!a.isChangeToMono())
			toReturn += OPEN_COLOR + a.getChangeColorModel() + CLOSE_COLOR;

		toReturn += OPEN_MONO + a.isChangeToMonoChar() + CLOSE_MONO;

		toReturn += OPEN_FLAT + a.isFlatteningImageChar() + CLOSE_FLAT;

		toReturn += OPEN_COMPRESSION + a.getQualityCompressionForJPEGImages()
				+ CLOSE_COMPRESSION;

		toReturn += END;

	}// END INIT

	public String toString() {
		return toReturn;
	}

	public String getXmlString() {
		return toReturn;
	}
}
