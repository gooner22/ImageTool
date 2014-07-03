package com.kma.ImageTool.Model;

import com.kma.ImageTool.DTO.ImageParametrs;
import com.kma.ImageTool.DataStrategy.StringXml;
import com.kma.ImageTool.Error.NotExistingXMLError;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

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
			System.out.println("Can't run your bat");
			e.printStackTrace();
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

				e.printStackTrace();
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
			
			String path = pathToFolderWorkingWith + File.separator + "imageSettings.xml";
			File f = new File(path);
			if (f.exists()) {
				System.out.println("delete file");
				f.delete();
			}
			try {
				System.out.println("create file");
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedWriter writer;
			try {

				writer = new BufferedWriter(new FileWriter(f));
				StringXml sx = new StringXml(imageDTO);
				writer.write(sx.getXmlString());
				writer.close();

			} catch (IOException e) {

				e.printStackTrace();
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
		String path = pathToFolderWorkingWith + File.separator + "imageSettings.xml";

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
			String path = pathToFolderWorkingWith + File.separator + "imageSettings.xml";
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

		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("settings.txt"));

			// only one line must be
			while ((sCurrentLine = br.readLine()) != null) {
				break;
			}
			pathToImageMagic = sCurrentLine;


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return pathToImageMagic;
	}

	/**
	 * Start process of editing images
	 */
	public boolean doRunEditing() {
		try {
			WorkingWithImage wwi = new WorkingWithImage(
					getImageFetch(getXmlFile()));
			return wwi.run(getPhotos(), getPathToLibrary(),
					getPathToFolderWorkingWith());
		} catch (NotExistingXMLError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
