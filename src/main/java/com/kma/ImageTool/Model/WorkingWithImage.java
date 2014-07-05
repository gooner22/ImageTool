package com.kma.ImageTool.Model;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import com.kma.ImageTool.Error.InvalidImageFileNameException;
import com.kma.ImageTool.Model.naming.FileNamingConvention;
import org.im4java.core.*;
import org.im4java.process.ProcessStarter;

public class WorkingWithImage {

    public static final String THUMBNAILS_FOLDER = "thumbnails" + File.separator;
    private ImageParameterFetch imageParameters;
	private String pathToFolder;
	private String pathToIMLibrary;
	private String pathToEditedFolder;
	private File directory;

	public WorkingWithImage(ImageParameterFetch im) {

		imageParameters = im;
		pathToFolder = "";
		pathToIMLibrary = "";
		pathToEditedFolder = "";
	}

	public boolean run(Set<String> images, String pathToLib, String pathToFolder) throws InvalidImageFileNameException {
		// set path to folders that we will use
		this.pathToFolder = pathToFolder;
		this.pathToIMLibrary = pathToLib;

		directory = new File(pathToFolder, "");

		if (images.size() > 0) {

			String zeroesBefore = zeroesString(numbersOfNumber(images.size()));
			int iterator = 1;
			// start editng photos
			for (String imagePath : images) {
				// check whether we nweed to remove one zero

				if (iterator % 10 == 0 ) {
					zeroesBefore = reomveOneZero(zeroesBefore);

				}

				ConvertCmd cmd = new ConvertCmd();
				IMOperation op = new IMOperation();

				String mrjVersion = System.getProperty("mrj.version");
				boolean isMacOs = mrjVersion != null;
				if (isMacOs) {
					ProcessStarter.setGlobalSearchPath(pathToIMLibrary
							+ "/bin:" + pathToIMLibrary + "/lib");
				} else {
					String imPath = pathToIMLibrary;
					cmd.setSearchPath(imPath);
				}
				op.addImage(imagePath);

				ConvertCmd cmdForThumbnail = null;
				IMOperation opForThumbnail = null;

				if ((imageParameters.getThumbnailWidth() > 0 && imageParameters
						.getThumbnailWidth() <= 256)
						|| (imageParameters.getThumbnailHeight() > 0 && imageParameters
								.getThumbnailHeight() <= 256)) {

					cmdForThumbnail = new ConvertCmd();
					opForThumbnail = new IMOperation();

					if (isMacOs) {
						ProcessStarter.setGlobalSearchPath(pathToIMLibrary
								+ "/bin:" + pathToIMLibrary + "/lib");
					} else {
						String imPath = pathToIMLibrary;

						if (cmdForThumbnail != null && opForThumbnail != null)
							cmdForThumbnail.setSearchPath(imPath);
					}
					if (cmdForThumbnail != null && opForThumbnail != null)
						opForThumbnail.addImage(imagePath);
				}// and thumbnail operation

				// Image format
				String format = imageParameters.getFormat();
				format = format.toLowerCase();

				if (format.equals("ico") || format.equals("icon")) {
					op.adaptiveResize(256, 256, '!');
				}

				Info info;
				int widthOfTheImageInPx = 0;
				int heightOfTheImageInPx = 0;
				int resolution = 0;
				String nameOfImage = "";
				String nameOfThumbnailImage = "";

				try {
					info = new Info(imagePath);

					String formatOfImage = info
							.getImageFormat()
							.substring(0,
									info.getImageFormat().indexOf('(') - 1)
							.toLowerCase().replaceAll("\\s", "");

					if (formatOfImage.equals("jpeg")) {
						formatOfImage = "jpg";
					}

					if (imageParameters.getNewName().equals("")) {
						String original = imagePath.substring(directory
								.getAbsolutePath().length() + 1, imagePath
								.length());
                        original = original.substring(0,
                                original.indexOf(formatOfImage) - 1);
						System.out.println("Original image: " + original);

                        nameOfImage = FileNamingConvention.getOutputFileName(original);
						System.out.println("Name of image: " + nameOfImage);

                        nameOfThumbnailImage = FileNamingConvention.getOutputThumbnailFileName(original);
                        System.out.println("Name of th image: " + nameOfImage);
					}

					if (format.equals("none")) {
						format = formatOfImage;
					}

					heightOfTheImageInPx = info.getImageHeight();
					widthOfTheImageInPx = info.getImageWidth();

					// if we have resolution in image
					if (info.getProperty("Resolution") != null) {

						resolution = (int) Double.parseDouble(info.getProperty(
								"Resolution").substring(0,
								info.getProperty("Resolution").indexOf("x")));

						if (resolution == 0
								&& imageParameters.getResolutionDPI() == 0) {
							resolution = 72;
						} else if (resolution == 0
								&& imageParameters.getResolutionDPI() > 0) {

							resolution = imageParameters.getResolutionDPI();

						}
					} else {// default value
						System.out.println("Why ELSE");
						resolution = 72;
					}

				} catch (InfoException e2) {
					return false;
				}

				// Changing resolution
				op.units("PixelsPerInch");
				if (imageParameters.getResolutionDPI() > 0) {

					resolution = imageParameters.getResolutionDPI();
					// resample do not change real size of image
					op.resample(resolution);

					if (cmdForThumbnail != null && opForThumbnail != null) {
						opForThumbnail.density(resolution);
					}
				}

				// Resizing with H & W
				// HEIGHT LESS
				// ////////////// EXTENEDE PANEL RESIZING
				// //////////////////////////////////
				// Lets start with widht
				// temporary to use
				/**
				 * temporary use instead of imageParameters - to long
				 */
				ImageParameterFetch _im = imageParameters;

				// if check box less in width

				if (_im.isParameterForResizeOfWidthIfLess()) {
					// if width in pixels

					int newWidth = _im.getSizeWidthIfLess();
					int newHeight = heightOfTheImageInPx;
					int oldWidth = widthOfTheImageInPx;
					int toCheck = _im.getSizeWidthToCheckIfLess();

					// if we have compare pt transform it to px and do it right
					// in px
					if (_im.getTypeOfLessWidthToChange().equals("pt")) {
						newWidth = toPx(newWidth, resolution);
					}
					// what if pt tranform pt to pixels
					if (_im.getTypeOfLessWidthToCheck().equals("pt")) {

						toCheck = toPx(toCheck, resolution);
					}

					if (oldWidth < toCheck) {

						newHeight = getRatioSize(widthOfTheImageInPx, newWidth,
								newHeight);

						// op.adaptiveResize(newWidth, newHeight);
						op.resize(newWidth, newHeight);

					}

				}// end width less

				// more
				if (_im.isParameterForResizeOfWidthIfMore()) {
					// if width in pixels

					int newWidth = _im.getSizeWidthIfMore();
					int newHeight = heightOfTheImageInPx;
					int oldWidth = widthOfTheImageInPx;
					int toCheck = _im.getSizeWidthToCheckIfMore();

					// what if pt tranform pt to pixels
					if (_im.getTypeOfMoreWidthToChange().equals("pt")) {

						newWidth = toPx(newWidth, resolution);
					}

					if (_im.getTypeOfMoreWidthToCheck().equals("pt")) {

						toCheck = toPx(toCheck, resolution);

					}
					// if more
					if (oldWidth > toCheck) {

						newHeight = getRatioSize(widthOfTheImageInPx, newWidth,
								newHeight);

						op.adaptiveResize(newWidth, newHeight);

					}

				}// end width more
					// between
				if (_im.isParameterForResizeOfWidthIfBetween()) {

					int newWidth = _im.getSizeWidthIfBetween();
					int newHeight = heightOfTheImageInPx;

					int toCheck = _im.getSizeWidthToCheckIfBetweenFirst();
					int toCheck_1 = _im.getSizeWidthToCheckIfBetweenSecond();

					if (_im.getTypeOfBetweenWidthToCheck().equals("pt")) {
						toCheck = toPx(toCheck, resolution);
						toCheck_1 = toPx(toCheck_1, resolution);
					}

					// what if pt tranform pt to pixels
					if (_im.getTypeOfBetweenWidthToCheck().equals("pt")) {

						newWidth = toPx(newWidth, resolution);

					}

					if (toCheck < widthOfTheImageInPx
							&& widthOfTheImageInPx < toCheck_1) {

						newHeight = getRatioSize(widthOfTheImageInPx, newWidth,
								newHeight);

						op.adaptiveResize(newWidth, newHeight);

					}
				}// end width between

				// HEIGHT PART

				// less
				if (_im.isParameterForResizeOfHeightIfLess()) {
					// if width in pixels

					int newHeight = _im.getSizeHeightIfLess();
					int newWidth = widthOfTheImageInPx;
					int oldHeight = heightOfTheImageInPx;
					int toCheck = _im.getSizeHeightToCheckIfLess();

					// what if pt tranform pt to pixels
					if (_im.getTypeOfLessHeightToChange().equals("pt")) {
						newWidth = toPx(newHeight, resolution);
					}

					if (_im.getTypeOfLessHeightToCheck().equals("pt")) {
						toCheck = toPx(toCheck, resolution);

					}

					if (oldHeight < toCheck) {

						newWidth = getRatioSize(heightOfTheImageInPx,
								newHeight, newWidth);

						op.adaptiveResize(newWidth, newHeight);

					}

				}// end width less

				// more
				if (_im.isParameterForResizeOfHeightIfMore()) {
					// if width in pixels

					int newHeight = _im.getSizeHeightIfMore();
					int newWidth = widthOfTheImageInPx;
					int oldHeight = heightOfTheImageInPx;
					int toCheck = _im.getSizeHeightToCheckIfMore();

					if (_im.getTypeOfMoreHeightToChange().equals("pt")) {
						newHeight = toPx(newHeight, resolution);
					}

					// what if pt tranform pt to pixels
					if (_im.getTypeOfMoreHeightToCheck().equals("pt")) {
						toCheck = toPx(toCheck, resolution);

					}

					if (oldHeight > toCheck) {

						newWidth = getRatioSize(heightOfTheImageInPx,
								newHeight, newWidth);

						op.adaptiveResize(newWidth, newHeight);

					}

				}// end width more
					// between
				if (_im.isParameterForResizeOfHeightIfBetween()) {

					int newHeight = _im.getSizeHeightIfBetween();
					int newWidth = widthOfTheImageInPx;

					int toCheck = _im.getSizeHeightToCheckIfBetweenFirst();
					int toCheck_1 = _im.getSizeHeightToCheckIfBetweenSecond();

					if (_im.getTypeOfBetweenHeightToChange().equals("pt")) {
						// new width in pixels
						newHeight = toPx(newHeight, resolution);
					}

					// what if pt tranform pt to pixels
					if (_im.getTypeOfBetweenHeightToCheck().equals("pt")) {

						toCheck = toPx(toCheck, resolution);
						toCheck_1 = toPx(toCheck_1, resolution);

					}

					if (toCheck < heightOfTheImageInPx
							&& heightOfTheImageInPx < toCheck_1) {

						newWidth = getRatioSize(heightOfTheImageInPx,
								newHeight, newWidth);
						// resize

						op.adaptiveResize(newWidth, newHeight);

					}
				}// end width between

				// //////////////////////////////////////
				// changing manually width and height

				// only width
				// height will set automatically rational
				// all correct height field become width
				if (imageParameters.getSizeHeight() > 0) {

					int newWidth = imageParameters.getSizeHeight();
					int newHeight = heightOfTheImageInPx;
					newHeight = getRatioSize(widthOfTheImageInPx, newWidth,
							newHeight);

					// op.adaptiveResize(newWidth, newHeight);
					// let

					op.resample(300);
					op.resize(newWidth, newHeight);

				}

				// Changing size in %
				if (imageParameters.getResizePercentage() > 0) {
					op.adaptiveResize(imageParameters.getResizePercentage(),
							null, '%');
				}

				// Changing color model
				if ((imageParameters.getChangeColorModel().equals("CMYK")
						|| imageParameters.getChangeColorModel().equals("RGB")
						|| imageParameters.getChangeColorModel().equals("CMY") || imageParameters
						.getChangeColorModel().equals("sRGB"))
						&& !imageParameters.getChangeColorModel().equals(null)) {
					op.colorspace(imageParameters.getChangeColorModel());
				}

				// Creating monochrome image
				if (imageParameters.isChangeToMono()) {
					op.colorspace("Gray");
					if (cmdForThumbnail != null && opForThumbnail != null) {
						opForThumbnail.colorspace("Gray");
					}
				}

				if (imageParameters.getQualityCompressionForJPEGImages() > 0
						&& (imageParameters.getFormat().equals("jpg")
								|| imageParameters.getFormat().equals("jpeg")
								|| imageParameters.getFormat().equals("tif") || imageParameters
								.getFormat().equals("tiff"))) {
					op.quality(imageParameters
							.getQualityCompressionForJPEGImages());
				}

				// Making image flat
				if (imageParameters.isFlatteningImage()) {
					op.flatten();
					if (cmdForThumbnail != null && opForThumbnail != null) {
						opForThumbnail.flatten();
					}

				}

				if (cmdForThumbnail != null && opForThumbnail != null) {

					// Creating thumbnails
					if (imageParameters.getThumbnailWidth() > 0
							&& imageParameters.getThumbnailWidth() > 0
							&& imageParameters.getThumbnailHeight() <= 256
							&& imageParameters.getThumbnailWidth() <= 256) {
						opForThumbnail.thumbnail(
								imageParameters.getThumbnailHeight(),
								imageParameters.getThumbnailHeight(), '!');
					} else if (imageParameters.getThumbnailWidth() > 0
							&& imageParameters.getThumbnailWidth() <= 256) {
						opForThumbnail.thumbnail(
								imageParameters.getThumbnailWidth(), null);
					} else if (imageParameters.getThumbnailHeight() > 0
							&& imageParameters.getThumbnailHeight() <= 256) {
						opForThumbnail.thumbnail(null,
								imageParameters.getThumbnailHeight());
					}

					// create folder to hold images
					// if folder does not exist
					// create a new one
					if (!checkForFolder()) {
						createDirectory();
					}

					if (checkForFolder()) {
						if (cmdForThumbnail != null && opForThumbnail != null) {
							if (imageParameters.getNewName().equals("")) {
                                // thumbnails should be in separate folder
								opForThumbnail.addImage(pathToEditedFolder
                                        + File.separator + THUMBNAILS_FOLDER + nameOfThumbnailImage + "."
                                        + format);
							} else {
								// check for iterator value and change zeroes

								opForThumbnail.addImage(pathToEditedFolder
										+ File.separator + THUMBNAILS_FOLDER + imageParameters.getNewName()
										+ "_th_" + zeroesBefore + iterator + "."
										+ format);
							}
						}
					} else {
                        System.out.println("path to output folder doesn't exist");
                        return false;
					}

					try {
						if (cmdForThumbnail != null && opForThumbnail != null) {
							cmdForThumbnail.run(opForThumbnail);
						}
					} catch (IOException e) {
						System.out.println("cmd.run(op) error: " + e);
						return false;
					} catch (InterruptedException e) {
						System.out.println("cmd.run(op) error: " + e);
						return false;
					} catch (IM4JavaException e) {
						System.out.println("cmd.run(op) error: " + e);
						return false;
					}
				}

				if (!checkForFolder()) {
					createDirectory();
				}

				if (checkForFolder()) {
					if (imageParameters.getNewName().equals("")) {
						op.addImage(pathToEditedFolder + File.separator + nameOfImage
								+ "." + format);
					} else {
						op.addImage(pathToEditedFolder + File.separator
								+ imageParameters.getNewName() + zeroesBefore
								+ iterator + "." + format);
					}
				} else {

					return false;
				}
				iterator++;

				// running commands
				try {
					cmd.run(op);
				} catch (IOException e) {
					System.out.println("cmd.run(op) error: " + e);
					return false;
				} catch (InterruptedException e) {
					return false;
				} catch (IM4JavaException e) {
					System.out.println("cmd.run(op) error: " + e);
					return false;
				}
			}
		} else {
			System.out.println("No images found!");
			return false;
		}
		this.pathToFolder = "";
		return true;

	}// END RUN

