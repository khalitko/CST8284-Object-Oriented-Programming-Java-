/**
 * File name: FileUtils.java
 * Author: modified by Khalid Hafid, 040-566-282
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: This file contains the logic to handle different menu controls in application
 * Class list: FileUtils, QADifficultyComparator, QADifficultyComparator 
 * @see lecture notes
 */
package cst8284.triviatime;

import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id: 20170620-1800
 * @see FileUtils
 */

public class FileUtils {
	/**
	 * The arraylist which contains all QAs
	 */
	private static ArrayList<QA> qaAL;

	/**
	 * sets Title and creates new ExtensionFilters 
	 * @param primaryStage Stage
	 * @return trivFile Trivia File
	 */
	public static File getFileHandle(Stage primaryStage) {
		FileChooser fc = new FileChooser();
		fc.setTitle("Open Trivia File");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Trivia Files", "*.trivia"),
				new ExtensionFilter("All Files", "*.*"));
		File trivFile = fc.showOpenDialog(primaryStage);
		return (trivFile);
	}

	/**
	 * reading the QA files of any size
	 * @param absPath String
	 * 
	 * try-with-resources FileInputStream, ObjectInputStream
	 * EOFException e if input stream reaches end of file
	 * IOException the stream has been closed and the contained input stream 
	 * does not support reading after close, or another I/O error occurs
	 */
	public static void setQAArrayList(String absPath) {
		qaAL = new ArrayList<QA>();
		if (fileExists(absPath)) {
			try (FileInputStream fis = new FileInputStream(absPath);
					ObjectInputStream ois = new ObjectInputStream(fis);) {
				while (true)
					qaAL.add((QA) (ois.readObject()));

			} catch (EOFException e) {
			} catch (IOException | ClassNotFoundException e) {
			}
		} else
			qaAL = null;
	}

	/**
	 * @return qaAL The ArrayList with QA
	 */

	public static ArrayList<QA> getQAArrayList() {
		return qaAL;
	}

	/**
	 * @param f file handle
	 * @return boolean - true if file exist
	 */
	public static boolean fileExists(File f) {
		return (f != null && f.exists() && f.isFile() && f.canRead() && (f.length() > 2));
	}

	/**
	 * @param s file name
	 * @return boolean - true if file exist with given type
	 */
	public static boolean fileExists(String s) {
		return (fileExists(new File(s)));
	}

	/**
	 * @param f file handle
	 * @return String - absolute path of file
	 */
	public static String getAbsPath(File f) {
		return f.getAbsolutePath();
	}

	/**
	 * Randomize the QA list This uses the static method shuffle of java.util
	 * Collections class to shuffle the QA elements inside the array list.
	 */
	public static void randomize() {
		Collections.shuffle(qaAL);
	}

	/**
	 * Sort QA list with increasing difficulty This uses the static method sort of
	 * java.util.Collections to sort with difficulty, it uses a difficulty
	 * comparator which will help it to sort in terms of difficulty
	 */
	public static void increasingDifficulty() {
		Collections.sort(qaAL, new QADifficultyComparator());
	}

	/**
	 * Sort QA list with topic This uses the static method sort of
	 * java.util.Collections to sort with difficulty, it uses a category based
	 * comparator which will help it to sort
	 */
	public static void sortByTopic() {
		Collections.sort(qaAL, new QATopicComparator());
	}

	/**
	 * This class implements Comperator's compare method. we override it to get
	 * sorted by difficulty
	 */
	static class QADifficultyComparator implements Comparator<QA> {

		/**
		 * @param q1 Qa
		 * @param q2 QA
		 * @returns -1
		 * @returns 1
		 * @return 0
		 * returns the difference between difficulty (if, else if, else)
		 */

		@Override
		public int compare(QA qa1, QA qa2) {
			// System.out.println(qa1 + " - " + qa2);
			if (qa1.getDifficulty() < qa2.getDifficulty())
				return -1;
			else if (qa1.getDifficulty() > qa2.getDifficulty())
				return 1;
			else
				return 0;
		}
	}

	/**
	 * this class implements Comperator's compare method. we override it to get
	 * sorted by T
	 */

	static class QATopicComparator implements Comparator<QA> {

		/**
		 * @param q1 Qa
		 * @param q2 QA
		 * returns the difference between topic as a string
		 */
		@Override
		public int compare(QA qa1, QA qa2) {

			return qa1.getCategory().compareTo(qa2.getCategory());

		}

	}
}
