package com.kma.ImageTool.DTO;

// old DataHandler
/**
 * Must contain all parameters about images that we want to transform
 * 
 * @author yaroslav
 * 
 */
public class ImageParametrs {

    @Deprecated
	String newName = "";
    String renamingFormat = "";
    String format = "";
	String changeColorModel = "";

	String resolutionDPI = "";
	String sizeHeight = "";
	String sizeWidth = "";
	String resizePercentage = "";
	String thumbnailHeight = "";
	String thumbnailWidth = "";
	String qualityCompressionForJPEGImages = "";

	String lessCompareHeight = "";
	String betweenFirstCompareHeight = "";
	String betweenSecondCompareHeight = "";
	String lessResizeToHeight = "";
	String betweenResizeHeight = "";
	String moreResizeHeight = "";
	String moreComparedHeight = "";

	String lessCompareWidth = "";
	String betweenFirstCompareWidth = "";
	String betweenSecondCompareWidth = "";
	String lessResizeToWidth = "";
	String betweenResizeWidth = "";
	String moreResizeWidth = "";
	String moreComparedWidth = "";

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

	boolean changeToMono = false;// means color
	boolean flatteningImage = false;
	boolean isPerCent;

	boolean sizeIsManual;// is manual or not
	boolean sizeIsWidth;// by which creteria
	int sizeLessBetMore;// -1,0,1 comparation

	boolean isHeight;// half manual mode
	boolean isWidth;// when half manual

	boolean isLessHeight;
	boolean isBetweenHeight;
	boolean isMoreHeight;

	boolean isLessWidth;
	boolean isBetweenWidth;
	boolean isMoreWidth;

    private boolean shouldRenameFile = false;

	public boolean isSizeIsManual() {
		return sizeIsManual;
	}

	public void setSizeIsManual(boolean sizeIsManual) {
		this.sizeIsManual = sizeIsManual;
	}

	public boolean isSizeIsWidth() {
		return sizeIsWidth;
	}

	public void setSizeIsWidth(boolean sizeIsWidth) {
		this.sizeIsWidth = sizeIsWidth;
	}

	public int getSizeLessBetMore() {
		return sizeLessBetMore;
	}

	public void setSizeLessBetMore(int sizeLessBetMore) {
		this.sizeLessBetMore = sizeLessBetMore;
	}

	public String getResolutionDPI() {
		return resolutionDPI;
	}

