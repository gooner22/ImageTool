package com.kma.ImageTool.Model;

import com.kma.ImageTool.DTO.ImageParametrs;
import com.kma.ImageTool.DataStrategy.XmlKeys;
import com.kma.ImageTool.Log.LoggerUtils;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.logging.Level;

/**
 * Class that fetching parameters from XML File old one that is why don't use
 * {@link ImageParametrs} sorry, but one thousand line - depends :)
 * 
 * @author yaroslav
 * 
 */
public class ParseXML {

	private boolean haveAnError = false;
	private ImageParameterFetch imageWorkingWith = new ImageParameterFetch();

    public ImageParameterFetch parseFile(File xml) {

		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

                private boolean templateName = false;
				private boolean shouldRename = false;
				private boolean renameFormat = false;
				private boolean renameFormatTh = false;
				private boolean changeResolution = false;
				private boolean changeFormat = false;
				private boolean changeSize = false;
				private boolean parameterForChangeSizeOfWidthIfLess = false;
				private boolean parameterForChangeSizeOfWidthIfMore = false;
				private boolean parameterForChangeSizeOfWidthIfBetween = false;
				private boolean parameterForChangeSizeOfHeightIfLess = false;
				private boolean parameterForChangeSizeOfHeightIfMore = false;
				private boolean parameterForChangeSizeOfHeightIfBetween = false;
				private boolean checkForSizeOfWidthIfLess = false;
				private boolean checkForSizeOfWidthIfMore = false;
				private boolean checkForSizeOfWidthIfBetween = false;
				private boolean checkForSizeOfHeightIfLess = false;
				private boolean checkForSizeOfHeightIfMore = false;
				private boolean checkForSizeOfHeightIfBetween = false;
				private boolean changeSizeOfWidthIfLess = false;
				private boolean changeSizeOfWidthIfMore = false;
				private boolean changeSizeOfWidthIfBetween = false;
				private boolean changeSizeOfHeightIfLess = false;
				private boolean changeSizeOfHeightIfMore = false;
				private boolean changeSizeOfHeightIfBetween = false;
				private boolean createThumbnail = false;
				private boolean changeColorModel = false;
				private boolean changeForMono = false;
				private boolean flatteningImage = false;
				private boolean qualityCompressionForJPEGImages = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {


                    if (qName.equalsIgnoreCase(XmlKeys.TEMPLATE_NAME)) {
                        templateName = true;
                    }

					if (!qName.equalsIgnoreCase("IMAGES_TO_EDIT")) {
					}

					if (qName.equalsIgnoreCase(XmlKeys.RENAME_IMAGE_FORMAT)) {
                        renameFormat = true;
					}

                    if (qName.equalsIgnoreCase(XmlKeys.RENAME_IMAGE)) {
                        shouldRename = true;
                    }
                    if (qName.equalsIgnoreCase(XmlKeys.RENAME_IMAGE_TH_FORMAT)) {
                        renameFormatTh = true;
                    }


					if (qName.equalsIgnoreCase("CHANGE_RESOLUTION_TO")) {
						changeResolution = true;
					}

					if (qName.equalsIgnoreCase("CHANGE_FORMAT_TO")) {
						changeFormat = true;
					}

					if (qName
							.equalsIgnoreCase("PARAMETER_FOR_RESIZING_HEIGHT_LESS")) {
						parameterForChangeSizeOfHeightIfLess = true;
					}

					if (qName
							.equalsIgnoreCase("PARAMETER_FOR_RESIZING_HEIGHT_MORE")) {
						parameterForChangeSizeOfHeightIfMore = true;
					}

					if (qName
							.equalsIgnoreCase("PARAMETER_FOR_RESIZING_HEIGHT_BETWEEN")) {
						parameterForChangeSizeOfHeightIfBetween = true;
					}

					if (qName
							.equalsIgnoreCase("PARAMETER_FOR_RESIZING_WIDTH_LESS")) {
						parameterForChangeSizeOfWidthIfLess = true;
					}

					if (qName
							.equalsIgnoreCase("PARAMETER_FOR_RESIZING_WIDTH_MORE")) {
						parameterForChangeSizeOfWidthIfMore = true;
					}

					if (qName
							.equalsIgnoreCase("PARAMETER_FOR_RESIZING_WIDTH_BETWEEN")) {
						parameterForChangeSizeOfWidthIfBetween = true;
					}

					if (qName
							.equalsIgnoreCase("SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_LESS")) {
						checkForSizeOfHeightIfLess = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfLessHeightToCheck(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfLessHeightToCheck("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to check height for less is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_MORE")) {
						checkForSizeOfHeightIfMore = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfMoreHeightToCheck(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfMoreHeightToCheck("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to check height for more is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("SIZE_FOR_WHAT_TO_CHECK_HEIGHT_FOR_BETWEEN")) {
						checkForSizeOfHeightIfBetween = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfBetweenHeightToCheck(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith
									.setTypeOfBetweenHeightToCheck("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to check height for between is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_LESS")) {
						checkForSizeOfWidthIfLess = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfLessWidthToCheck(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfLessWidthToCheck("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to check width for less is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_MORE")) {
						checkForSizeOfWidthIfMore = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfMoreWidthToCheck(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfMoreWidthToCheck("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to check width for more is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("SIZE_FOR_WHAT_TO_CHECK_WIDTH_FOR_BETWEEN")) {
						checkForSizeOfWidthIfBetween = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfBetweenWidthToCheck(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfBetweenWidthToCheck("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to check width for between is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName.equalsIgnoreCase("CHANGE_SIZE_OF_WIDTH_FOR_LESS")) {
						changeSizeOfWidthIfLess = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfLessWidthToChange(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfLessWidthToChange("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to change width for less is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName.equalsIgnoreCase("CHANGE_SIZE_OF_WIDTH_FOR_MORE")) {
						changeSizeOfWidthIfMore = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfMoreWidthToChange(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfMoreWidthToChange("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to change width for more is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("CHANGE_SIZE_OF_WIDTH_FOR_BETWEEN")) {
						changeSizeOfWidthIfBetween = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfBetweenWidthToChange(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith
									.setTypeOfBetweenWidthToChange("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to change width for between is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("CHANGE_SIZE_OF_HEIGHT_FOR_LESS")) {
						changeSizeOfHeightIfLess = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfLessHeightToChange(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfLessHeightToChange("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to change height for less is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("CHANGE_SIZE_OF_HEIGHT_FOR_MORE")) {
						changeSizeOfHeightIfMore = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfMoreHeightToChange(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith.setTypeOfMoreHeightToChange("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to change height for more is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName
							.equalsIgnoreCase("CHANGE_SIZE_OF_HEIGHT_FOR_BETWEEN")) {
						changeSizeOfHeightIfBetween = true;
						if (attributes.getValue("type") != null
								&& (attributes.getValue("type").equals("px") || attributes
										.getValue("type").equals("pt"))) {
							imageWorkingWith
									.setTypeOfBetweenHeightToChange(attributes
											.getValue("type"));
						} else if (attributes.getValue("type") == null) {
							imageWorkingWith
									.setTypeOfBetweenHeightToChange("px");
						} else {
							// writeErrorToFile
							// .writeError("Type of size for what to change height for between is inappropriate or not found. \'px\' will be used instead.");
						}
					}

					if (qName.equalsIgnoreCase("CHANGE_SIZE")) {
						changeSize = true;
					}

					if (qName.equalsIgnoreCase("CREATE_THUMBNAIL_WITH_PARAMS")) {
						createThumbnail = true;
					}

					if (qName.equalsIgnoreCase("CHANGE_COLOR_MODEL")) {
						changeColorModel = true;
					}

					if (qName.equalsIgnoreCase("CHANGE_TO_MONO")) {
						changeForMono = true;
					}

					if (qName.equalsIgnoreCase("FLATTENING_IMAGE")) {
						flatteningImage = true;
					}

					if (qName
							.equalsIgnoreCase("QUALITY_COMPRESSION_FOR_JPEG_IMAGES")) {
						qualityCompressionForJPEGImages = true;
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

                    if (templateName) {
                        String newName = new String(ch, start, length);
                        if (checkForCharInString(newName, length)) {
                            imageWorkingWith.setTemplateName(newName);

                        }
                        templateName = false;
                    }

					if (parameterForChangeSizeOfHeightIfLess) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int responce = Integer.parseInt(parameter);
								if (responce == 1 || Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfHeightIfLess(true);
								} else if (responce == 0
										|| Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfHeightIfLess(false);
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be cheked. There is some misunderstanding in parameter for \"less\" operation for height.");
							}
						}
						parameterForChangeSizeOfHeightIfLess = false;
					}

					if (parameterForChangeSizeOfHeightIfMore) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int responce = Integer.parseInt(parameter);
								if (responce == 1 || Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfHeightIfMore(true);
								} else if (responce == 0
										|| Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfHeightIfMore(false);
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be cheked. There is some misunderstanding in parameter for \"more\" operation for height.");
							}
						}
						parameterForChangeSizeOfHeightIfMore = false;
					}

					if (parameterForChangeSizeOfHeightIfBetween) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int responce = Integer.parseInt(parameter);
								if (responce == 1 || Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfHeightIfBetween(true);
								} else if (responce == 0
										|| Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfHeightIfBetween(false);
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be cheked. There is some misunderstanding in parameter for \"between\" operation for height.");
							}
						}
						parameterForChangeSizeOfHeightIfBetween = false;
					}

					if (parameterForChangeSizeOfWidthIfLess) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int responce = Integer.parseInt(parameter);
								if (responce == 1 || Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfWidthIfLess(true);
								} else if (responce == 0
										|| Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfWidthIfLess(false);
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be cheked. There is some misunderstanding in parameter for \"less\" operation for width.");
							}
						}
						parameterForChangeSizeOfWidthIfLess = false;
					}

					if (parameterForChangeSizeOfWidthIfMore) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int responce = Integer.parseInt(parameter);
								if (responce == 1 || Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfWidthIfMore(true);
								} else if (responce == 0
										|| Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfWidthIfMore(false);
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be cheked. There is some misunderstanding in parameter for \"more\" operation for width.");
							}
						}
						parameterForChangeSizeOfWidthIfMore = false;
					}

					if (parameterForChangeSizeOfWidthIfBetween) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int responce = Integer.parseInt(parameter);
								if (responce == 1 || Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfWidthIfBetween(true);
								} else if (responce == 0
										|| Boolean.valueOf(parameter)) {
									imageWorkingWith
											.setParameterForResizeOfWidthIfBetween(false);
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be cheked. There is some misunderstanding in parameter for \"between\" operation for width.");
							}
						}
						parameterForChangeSizeOfWidthIfBetween = false;
					}

					if (checkForSizeOfHeightIfLess) {
						String parameter = new String(ch, start, length);

						if (checkForCharInString(parameter, length)) {
							if (parameter.indexOf("x") == 0) {
								try {
									int height = Integer
											.parseInt(parameter
													.substring(parameter
															.indexOf("x") + 1));
									if (height > 0) {
										imageWorkingWith
												.setSizeHeightToCheckIfLess(height);
									
									} else {
										// writeErrorToFile
										// .writeError("Size can't be cheked. Height when you are checking for \"less\" is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be cheked. There is no proper height parameter when you are checking for \"less\". Check your .XML file!");
								}
							}
						}
						checkForSizeOfHeightIfLess = false;
					}

					if (checkForSizeOfHeightIfMore) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							if (parameter.indexOf("x") == 0) {
								try {
									int height = Integer
											.parseInt(parameter
													.substring(parameter
															.indexOf("x") + 1));
									if (height > 0) {
										imageWorkingWith
												.setSizeHeightToCheckIfMore(height);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be cheked. Height when you are checking for \"more\" is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be cheked. There is no proper height parameter when you are checking for \"more\". Check your .XML file!");
								}
							}
						}
						checkForSizeOfHeightIfMore = false;
					}

					if (checkForSizeOfHeightIfBetween) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							if (parameter.indexOf("x") == 0) {
								try {
									if (parameter.indexOf(",") != -1) {
										int heightFirst = Integer
												.parseInt(parameter.substring(
														(parameter.indexOf("x") + 1),
														(parameter.indexOf(","))));
										int heightSecond = Integer
												.parseInt(parameter.substring(parameter
														.indexOf(",") + 1));
										if (heightFirst > 0) {
											imageWorkingWith
													.setSizeHeightToCheckIfBetweenFirst(heightFirst);
										
										} else {
											// writeErrorToFile
											// .writeError("Size can't be cheked. First value of height when you are checking for \"between\" is negative number or equals to 0. Check your .XML file!");
										}
										if (heightSecond > 0) {
											imageWorkingWith
													.setSizeHeightToCheckIfBetweenSecond(heightSecond);
										
										} else {
											// writeErrorToFile
											// .writeError("Size can't be cheked. Second value of height when you are checking for \"between\" is negative number or equals to 0. Check your .XML file!");
										}
									} else {
										// writeErrorToFile
										// .writeError("Size can't be cheked. Height values are not properly entered when you are checking for \"between\". Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be cheked. There is no proper height parameter when you are checking for \"between\". Check your .XML file!");
								}
							}
						}
						checkForSizeOfHeightIfBetween = false;
					}

					if (checkForSizeOfWidthIfLess) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int width = 0;
								if (parameter.indexOf("x") == parameter
										.length()) {
									width = Integer.parseInt(parameter
											.substring(0,
													(parameter.indexOf("x"))));
								} else {
									width = Integer.parseInt(parameter);
								}
								if (width > 0) {
									imageWorkingWith
											.setSizeWidthToCheckIfLess(width);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be cheked. Width when you are checking for \"less\" is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be checked. There is no proper width parameter when you are checking for \"less\". Check your .XML file!");
							}
						}
						checkForSizeOfWidthIfLess = false;
					}

					if (checkForSizeOfWidthIfMore) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int width = 0;
								if (parameter.indexOf("x") == parameter
										.length()) {
									width = Integer.parseInt(parameter
											.substring(0,
													(parameter.indexOf("x"))));
								} else {
									width = Integer.parseInt(parameter);
								}
								if (width > 0) {
									imageWorkingWith
											.setSizeWidthToCheckIfMore(width);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be cheked. Width when you are checking for \"more\" is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be checked. There is no proper width parameter when you are checking for \"more\". Check your .XML file!");
							}
						}
						checkForSizeOfWidthIfMore = false;
					}

					if (checkForSizeOfWidthIfBetween) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int widthFirst = 0;
								int widthSecond = 0;
								if (parameter.indexOf(",") != -1) {
									widthFirst = Integer.parseInt(parameter
											.substring(0,
													parameter.indexOf(",")));
									if (parameter.indexOf("x") != -1) {
										widthSecond = Integer
												.parseInt(parameter.substring(
														parameter.indexOf(",") + 1,
														parameter.indexOf("x")));
									} else {
										widthSecond = Integer
												.parseInt(parameter.substring(parameter
														.indexOf(",") + 1));
									}
									if (widthFirst > 0) {
										imageWorkingWith
												.setSizeWidthToCheckIfBetweenFirst(widthFirst);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be cheked. First value of width when you are checking for \"between\" is negative number or equals to 0. Check your .XML file!");
									}
								} else {
									// writeErrorToFile
									// .writeError("Size can't be cheked. Width values are not properly entered when you are checking for \"between\". Check your .XML file!");
								}
								if (widthSecond > 0) {
									imageWorkingWith
											.setSizeWidthToCheckIfBetweenSecond(widthSecond);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be cheked. Second value of width when you are checking for \"between\" is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be checked. There is no proper width parameter when you are checking for \"between\". Check your .XML file!");
							}
						}
						checkForSizeOfWidthIfBetween = false;
					}

					if (changeSizeOfHeightIfLess) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							if (parameter.indexOf("x") == 0) {
								try {
									int height = Integer
											.parseInt(parameter
													.substring(parameter
															.indexOf("x") + 1));
									if (height > 0) {
										imageWorkingWith
												.setSizeHeightIfLess(height);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be changed. Height when you are changing for \"less\" is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be changed. There is no proper height parameter when you are changing for \"less\". Check your .XML file!");
								}
							}
						}

						changeSizeOfHeightIfLess = false;
					}

					if (changeSizeOfHeightIfMore) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							if (parameter.indexOf("x") == 0) {
								try {
									int height = Integer
											.parseInt(parameter
													.substring(parameter
															.indexOf("x") + 1));
									if (height > 0) {
										imageWorkingWith
												.setSizeHeightIfMore(height);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be changed. Height when you are changing for \"more\" is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be changed. There is no proper height parameter when you are changing for \"more\". Check your .XML file!");
								}
							}
						}

						changeSizeOfHeightIfMore = false;
					}

					if (changeSizeOfHeightIfBetween) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							if (parameter.indexOf("x") == 0) {
								try {
									int height = Integer
											.parseInt(parameter
													.substring(parameter
															.indexOf("x") + 1));
									if (height > 0) {
										imageWorkingWith
												.setSizeHeightIfBetween(height);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be changed. Height when you are changing for \"between\" is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be changed. There is no proper height parameter when you are changing for \"between\". Check your .XML file!");
								}
							} else {
								// writeErrorToFile
								// .writeError("Size can't be changed. There is no proper height parameter when you are changing for \"between\". Check your .XML file!");
							}
						}

						changeSizeOfHeightIfBetween = false;
					}

					if (changeSizeOfWidthIfLess) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int width = 0;
								if (parameter.indexOf("x") == parameter
										.length()) {
									width = Integer.parseInt(parameter
											.substring(0,
													parameter.indexOf("x")));
								} else {
									width = Integer.parseInt(parameter
											.substring(0));
								}
								if (width > 0) {
									imageWorkingWith.setSizeWidthIfLess(width);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be changed. Width when you are changing for \"less\" is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be changed. There is no proper width parameter when you are changing for \"less\". Check your .XML file!");
							}
						}

						changeSizeOfWidthIfLess = false;
					}

					if (changeSizeOfWidthIfMore) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int width = 0;
								if (parameter.indexOf("x") == parameter
										.length()) {
									width = Integer.parseInt(parameter
											.substring(0,
													parameter.indexOf("x")));
								} else {
									width = Integer.parseInt(parameter
											.substring(0));
								}
								if (width > 0) {
									imageWorkingWith.setSizeWidthIfMore(width);
								
								} else {
									// writeErrorToFile
									// .writeError("Size can't be changed. Width when you are changing for \"more\" is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be changed. There is no proper width parameter when you are changing for \"more\". Check your .XML file!");
							}
						}

						changeSizeOfWidthIfMore = false;
					}

					if (changeSizeOfWidthIfBetween) {
						String parameter = new String(ch, start, length);
						if (checkForCharInString(parameter, length)) {
							try {
								int width = 0;
								if (parameter.indexOf("x") == parameter
										.length()) {
									width = Integer.parseInt(parameter
											.substring(0,
													parameter.indexOf("x")));
								} else {
									width = Integer.parseInt(parameter
											.substring(0));
								}
								if (width > 0) {
									imageWorkingWith
											.setSizeWidthIfBetween(width);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be changed. Width when you are changing for \"between\" is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be changed. There is no proper width parameter when you are changing for \"between\". Check your .XML file!");
							}
						}

						changeSizeOfWidthIfBetween = false;
					}

					if (changeResolution) {
						String resolution = new String(ch, start, length);
						if (checkForCharInString(resolution, length)) {
							try {
								int dpi = Integer.parseInt(resolution);
								if (dpi > 0) {
									imageWorkingWith.setResolutionDPI(dpi);
								
								} else {
									// writeErrorToFile
									// .writeError("Resolution can't be changed. DPI parameter is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Resolution can't be changed. There is no proper dpi parameter.");
							}
						} else {
							imageWorkingWith.setResolutionDPI(0);
						}
						changeResolution = false;
					}

					if (changeSize) {
						String size = new String(ch, start, length);
						if (size.indexOf("x") != -1) {
							if (size.indexOf("x") == 0) {
								try {
									int height = Integer.parseInt(size
											.substring(size.indexOf("x") + 1));
									if (height > 0) {
										imageWorkingWith.setSizeWidth(0);
										imageWorkingWith.setSizeHeight(height);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be changed. Height is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be changed. There is no proper height parameter for resizing.");
								}
							} else if (size.indexOf("x") != 0
									&& size.indexOf("x") != size.length() - 1) {
								try {
									int width = Integer.parseInt(size
											.substring(0, size.indexOf("x")));
									if (width > 0) {
										try {
											int height = Integer.parseInt(size
													.substring(size
															.indexOf("x") + 1));
											if (height > 0) {
												imageWorkingWith
														.setSizeWidth(width);
												imageWorkingWith
														.setSizeHeight(height);
											
											} else {
												// writeErrorToFile
												// .writeError("Size can't be changed. Height is negative number or equals to 0. Check your .XML file!");
											}
										} catch (NumberFormatException nfe) {
											haveAnError = true;
											// writeErrorToFile
											// .writeError("Size can't be changed. There is no proper height parameter for resizing.");
										}
									} else {
										// writeErrorToFile
										// .writeError("Size can't be changed. Width is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be changed. There is no proper width parameter for resizing.");
								}
							} else if (size.indexOf("x") == size.length() - 1) {
								try {
									int width = Integer.parseInt(size
											.substring(0, size.indexOf("x")));
									if (width > 0) {
										imageWorkingWith.setSizeWidth(width);
										imageWorkingWith.setSizeHeight(0);
										
									} else {
										// writeErrorToFile
										// .writeError("Size can't be changed. Width is negative number or equals to 0. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Size can't be changed. There is no proper width parameter for resizing.");
								}
							}
						} else if (size.indexOf("%") != -1
								&& size.indexOf("%") != 0) {
							try {
								int percentage = Integer.parseInt(size
										.substring(0, size.indexOf("%")));
								if (percentage > 0) {
									imageWorkingWith
											.setResizePercentage(percentage);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be changed. Percentage is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be changed. There is no proper percentage parameter for resizing.");
							}
						} else if (checkForCharInString(size, length)
								&& size.indexOf("x") == -1) {
							try {
								int width = Integer.parseInt(size);
								if (width > 0) {
									imageWorkingWith.setSizeWidth(width);
									imageWorkingWith.setSizeHeight(0);
									
								} else {
									// writeErrorToFile
									// .writeError("Size can't be changed. Width is negative number or equals to 0. Check your .XML file!");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Size can't be changed. There is no proper width parameter for resizing.");
							}
						} else if (!this.checkForCharInString(size, length)) {
							imageWorkingWith.setSizeWidth(0);
							imageWorkingWith.setSizeHeight(0);
						}
						changeSize = false;
					}

					if (changeFormat) {
						String newFormat = new String(ch, start, length);
						if (this.checkForExtension(newFormat)
								&& this.checkForCharInString(newFormat, length)) {
							imageWorkingWith.setFormat(newFormat);
							
						} else if (this.checkForCharInString(newFormat, length)) {
							haveAnError = true;
							// writeErrorToFile
							// .writeError("Format can't be changed, because extension is not filled in right.");
						} else if (!this
								.checkForCharInString(newFormat, length)) {
							imageWorkingWith.setFormat("None");
						}

						changeFormat = false;
					}

					if (createThumbnail) {
						String thumbnail = new String(ch, start, length);
						if (thumbnail.indexOf("x") != -1) {
							if (thumbnail.indexOf("x") == 0) {
								try {
									int height = Integer
											.parseInt(thumbnail
													.substring(thumbnail
															.indexOf("x") + 1));
									if (height > 0 && height <= 256) {
										imageWorkingWith.setThumbnailWidth(0);
										imageWorkingWith
												.setThumbnailHeight(height);
										
									} else {
										// writeErrorToFile
										// .writeError("Thumbnail can't be created. Height is negative number, equals to 0 or more than 400. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Thumbnail can't be created. There is no proper height parameter for creating thumbnail.");
								}
							} else if (thumbnail.indexOf("x") != 0
									&& thumbnail.indexOf("x") != thumbnail
											.length() - 1) {
								try {
									int width = Integer.parseInt(thumbnail
											.substring(0,
													thumbnail.indexOf("x")));
									if (width > 0 && width <= 256) {
										try {
											int height = Integer
													.parseInt(thumbnail
															.substring(thumbnail
																	.indexOf("x") + 1));
											if (height > 0 && height <= 256) {
												imageWorkingWith
														.setThumbnailWidth(width);
												imageWorkingWith
														.setThumbnailHeight(height);
											
											} else {
												// writeErrorToFile
												// .writeError("Thumbnail can't be created. Height is negative number, equals to 0 or more than 400. Check your .XML file!");
											}
										} catch (NumberFormatException nfe) {
											haveAnError = true;
											// writeErrorToFile
											// .writeError("Thumbnail can't be created. There is no proper height parameter for creating thumbnail.");
										}
									} else {
										// writeErrorToFile
										// .writeError("Thumbnail can't be created. Width is negative number, equals to 0 or more than 400. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Thumbnail can't be created. There is no proper width parameter for creating thumbnail.");
								}
							} else if (thumbnail.indexOf("x") == thumbnail
									.length() - 1) {
								try {
									int width = Integer.parseInt(thumbnail);
									if (width > 0 && width <= 256) {
										imageWorkingWith
												.setThumbnailWidth(width);
										imageWorkingWith.setThumbnailHeight(0);
										
									} else {
										// writeErrorToFile
										// .writeError("Thumbnail can't be created. Width is negative number, equals to 0 or more than 400. Check your .XML file!");
									}
								} catch (NumberFormatException nfe) {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Thumbnail can't be created. There is no proper width parameter for creating thumbnail.");
								}
							}
						} else {
							imageWorkingWith.setThumbnailWidth(0);
							imageWorkingWith.setThumbnailHeight(0);
						}
						createThumbnail = false;
					}

					if (changeColorModel) {
						String str = new String(ch, start, length);
						
						if (checkForCharInString(str, length)
								&& ConfigFile.COLORSPACES.contains(str)) {
							imageWorkingWith.setChangeColorModel(str);
						
						} else if (checkForCharInString(str, length)
								&& !ConfigFile.COLORSPACES.contains(str)) {
							imageWorkingWith.setChangeColorModel("");
							// writeErrorToFile
							// .writeError("Change_Color_Model parameter is not properly entered. Check setting!.");
						} else {
							imageWorkingWith.setChangeColorModel("None");
						}

						changeColorModel = false;
					}

					if (changeForMono) {
						String str = new String(ch, start, length);
						if (checkForCharInString(str, length)) {
							try {
								int responce = Integer.parseInt(str);
								if (responce == 1 || Boolean.valueOf(str)) {
									imageWorkingWith.setChangeToMono(true);
								} else if (responce == 0
										|| !Boolean.valueOf(str)) {
									imageWorkingWith.setChangeToMono(false);
								}
						
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Change_To_Mono parameter must be only a boolean value, but it is not.");
							}
						} else {
							imageWorkingWith.setChangeToMono(false);
						}

						changeForMono = false;
					}

					if (flatteningImage) {
						String str = new String(ch, start, length);
						if (checkForCharInString(str, length)) {
							try {
								int responce = Integer.parseInt(str);
								if (responce == 1 || Boolean.valueOf(str)) {
									imageWorkingWith.setFlatteningImage(true);
								} else if (responce == 0
										|| !Boolean.valueOf(str)) {
									imageWorkingWith.setFlatteningImage(false);
								}
						
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Flatten_Image parameter must be only a boolean value, but it is not.");
							}
						} else {
							imageWorkingWith.setFlatteningImage(false);
						}

						flatteningImage = false;
					}

					if (qualityCompressionForJPEGImages) {
						String str = new String(ch, start, length);
						if (checkForCharInString(str, length)) {
							try {
								double quality = Double.parseDouble(str);
								if (quality > 0 && quality <= 100) {
									imageWorkingWith
											.setQualityCompressionForJPEGImages(quality);
							
								} else {
									haveAnError = true;
									// writeErrorToFile
									// .writeError("Quality_Compression_For_JPEG_Images parameter must be only a number value from 1 to 100, but it is not.");
								}
							} catch (NumberFormatException nfe) {
								haveAnError = true;
								// writeErrorToFile
								// .writeError("Quality_Compression_For_JPEG_Images parameter must be only a number value, but it is not.");
							}
						} else {
							imageWorkingWith
									.setQualityCompressionForJPEGImages(0);
						}

						qualityCompressionForJPEGImages = false;
					}


                    if(shouldRename){
                        shouldRename = false;
                        String str = new String(ch, start, length);
                        if (checkForCharInString(str, length)) {
                            try {
                                imageWorkingWith.setShouldRenameFile(Boolean.valueOf(str));
                            } catch (NumberFormatException nfe) {
                                haveAnError = true;
                            }
                        }
                    }

                    if (renameFormat){
                        renameFormat = false;
                        String str = new String(ch, start, length);
                        if (checkForCharInString(str, length)) {
                            imageWorkingWith.setRenamingFormat(str);
                        }
                    }

                    if (renameFormatTh){
                        renameFormatTh = false;
                        String str = new String(ch, start, length);
                        if (checkForCharInString(str, length)) {
                            imageWorkingWith.setRenamingFormatThumbnail(str);
                        }
                    }
			
				}

				public boolean checkForCharInString(String str, int length) {
					for (int i = 0; i < length; i++) {
						if (str.charAt(i) != (' ') && str.charAt(i) != ('\n')
								&& str.charAt(i) != ('\t')) {
							return true;
						}
					}
					return false;
				}

				private boolean checkForExtension(String format) {
					for (String extension : ConfigFile.EXTENSIONS) {
						if (format.equals(extension)) {
							return true;
						}
					}
					return false;
				}

			};

			File file = new File(xml.getPath());
			InputStream inputStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");

			InputSource source = new InputSource(reader);
			source.setEncoding("UTF-8");

			ConfigFile.COLORSPACES.add("CMYK");
			ConfigFile.COLORSPACES.add("CMY");
			ConfigFile.COLORSPACES.add("RGB");
			ConfigFile.COLORSPACES.add("sRGB");

			haveAnError = false;

			saxParser.parse(source, handler);

		} catch (Exception e) {
            LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
		}
		return imageWorkingWith;

	}
}
