package com.kma.ImageTool.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The old class for fetching data from already created XML file
 * 
 * @author yaroslav
 * 
 */
public class ImageParameterFetch {

	@SuppressWarnings("rawtypes")
	private List<ArrayList> setOfSetsOfOldValues = new ArrayList<ArrayList>();

    @Deprecated
	private String newName;
	private String renamingFormat;
	private String format;
	private String changeColorModel;

	private String typeOfLessWidthToCheck = "";
	private String typeOfLessHeightToCheck = "";
	private String typeOfMoreWidthToCheck = "";
	private String typeOfMoreHeightToCheck = "";
	private String typeOfBetweenWidthToCheck = "";
	private String typeOfBetweenHeightToCheck = "";
	private String typeOfLessWidthToChange = "";
	private String typeOfLessHeightToChange = "";
	private String typeOfMoreWidthToChange = "";
	private String typeOfMoreHeightToChange = "";
	private String typeOfBetweenWidthToChange = "";
	private String typeOfBetweenHeightToChange = "";

	private int resolutionDPI = 0;
	private int sizeHeight = 0;
	private int sizeWidth = 0;
	private int sizeWidthIfLess = 0;
	private int sizeWidthIfMore = 0;
	private int sizeWidthIfBetween = 0;
	private int sizeHeightIfLess = 0;
	private int sizeHeightIfMore = 0;
	private int sizeHeightIfBetween = 0;
	private int sizeWidthToCheckIfLess = 0;
	private int sizeHeightToCheckIfLess = 0;
	private int sizeWidthToCheckIfMore = 0;
	private int sizeHeightToCheckIfMore = 0;
	private int sizeWidthToCheckIfBetweenFirst = 0;
	private int sizeHeightToCheckIfBetweenFirst = 0;
	private int sizeWidthToCheckIfBetweenSecond = 0;
	private int sizeHeightToCheckIfBetweenSecond = 0;
	private int resizePercentage = 0;
	private int thumbnailHeight = 0;
	private int thumbnailWidth = 0;
	private double qualityCompressionForJPEGImages = 0;

	private boolean parameterForResizeOfWidthIfLess = false;
	private boolean parameterForResizeOfWidthIfMore = false;
	private boolean parameterForResizeOfWidthIfBetween = false;
	private boolean parameterForResizeOfHeightIfLess = false;
	private boolean parameterForResizeOfHeightIfMore = false;
	private boolean parameterForResizeOfHeightIfBetween = false;

	private boolean changeToMono = false;
	private boolean flatteningImage = false;

    private boolean shouldRenameFile = false;

	public ImageParameterFetch() {
		this.newName = new String("");
		this.format = new String("");
		this.changeColorModel = new String("");

	}

	@SuppressWarnings("rawtypes")
	public List<ArrayList> getList() {
		return this.setOfSetsOfOldValues;
	}

	private void addValuesToArray(ArrayList<Object> array) {
		array.add(this.newName);
		array.add(this.format);
		array.add(this.resizePercentage);
		array.add(this.resolutionDPI);
		array.add(this.sizeHeight);
		array.add(this.sizeWidth);
		array.add(this.sizeWidthIfLess);
		array.add(this.sizeWidthIfMore);
		array.add(this.sizeWidthIfBetween);
		array.add(this.sizeHeightIfLess);
		array.add(this.sizeHeightIfMore);
		array.add(this.sizeHeightIfBetween);
		array.add(this.sizeWidthToCheckIfLess);
		array.add(this.sizeWidthToCheckIfMore);
		array.add(this.sizeWidthToCheckIfBetweenFirst);
		array.add(this.sizeWidthToCheckIfBetweenSecond);
		array.add(this.sizeHeightToCheckIfLess);
		array.add(this.sizeHeightToCheckIfMore);
		array.add(this.sizeHeightToCheckIfBetweenFirst);
		array.add(this.sizeHeightToCheckIfBetweenSecond);
		array.add(this.parameterForResizeOfWidthIfLess);
		array.add(this.parameterForResizeOfWidthIfMore);
		array.add(this.parameterForResizeOfWidthIfBetween);
		array.add(this.parameterForResizeOfHeightIfLess);
		array.add(this.parameterForResizeOfHeightIfMore);
		array.add(this.parameterForResizeOfHeightIfBetween);

		array.add(this.thumbnailHeight);
		array.add(this.thumbnailWidth);
		array.add(this.qualityCompressionForJPEGImages);
		array.add(this.changeColorModel);
		array.add(this.changeToMono);
		array.add(this.flatteningImage);
	}

