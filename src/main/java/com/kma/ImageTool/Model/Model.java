package com.kma.ImageTool.Model;

import com.kma.ImageTool.DTO.ImageParametrs;
import com.kma.ImageTool.DataStrategy.StringXml;
import com.kma.ImageTool.Error.InvalidImageFileNameException;
import com.kma.ImageTool.Error.NotExistingXMLError;
import com.kma.ImageTool.Log.LoggerUtils;

import java.io.*;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/**
 * Singletone model to handle all work with data
 * 
 * @author yaroslav
 * 
 */

public enum Model {
	GET;
	private String pathToImageMagic = "";
	private String pathToFolderWorkingWith = "";
	private String templateFileName = "";
	private ImageParameterFetch imageFetch;

	/**
	 * Do run .exe file
	 * 
	 */
	// dummy temporary, need to write bat file
	public boolean doInstallImageMagic() {

		try {
			Runtime.getRuntime().exec("cmd /c start install_magic.bat");
            return true;
		} catch (IOException e) {
            LoggerUtils.getLogger().log(Level.SEVERE, "Can't run your bat", e);
		}
        return false;
	}

	/**
	 * Check if we have already installed imageMagic tool data holds in
	 * setting.txt file, in the root directory
	 * 
	 * @return true if we have already installed
	 * @return false in other wise
	 */
	public boolean doImageMagicInstalled() {
		if (new File("settings.txt").exists())
			return true;
		else
			return false;

	}

	/**
	 * Save path ti ImageMagic Library
	 * 
	 */

	public boolean doSetPathToImageLibrary(String path) {

		if (!path.equals("")) {
			pathToImageMagic = path;
			File f = new File("settings.txt");
			BufferedWriter writer;
			try {

				writer = new BufferedWriter(new FileWriter(f));
				writer.write(path);
				writer.close();

			} catch (IOException e) {
                LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
				return false;
			}
		} else {
			return false;
		}
		return true;

	}

	/**
	 * Set path to folder that we want to change images
	 * 
	 * @param s
	 *            path that comes MetroTextView from MainArea class
	 */
	public void doSetPathToFolderWorkingWith(String s) {
		pathToFolderWorkingWith = s;
	}

	/**
	 * Do save {@link ImageParametrs} obj to xml file in chosen directory
	 * 
	 * @param imageDTO
	 *            objecct that holds all info
	 * @return
	 */
	public boolean doSaveXmlFile(ImageParametrs imageDTO) {
		// TODO Auto-generated method stub
		if (!pathToFolderWorkingWith.equals("")) {
			
			String path = pathToFolderWorkingWith + File.separator + getTemplateFileName();
			File f = new File(path);
			if (f.exists()) {
                LoggerUtils.getLogger().info("delete file: " + path);
				f.delete();
			}
			try {
                LoggerUtils.getLogger().info("create file: " + path);
				f.createNewFile();
			} catch (IOException e1) {
                LoggerUtils.getLogger().log(Level.SEVERE, "error",e1);
			}
			BufferedWriter writer;
			try {

				writer = new BufferedWriter(new FileWriter(f));
				StringXml sx = new StringXml(imageDTO);
				writer.write(sx.getXmlString());
				writer.close();

			} catch (IOException e) {
                LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
				return false;
			}
		} else {
			return false;
		}
		return true;

	}

	/**
	 * Check if we have already created xml file in folder that we want to work
	 * with
	 * 
	 * @return true if exists false if not
	 */
	public boolean isExistsXML() {
		String path = pathToFolderWorkingWith + File.separator + getTemplateFileName();

		if (new File(path).exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param xml
	 *            file that we want to parse
	 * @return {@link ImageParameterFetch} obj that holds all data which
	 *         included in xml
	 */
	public ImageParameterFetch getImageFetch(File xml) {

		ParseXML parse = new ParseXML();
		return parse.parseFile(xml);

	}

	/**
	 * 
	 * @return file that holds your XML
	 * @throws NotExistingXMLError
	 *             if not exists XML file
     */
	public File getXmlFile() throws NotExistingXMLError {
		if (isExistsXML()) {
			String path = pathToFolderWorkingWith + File.separator + getTemplateFileName();
			return new File(path);
		} else
			throw new NotExistingXMLError();
	}

	public String getPathToFolderWorkingWith() {
		return pathToFolderWorkingWith;
	}

	/**
	 * read path to image magic library
	 * 
	 * @return the path
	 */
	public String getPathToLibrary() {

		//BufferedReader br = null;

		try {

			/*String sCurrentLine;

			br = new BufferedReader(new FileReader("settings.txt"));

			// only one line must be
			while ((sCurrentLine = br.readLine()) != null) {
				break;
			}*/


			//pathToImageMagic = sCurrentLine;

            // relative path to sewn lib
            //pathToImageMagic = URLDecoder.decode(new File("").getAbsolutePath(), "UTF-8") + sCurrentLine;

            pathToImageMagic = URLDecoder.decode(new File("").getAbsolutePath(), "UTF-8") + File.separator + "imagelibs"
                    + File.separator + "imagemagick" + File.separator + "6.8.9-1";


		} catch (IOException e) {
            LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
		} /*finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
                LoggerUtils.getLogger().log(Level.SEVERE, "error", ex);
			}
		}*/

		return pathToImageMagic;
	}

	/**
	 * Start process of editing images
	 */
	public boolean doRunEditing() throws InvalidImageFileNameException {
		try {
            return new WorkingWithImage(getImageFetch(getXmlFile())).process(getPhotos(), getPathToLibrary(), getPathToFolderWorkingWith());
        } catch (Exception e) {
            LoggerUtils.getLogger().log(Level.SEVERE, "error", e);
		}
		return false;

	}

	/**
	 * 
	 * @return Set of string of chosen directory that we working with
	 */

	public Set<String> getPhotos() {
		Set<String> set = new HashSet<String>();
		File directory = new File(pathToFolderWorkingWith);

		for (final File f : directory.listFiles(IMAGE_FILTER)) {
			set.add(f.getPath());
		}

		return set;
	}

	/**
	 * set filter for file in directory choose only that ends with image -
	 * extension
	 */
	private FilenameFilter IMAGE_FILTER = new FilenameFilter() {

		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : ConfigFile.EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return (true);
				}
			}
			return (false);
		}
	};

    public void doSetPathForTemplateName(String templateName) {
        this.templateFileName = templateName;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }
}
