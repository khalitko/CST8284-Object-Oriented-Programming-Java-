/**
 * File name: Controls.java
 * Author: modified by Khalid Hafid, ***-***-***
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: This file contains the logic to handle different menu controls in application
 */

package cst8284.triviatime;

import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id:
 *        20170620-1800
 * @see Controls
 * @see  <a href="http://www.oracle.com/technetwork/articles/java/index-137868.html">How to Write Doc Comments for the Javadoc Tool</a>
 * @see  <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Menu.html">Constructor Summary</a>
 */

public class Controls {

	/**
	 * MenuItem is intended to be used in conjunction with Menu to provide options
	 */
	private static MenuItem mnuItm;
	/**
	 * The Menu bar
	 */
	private static Menu mnu;
	/**
	 * The primary stage object
	 */
	private static Stage stage;
	/**
	 * the index of current question
	 */
	private static int currentQuestion = 0;

	/**
	 * BONUS QUESTION Using the getMnu method I am able to put all the menus in the
	 * getMenuBar method this way it saves a lot of white space and organizes it
	 * neatly with it's menu items
	 * 
	 * @param primaryStage Stage
	 * @return menuBar
	 */
	public static MenuBar getMenuBar(Stage primaryStage) {
		setStage(primaryStage);
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = getMnu("_File", getMnuItmNewGame(), getMnuItmExit());
		Menu settingsMenu = getMnu("_Settings", getMnuItmRandomize(), getMnuItmDifficulty(), getMnuItmByTopic());
		Menu helpMenu = getMnu("_Help", getMnuItmAbout());
		menuBar.getMenus().addAll(fileMenu, settingsMenu, helpMenu);
		return menuBar;
	}

	/**
	 * BONUS method constructing a string for menu name and menu items as methods in the menus
	 * 
	 * @param mnuName
	 *            create a string menu
	 * @param MenuItem...
	 *            mnuItems to construct its menu items
	 * @return mnu
	 */
	private static Menu getMnu(String mnuName, MenuItem... mnuItems) {
		mnu = new Menu(mnuName);
		mnu.getItems().addAll(mnuItems);
		return mnu;
	}

	/**
	 * BONUS This method accepts menu name, the key code for shortcut ( this key
	 * with CTRL key will be the shortcut) The event handler object which must be
	 * invoked when the menu item is pressed.
	 * 
	 * @param menuName
	 * @param KeyCode
	 *            code allows us to use a KeyCombination for keyboard shortcuts
	 * @param eventHandler
	 * @return mnuItm
	 */
	private static MenuItem getMnuItm(String menuName, KeyCode code, EventHandler<ActionEvent> eventHandler) {
		mnuItm = new MenuItem(menuName);
		mnuItm.setAccelerator(new KeyCodeCombination(code, KeyCombination.CONTROL_ANY));
		mnuItm.setOnAction(eventHandler);
		return mnuItm;
	}

	/**
	 * @param fileChooser
	 *            instantiate to set it's initial directory.
	 * @param selectedFile
	 * @return MenuItem returns the new game menu item
	 */
	private static MenuItem getMnuItmNewGame() {

		return getMnuItm("_New Game", KeyCode.N, (ActionEvent e) -> {

			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File("C:\\TriviaTime"));
			File selectedFile = fileChooser.showOpenDialog(null);

			/**
			 * This will check if the user has selected a file, the game proceeds only if
			 * user selects a file. If the user presses cancel button from file chooser, it
			 * will have no impact.
			 */
			if (selectedFile != null) {
				FileUtils.setQAArrayList(selectedFile.toString());

				createPane();
			}
		});
	}

	/**
	 * Sets the QApane in the center of the stage
	 */
	private static void createPane() {
		BorderPane bp = (BorderPane) getStage().getScene().getRoot();
		QAPane qa = new QAPane(Controls.getNextQA());
		bp.setCenter(qa.getQAPane());
	}

	/**
	 * @return MenuItem returns the exit menu item
	 */
	private static MenuItem getMnuItmExit() {
		return getMnuItm("_Exit", KeyCode.E, (ActionEvent e) -> Platform.exit());
	}

	/**
	 * @return MenuItem returns the about menu item
	 */
	private static MenuItem getMnuItmAbout() {
		/* From Marco Jakob, code.makery, */
		/* http://code.makery.ch/blog/javafx-dialogs-official/ */
		return getMnuItm("_About", KeyCode.A, (ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText("Khalid Hafid from sample code provided by Prof. Dave Houtman, ©2018");
			alert.showAndWait();
		});
	}

	/**
	 * @return MenuItem returns the randomize menu item
	 */
	private static MenuItem getMnuItmRandomize() {
		return getMnuItm("_Randomize Questions", KeyCode.R, (ActionEvent e) -> {
			currentQuestion = 0;
			FileUtils.randomize();
			createPane();
		});
	}

	/**
	 * @return MenuItem returns the sort by difficulty menu item
	 */
	private static MenuItem getMnuItmDifficulty() {
		return getMnuItm("_Increasing Difficulty", KeyCode.D, (ActionEvent e) -> {
			currentQuestion = 0;
			FileUtils.increasingDifficulty();
			createPane();
		});
	}

	/**
	 * @return MenuItem returns the sort by topic menu item
	 */
	private static MenuItem getMnuItmByTopic() {
		return getMnuItm("_Sort By Topic", KeyCode.T, (ActionEvent e) -> {
			currentQuestion = 0;
			FileUtils.sortByTopic();
			createPane();
		});
	}

	/**
	 * @param s the stage object
	 */
	private static void setStage(Stage s) {
		stage = s;
	}

	/**
	 * @return Stage the stage object
	 */
	public static Stage getStage() {
		return stage;
	}

	/**
	 * @return QA the next question
	 */
	public static QA getNextQA() {
		if (currentQuestion < FileUtils.getQAArrayList().size())
			return FileUtils.getQAArrayList().get(currentQuestion++);
		else
			return null;
	}

}