	public void setResolutionDPI(String resolutionDPI) {
		this.resolutionDPI = resolutionDPI;
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

	public String getChangeColorModel() {
		return changeColorModel;
	}

	public void setChangeColorModel(String changeColorModel) {
		this.changeColorModel = changeColorModel;
	}

	public String getSizeHeight() {
		return sizeHeight;
	}

	public void setSizeHeight(String sizeHeight) {
		this.sizeHeight = sizeHeight;
	}

	public String getSizeWidth() {
		return sizeWidth;
	}

	public void setSizeWidth(String sizeWidth) {
		this.sizeWidth = sizeWidth;
	}

	public String getResizePercentage() {
		return resizePercentage;
	}

	public void setResizePercentage(String resizePercentage) {
		this.resizePercentage = resizePercentage;
	}

	public String getThumbnailHeight() {
		return thumbnailHeight;
	}

	public void setThumbnailHeight(String thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	public String getThumbnailWidth() {
		return thumbnailWidth;
	}

	public void setThumbnailWidth(String thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	public String getQualityCompressionForJPEGImages() {
		return qualityCompressionForJPEGImages;
	}

	public void setQualityCompressionForJPEGImages(
			String qualityCompressionForJPEGImages) {
		this.qualityCompressionForJPEGImages = qualityCompressionForJPEGImages;
	}

	public boolean isChangeToMono() {
		return changeToMono;
	}

	public char isChangeToMonoChar() {
		if (changeToMono)
			return '1';
		return '0';
	}

	public void setChangeToMono(boolean changeToMono) {
		this.changeToMono = changeToMono;
	}

	public boolean isFlatteningImage() {
		return flatteningImage;
	}

	public char isFlatteningImageChar() {
		if (flatteningImage)
			return '1';
		return '0';
	}

	public void setFlatteningImage(boolean flatteningImage) {
		this.flatteningImage = flatteningImage;
	}

	public boolean isPerCent() {
		return isPerCent;
	}

	public void setPerCent(boolean isPerCent) {
		this.isPerCent = isPerCent;
	}

	public boolean isHeight() {
		return isHeight;
	}

	public void setHeight(boolean isHeight) {
		this.isHeight = isHeight;
	}

	public boolean isWidth() {
		return isWidth;
	}

	public void setWidth(boolean isWidth) {
		this.isWidth = isWidth;
	}

	public boolean isLessHeight() {
		return isLessHeight;
	}

	public char isLessHeightChar() {
		if (isLessHeight)
			return '1';
		return '0';
	}

	public void setLessHeight(boolean isLessHeight) {
		this.isLessHeight = isLessHeight;
	}

	public boolean isBetweenHeight() {
		return isBetweenHeight;
	}

	public char isBetweenHeightChar() {
		if (isBetweenHeight)
			return '1';
		return '0';

	}

	public void setBetweenHeight(boolean isBetweenHeight) {
		this.isBetweenHeight = isBetweenHeight;
	}

	public boolean isMoreHeight() {
		return isMoreHeight;
	}

	public char isMoreHeightChar() {

		if (isMoreHeight)
			return '1';
		return '0';
	}

	public void setMoreHeight(boolean isMoreHeight) {
		this.isMoreHeight = isMoreHeight;
	}

	public char isLessWidthChar() {
		if (isLessWidth)
			return '1';
		return '0';

	}

	public boolean isLessWidth() {
		return isLessWidth;
	}

	public void setLessWidth(boolean isLessWidth) {
		this.isLessWidth = isLessWidth;
	}

	public boolean isBetweenWidth() {
		return isBetweenWidth;
	}

	public char isBetweenWidthChar() {
		if (isBetweenWidth)
			return '1';
		return '0';
	}

	public void setBetweenWidth(boolean isBetweenWidth) {
		this.isBetweenWidth = isBetweenWidth;
	}

	public boolean isMoreWidth() {
		return isMoreWidth;
	}

	public char isMoreWidthChar() {
		if (isMoreWidth)
			return '1';
		return '0';
	}

	public void setMoreWidth(boolean isMoreWidth) {
		this.isMoreWidth = isMoreWidth;
	}

	public String getLessCompareHeight() {
		return lessCompareHeight;
	}

	public void setLessCompareHeight(String lessCompareHeight) {
		this.lessCompareHeight = lessCompareHeight;
	}

	public String getBetweenFirstCompareHeight() {
		return betweenFirstCompareHeight;
	}

	public void setBetweenFirstCompareHeight(String betweenFirstCompareHeight) {
		this.betweenFirstCompareHeight = betweenFirstCompareHeight;
	}

	public String getBetweenSecondCompareHeight() {
		return betweenSecondCompareHeight;
	}

	public void setBetweenSecondCompareHeight(String betweenSecondCompareHeight) {
		this.betweenSecondCompareHeight = betweenSecondCompareHeight;
	}

	public String getLessResizeToHeight() {
		return lessResizeToHeight;
	}

	public void setLessResizeToHeight(String lessResizeToHeight) {
		this.lessResizeToHeight = lessResizeToHeight;
	}

	public String getBetweenResizeHeight() {
		return betweenResizeHeight;
	}

	public void setBetweenResizeHeight(String betweenResizeHeight) {
		this.betweenResizeHeight = betweenResizeHeight;
	}

	public String getMoreResizeHeight() {
		return moreResizeHeight;
	}

	public void setMoreResizeHeight(String moreResizeHeight) {
		this.moreResizeHeight = moreResizeHeight;
	}

	public String getLessCompareWidth() {
		return lessCompareWidth;
	}

	public void setLessCompareWidth(String lessCompareWidth) {
		this.lessCompareWidth = lessCompareWidth;
	}

	public String getBetweenFirstCompareWidth() {
		return betweenFirstCompareWidth;
	}

	public void setBetweenFirstCompareWidth(String betweenFirstCompareWidth) {
		this.betweenFirstCompareWidth = betweenFirstCompareWidth;
	}

	public String getBetweenSecondCompareWidth() {
		return betweenSecondCompareWidth;
	}

	public void setBetweenSecondCompareWidth(String betweenSecondCompareWidth) {
		this.betweenSecondCompareWidth = betweenSecondCompareWidth;
	}

	public String getLessResizeToWidth() {
		return lessResizeToWidth;
	}

	public void setLessResizeToWidth(String lessResizeToWidth) {
		this.lessResizeToWidth = lessResizeToWidth;
	}

	public String getBetweenResizeWidth() {
		return betweenResizeWidth;
	}

	public void setBetweenResizeWidth(String betweenResizeWidth) {
		this.betweenResizeWidth = betweenResizeWidth;
	}

	public String getMoreResizeWidth() {
		return moreResizeWidth;
	}

	public void setMoreResizeWidth(String moreResizeWidth) {
		this.moreResizeWidth = moreResizeWidth;
	}

	public String getMoreComparedHeight() {
		return moreComparedHeight;
	}

	public void setMoreComparedHeight(String moreComparedHeight) {
		this.moreComparedHeight = moreComparedHeight;
	}

	public String getMoreComparedWidth() {
		return moreComparedWidth;
	}

	public void setMoreComparedWidth(String moreComparedWidth) {
		this.moreComparedWidth = moreComparedWidth;
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

    public String getRenamingFormat() {
        return renamingFormat;
    }

    public void setRenamingFormat(String renamingFormat) {
        this.renamingFormat = renamingFormat;
    }

    public boolean shouldRenameFile() {
        return shouldRenameFile;
    }

    public void setShouldRenameFile(boolean shouldRenameFile) {
        this.shouldRenameFile = shouldRenameFile;
    }

    @Override
	public String toString() {
		return "ImageParametrs [newName=" + newName + ", format=" + format
				+ ", changeColorModel=" + changeColorModel + ", resolutionDPI="
				+ resolutionDPI + ", sizeHeight=" + sizeHeight + ", sizeWidth="
				+ sizeWidth + ", resizePercentage=" + resizePercentage
				+ ", thumbnailHeight=" + thumbnailHeight + ", thumbnailWidth="
				+ thumbnailWidth + ", qualityCompressionForJPEGImages="
				+ qualityCompressionForJPEGImages + ", lessCompareHeight="
				+ lessCompareHeight + ", betweenFirstCompareHeight="
				+ betweenFirstCompareHeight + ", betweenSecondCompareHeight="
				+ betweenSecondCompareHeight + ", lessResizeToHeight="
				+ lessResizeToHeight + ", betweenResizeHeight="
				+ betweenResizeHeight + ", moreResizeHeight="
				+ moreResizeHeight + ", moreComparedHeight="
				+ moreComparedHeight + ", lessCompareWidth=" + lessCompareWidth
				+ ", betweenFirstCompareWidth=" + betweenFirstCompareWidth
				+ ", betweenSecondCompareWidth=" + betweenSecondCompareWidth
				+ ", lessResizeToWidth=" + lessResizeToWidth
				+ ", betweenResizeWidth=" + betweenResizeWidth
				+ ", moreResizeWidth=" + moreResizeWidth
				+ ", moreComparedWidth=" + moreComparedWidth
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
				+ typeOfBetweenHeightToChange + ", changeToMono="
				+ changeToMono + ", flatteningImage=" + flatteningImage
				+ ", isPerCent=" + isPerCent + ", sizeIsManual=" + sizeIsManual
				+ ", sizeIsWidth=" + sizeIsWidth + ", sizeLessBetMore="
				+ sizeLessBetMore + ", isHeight=" + isHeight + ", isWidth="
				+ isWidth + ", isLessHeight=" + isLessHeight
				+ ", isBetweenHeight=" + isBetweenHeight + ", isMoreHeight="
				+ isMoreHeight + ", isLessWidth=" + isLessWidth
				+ ", isBetweenWidth=" + isBetweenWidth + ", isMoreWidth="
				+ isMoreWidth + "]";
	}

}