	public void rememberPreviousSettings() {
		ArrayList<Object> oldValues = new ArrayList<Object>();

		addValuesToArray(oldValues);

		setOfSetsOfOldValues.add(oldValues);
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public boolean isFlatteningImage() {
		return flatteningImage;
	}

	public void setFlatteningImage(boolean flatteningImage) {
		this.flatteningImage = flatteningImage;
	}

	public int getResolutionDPI() {
		return resolutionDPI;
	}

	public void setResolutionDPI(int resolutionDPI) {
		this.resolutionDPI = resolutionDPI;
	}

	public int getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(int sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	public int getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(int sizeWidth) {
		this.sizeWidth = sizeWidth;
	}

	public int getThumbnailHeight() {
		return thumbnailHeight;
	}

	public void setThumbnailHeight(int thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	public int getThumbnailWidth() {
		return thumbnailWidth;
	}

	public void setThumbnailWidth(int thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	public int getResizePercentage() {
		return resizePercentage;
	}

	public void setResizePercentage(int resizePercentage) {
		this.resizePercentage = resizePercentage;
	}

	public double getQualityCompressionForJPEGImages() {
		return qualityCompressionForJPEGImages;
	}

	public void setQualityCompressionForJPEGImages(
			double qualityCompressionForJPEGImages) {
		this.qualityCompressionForJPEGImages = qualityCompressionForJPEGImages;
	}

	public String getChangeColorModel() {
		return changeColorModel;
	}

	public void setChangeColorModel(String changeColorModel) {
		this.changeColorModel = changeColorModel;
	}

	public boolean isChangeToMono() {
		return changeToMono;
	}

	public void setChangeToMono(boolean changeToMono) {
		this.changeToMono = changeToMono;
	}

	public int getSizeWidthIfLess() {
		return sizeWidthIfLess;
	}

	public void setSizeWidthIfLess(int sizeWidthIfLess) {
		this.sizeWidthIfLess = sizeWidthIfLess;
	}

	public int getSizeWidthIfMore() {
		return sizeWidthIfMore;
	}

	public void setSizeWidthIfMore(int sizeWidthIfMore) {
		this.sizeWidthIfMore = sizeWidthIfMore;
	}

	public int getSizeWidthIfBetween() {
		return sizeWidthIfBetween;
	}

	public void setSizeWidthIfBetween(int sizeWidthIfBetween) {
		this.sizeWidthIfBetween = sizeWidthIfBetween;
	}

	public int getSizeHeightIfLess() {
		return sizeHeightIfLess;
	}

	public void setSizeHeightIfLess(int sizeHeightIfLess) {
		this.sizeHeightIfLess = sizeHeightIfLess;
	}

	public int getSizeHeightIfMore() {
		return sizeHeightIfMore;
	}

	public void setSizeHeightIfMore(int sizeHeightIfMore) {
		this.sizeHeightIfMore = sizeHeightIfMore;
	}

	public int getSizeHeightIfBetween() {
		return sizeHeightIfBetween;
	}

	public void setSizeHeightIfBetween(int sizeHeightIfBetween) {
		this.sizeHeightIfBetween = sizeHeightIfBetween;
	}

	public int getSizeWidthToCheckIfLess() {
		return sizeWidthToCheckIfLess;
	}

	public void setSizeWidthToCheckIfLess(int sizeWidthToCheckIfLess) {
		this.sizeWidthToCheckIfLess = sizeWidthToCheckIfLess;
	}

	public int getSizeHeightToCheckIfLess() {
		return sizeHeightToCheckIfLess;
	}

	public void setSizeHeightToCheckIfLess(int sizeHeightToCheckIfLess) {
		this.sizeHeightToCheckIfLess = sizeHeightToCheckIfLess;
	}

	public int getSizeWidthToCheckIfMore() {
		return sizeWidthToCheckIfMore;
	}

	public void setSizeWidthToCheckIfMore(int sizeWidthToCheckIfMore) {
		this.sizeWidthToCheckIfMore = sizeWidthToCheckIfMore;
	}

	public int getSizeHeightToCheckIfMore() {
		return sizeHeightToCheckIfMore;
	}

	public void setSizeHeightToCheckIfMore(int sizeHeightToCheckIfMore) {
		this.sizeHeightToCheckIfMore = sizeHeightToCheckIfMore;
	}

	public boolean isParameterForResizeOfWidthIfLess() {
		return parameterForResizeOfWidthIfLess;
	}

	public void setParameterForResizeOfWidthIfLess(
			boolean parameterForResizeOfWidthIfLess) {
		this.parameterForResizeOfWidthIfLess = parameterForResizeOfWidthIfLess;
	}

	public boolean isParameterForResizeOfWidthIfMore() {
		return parameterForResizeOfWidthIfMore;
	}

	public void setParameterForResizeOfWidthIfMore(
			boolean parameterForResizeOfWidthIfMore) {
		this.parameterForResizeOfWidthIfMore = parameterForResizeOfWidthIfMore;
	}

	public boolean isParameterForResizeOfWidthIfBetween() {
		return parameterForResizeOfWidthIfBetween;
	}

	public void setParameterForResizeOfWidthIfBetween(
			boolean parameterForResizeOfWidthIfBetween) {
		this.parameterForResizeOfWidthIfBetween = parameterForResizeOfWidthIfBetween;
	}

	public boolean isParameterForResizeOfHeightIfLess() {
		return parameterForResizeOfHeightIfLess;
	}

	public void setParameterForResizeOfHeightIfLess(
			boolean parameterForResizeOfHeightIfLess) {
		this.parameterForResizeOfHeightIfLess = parameterForResizeOfHeightIfLess;
	}

	public boolean isParameterForResizeOfHeightIfMore() {
		return parameterForResizeOfHeightIfMore;
	}

	public void setParameterForResizeOfHeightIfMore(
			boolean parameterForResizeOfHeightIfMore) {
		this.parameterForResizeOfHeightIfMore = parameterForResizeOfHeightIfMore;
	}

	public boolean isParameterForResizeOfHeightIfBetween() {
		return parameterForResizeOfHeightIfBetween;
	}

	public void setParameterForResizeOfHeightIfBetween(
			boolean parameterForResizeOfHeightIfBetween) {
		this.parameterForResizeOfHeightIfBetween = parameterForResizeOfHeightIfBetween;
	}

	public int getSizeWidthToCheckIfBetweenFirst() {
		return sizeWidthToCheckIfBetweenFirst;
	}

	public void setSizeWidthToCheckIfBetweenFirst(
			int sizeWidthToCheckIfBetweenFirst) {
		this.sizeWidthToCheckIfBetweenFirst = sizeWidthToCheckIfBetweenFirst;
	}

	public int getSizeHeightToCheckIfBetweenFirst() {
		return sizeHeightToCheckIfBetweenFirst;
	}

	public void setSizeHeightToCheckIfBetweenFirst(
			int sizeHeightToCheckIfBetweenFirst) {
		this.sizeHeightToCheckIfBetweenFirst = sizeHeightToCheckIfBetweenFirst;
	}

	public int getSizeWidthToCheckIfBetweenSecond() {
		return sizeWidthToCheckIfBetweenSecond;
	}

	public void setSizeWidthToCheckIfBetweenSecond(
			int sizeWidthToCheckIfBetweenSecond) {
		this.sizeWidthToCheckIfBetweenSecond = sizeWidthToCheckIfBetweenSecond;
	}

	public int getSizeHeightToCheckIfBetweenSecond() {
		return sizeHeightToCheckIfBetweenSecond;
	}

	public void setSizeHeightToCheckIfBetweenSecond(
			int sizeHeightToCheckIfBetweenSecond) {
		this.sizeHeightToCheckIfBetweenSecond = sizeHeightToCheckIfBetweenSecond;
	}

	public String getTypeOfLessWidthToCheck() {
		return typeOfLessWidthToCheck;
	}

	public void setTypeOfLessWidthToCheck(String typeOfLessWidthToCheck) {
		this.typeOfLessWidthToCheck = typeOfLessWidthToCheck;
	}

	public String getTypeOfLessHeightToCheck() {
		return typeOfLessHeightToCheck;
	}

	public void setTypeOfLessHeightToCheck(String typeOfLessHeightToCheck) {
		this.typeOfLessHeightToCheck = typeOfLessHeightToCheck;
	}

	public String getTypeOfMoreWidthToCheck() {
		return typeOfMoreWidthToCheck;
	}

	public void setTypeOfMoreWidthToCheck(String typeOfMoreWidthToCheck) {
		this.typeOfMoreWidthToCheck = typeOfMoreWidthToCheck;
	}

	public String getTypeOfMoreHeightToCheck() {
		return typeOfMoreHeightToCheck;
	}

	public void setTypeOfMoreHeightToCheck(String typeOfMoreHeightToCheck) {
		this.typeOfMoreHeightToCheck = typeOfMoreHeightToCheck;
	}

	public String getTypeOfBetweenWidthToCheck() {
		return typeOfBetweenWidthToCheck;
	}

	public void setTypeOfBetweenWidthToCheck(String typeOfBetweenWidthToCheck) {
		this.typeOfBetweenWidthToCheck = typeOfBetweenWidthToCheck;
	}

	public String getTypeOfBetweenHeightToCheck() {
		return typeOfBetweenHeightToCheck;
	}

	public void setTypeOfBetweenHeightToCheck(String typeOfBetweenHeightToCheck) {
		this.typeOfBetweenHeightToCheck = typeOfBetweenHeightToCheck;
	}

	public String getTypeOfLessWidthToChange() {
		return typeOfLessWidthToChange;
	}

	public void setTypeOfLessWidthToChange(String typeOfLessWidthToChange) {
		this.typeOfLessWidthToChange = typeOfLessWidthToChange;
	}

	public String getTypeOfLessHeightToChange() {
		return typeOfLessHeightToChange;
	}

	public void setTypeOfLessHeightToChange(String typeOfLessHeightToChange) {
		this.typeOfLessHeightToChange = typeOfLessHeightToChange;
	}

	public String getTypeOfMoreWidthToChange() {
		return typeOfMoreWidthToChange;
	}

	public void setTypeOfMoreWidthToChange(String typeOfMoreWidthToChange) {
		this.typeOfMoreWidthToChange = typeOfMoreWidthToChange;
	}

	public String getTypeOfMoreHeightToChange() {
		return typeOfMoreHeightToChange;
	}

	public void setTypeOfMoreHeightToChange(String typeOfMoreHeightToChange) {
		this.typeOfMoreHeightToChange = typeOfMoreHeightToChange;
	}

	public String getTypeOfBetweenWidthToChange() {
		return typeOfBetweenWidthToChange;
	}

	public void setTypeOfBetweenWidthToChange(String typeOfBetweenWidthToChange) {
		this.typeOfBetweenWidthToChange = typeOfBetweenWidthToChange;
	}

	public String getTypeOfBetweenHeightToChange() {
		return typeOfBetweenHeightToChange;
	}

	public void setTypeOfBetweenHeightToChange(
			String typeOfBetweenHeightToChange) {
		this.typeOfBetweenHeightToChange = typeOfBetweenHeightToChange;
	}

    public boolean shouldRenameFile() {
        return shouldRenameFile;
    }

    public void setShouldRenameFile(boolean shouldRenameFile) {
        this.shouldRenameFile = shouldRenameFile;
    }

    public String getRenamingFormat() {
        return renamingFormat;
    }

    public void setRenamingFormat(String renamingFormat) {
        this.renamingFormat = renamingFormat;
    }


    @Override
	public String toString() {
		return "ImageParameterFetch [setOfSetsOfOldValues="
				+ setOfSetsOfOldValues + ", newName=" + newName + ", format="
				+ format + ", changeColorModel=" + changeColorModel
				+ ", typeOfLessWidthToCheck=" + typeOfLessWidthToCheck
				+ ", typeOfLessHeightToCheck=" + typeOfLessHeightToCheck
				+ ", typeOfMoreWidthToCheck=" + typeOfMoreWidthToCheck
				+ ", typeOfMoreHeightToCheck=" + typeOfMoreHeightToCheck
				+ ", typeOfBetweenWidthToCheck=" + typeOfBetweenWidthToCheck
				+ ", typeOfBetweenHeightToCheck=" + typeOfBetweenHeightToCheck
				+ ", typeOfLessWidthToChange=" + typeOfLessWidthToChange
				+ ", typeOfLessHeightToChange=" + typeOfLessHeightToChange
				+ ", typeOfMoreWidthToChange=" + typeOfMoreWidthToChange
				+ ", typeOfMoreHeightToChange=" + typeOfMoreHeightToChange
				+ ", typeOfBetweenWidthToChange=" + typeOfBetweenWidthToChange
				+ ", typeOfBetweenHeightToChange="
				+ typeOfBetweenHeightToChange + ", resolutionDPI="
				+ resolutionDPI + ", sizeHeight=" + sizeHeight + ", sizeWidth="
				+ sizeWidth + ", sizeWidthIfLess=" + sizeWidthIfLess
				+ ", sizeWidthIfMore=" + sizeWidthIfMore
				+ ", sizeWidthIfBetween=" + sizeWidthIfBetween
				+ ", sizeHeightIfLess=" + sizeHeightIfLess
				+ ", sizeHeightIfMore=" + sizeHeightIfMore
				+ ", sizeHeightIfBetween=" + sizeHeightIfBetween
				+ ", sizeWidthToCheckIfLess=" + sizeWidthToCheckIfLess
				+ ", sizeHeightToCheckIfLess=" + sizeHeightToCheckIfLess
				+ ", sizeWidthToCheckIfMore=" + sizeWidthToCheckIfMore
				+ ", sizeHeightToCheckIfMore=" + sizeHeightToCheckIfMore
				+ ", sizeWidthToCheckIfBetweenFirst="
				+ sizeWidthToCheckIfBetweenFirst
				+ ", sizeHeightToCheckIfBetweenFirst="
				+ sizeHeightToCheckIfBetweenFirst
				+ ", sizeWidthToCheckIfBetweenSecond="
				+ sizeWidthToCheckIfBetweenSecond
				+ ", sizeHeightToCheckIfBetweenSecond="
				+ sizeHeightToCheckIfBetweenSecond + ", resizePercentage="
				+ resizePercentage + ", thumbnailHeight=" + thumbnailHeight
				+ ", thumbnailWidth=" + thumbnailWidth
				+ ", qualityCompressionForJPEGImages="
				+ qualityCompressionForJPEGImages
				+ ", parameterForResizeOfWidthIfLess="
				+ parameterForResizeOfWidthIfLess
				+ ", parameterForResizeOfWidthIfMore="
				+ parameterForResizeOfWidthIfMore
				+ ", parameterForResizeOfWidthIfBetween="
				+ parameterForResizeOfWidthIfBetween
				+ ", parameterForResizeOfHeightIfLess="
				+ parameterForResizeOfHeightIfLess
				+ ", parameterForResizeOfHeightIfMore="
				+ parameterForResizeOfHeightIfMore
				+ ", parameterForResizeOfHeightIfBetween="
				+ parameterForResizeOfHeightIfBetween + ", changeToMono="
				+ changeToMono + ", flatteningImage=" + flatteningImage + "]";
	}

}
