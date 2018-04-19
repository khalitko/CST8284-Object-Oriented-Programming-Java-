package cst8284.lab6;
import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileInfos {
	
	private static String fileInfoStr;
	private static File fileHandle;
	
	public static String getFileInfo(File f){
	   if (isFileReadable(f)){
		  fileInfoStr = "File Path: " + f.getPath() + "\n";
		  fileInfoStr += "File Name: " + f.getName() + "\n";
		  fileInfoStr += "File Read Status: " + f.canRead() + "\n";
		  fileInfoStr += "File Write Status: " + f.canWrite() + "\n";
		  fileInfoStr += "Is File Hidden: " + (f.isHidden()?"yes":"no") + "\n";
		  fileInfoStr += "Length: " + f.length() + " bytes" + "\n";
		  if (Counters.getCurrentCtr() > 0)
		     fileInfoStr += "Total Number of Words: " + Counters.getCurrentCtr() + "\n";
	   }
	   else
		   fileInfoStr = f.getName() + " does not exist or is not a readable file";
	   return fileInfoStr;
	}
	
	public static String getFileInfo(File f, double elapsedTime) {
		return getFileInfo(f) + "Load Time: " + (elapsedTime<0?"Unknown":elapsedTime + " sec.");
	}
	
	public static String getFileInfoString(){
		return getFileInfoString(fileHandle);
	}
	
	public static String getFileInfoString(File f) {
		return fileInfoStr;
	}
	
	public static void setFileHandle(Stage s) {
		setFileHandle(s);
	}
	
	public static void setFileHandle(File f){
		fileHandle = f;
	}
	
	public static File getFileHandle(Stage stage) {
		// Based on source code from: 
		// Redko, Alla.  Using JavaFX UI Control: 26 File Chooser.
		// https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Word File");
		fileChooser.getExtensionFilters().addAll(
		     new ExtensionFilter("WordList Files", "*.txt"),
		     new ExtensionFilter("All Files", "*.*"));
		File f = fileChooser.showOpenDialog(stage);
		setFileHandle(f);
		return f;		
	}
	
	public static File getFileHandle() {
		return fileHandle;
	}
	
	public static boolean fileExists(File f) {
		return (f!=null && f.exists() && f.isFile());
	}
	
	public static boolean isFileReadable(File f) {
		return (fileExists(f) && f.canRead());
	}
	
	
}