	private String reomveOneZero(String zeroesBefore) {
		StringBuilder sb = new StringBuilder(zeroesBefore);
		sb.deleteCharAt(zeroesBefore.length() - 1);
		return sb.toString();
	}

	/**
	 * calculate size which we need when we click ratioASpect
	 * 
	 * @param numerator1
	 *            - real size (height or width)
	 * @param denominator1
	 *            - size to resize
	 * @param numerator2
	 *            - real size (width or height)
	 * @return denominator2 - value to resize depends on resizing parametrs
	 */
	private int getRatioSize(int numerator1, int denominator1, int numerator2) {

		return (denominator1 * numerator2) / numerator1;
	}

	/**
	 * convert to from px to point
	 * 
	 * @param pixel
	 *            real pixel
	 * @param resolution
	 *            resolution to convert
	 * @return point depends on resolution
	 */
	private int toPt(int pixel, int resolution) {
		int theirDefault = 72;
		return pixel * theirDefault / resolution;
	}

	private int toPx(int pt, int resolution) {
		int theirDefault = 72;
		return resolution * pt / theirDefault;
	}

	/**
	 * will create new Edit Images folder
	 */
	private void createDirectory() {

		for (int i = 0;; i++) {
            final File outputDir = new File(directory.getPath()
                    + "/Edited Images-" + i);
            boolean successForNonDefaultDir = outputDir.mkdir();
			if (successForNonDefaultDir) {
				// set path to folder with edited images
                pathToEditedFolder = outputDir.getAbsolutePath();
				System.out.println("Create folder: " + pathToEditedFolder);
                // create thumbnails folder
                createThumbnailsDirectory(outputDir);
				return;
			}else {
                System.out.println("Couldn't create output folder: " + outputDir.getAbsolutePath());
            }
		}
	}

    private void createThumbnailsDirectory(File outputDir) {
        final File thumbnailsFile = new File(outputDir.getAbsolutePath() + File.separator + THUMBNAILS_FOLDER);
        if(thumbnailsFile.mkdir()){
            System.out.println("Create folder: " + thumbnailsFile.getAbsolutePath());
        }else {
            System.out.println("Couldn't create folder for thumbnails: " + thumbnailsFile.getAbsolutePath());
        }
    }

    public boolean checkForFolder() {
		if (new File(pathToEditedFolder).exists()) {
			System.out.println("TRUE checkForFolder");
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param i
	 *            number of images
	 * @return how many 0 should be at the first time when program start
	 */
	private int numbersOfNumber(int i) {
		int index = 0;

		while ((i / 10) > 0) {
			i = i / 10;
			++index;
		}

		return index;
	}

	/**
	 * Make string with "0" depends on @param num
	 * 
	 */
	private String zeroesString(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; ++i) {
			sb.append("0");
		}
		return sb.toString();
	}

}
