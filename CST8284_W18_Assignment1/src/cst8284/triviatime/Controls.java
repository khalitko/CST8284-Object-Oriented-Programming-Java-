package cst8284.triviatime;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Controls {

	/**** Generic Menu/Menu Item Properties ****/
	private static MenuItem mnuItm;
	private static Menu mnu;
	private static Stage stage;
	private static int currentQuestion = 0;
	private static Button nextQ = new Button("Next Question");
	private static int numObjects = 7;

	/***************** MenuBar *****************/

	public static MenuBar getMenuBar(Stage primaryStage) {
		MenuBar menuBar = new MenuBar();
		stage = primaryStage;
		menuBar.getMenus().addAll(getMnuFile(), getMnuSettings(), getMnuHelp());
		return menuBar;
	}

	/******************* Menu ******************/

	private static Menu getMnuFile() {
		mnu = new Menu("_File");
		mnu.getItems().addAll(getMnItmNewGame(), getMnuItmExit());
		return mnu;
	}

	private static Menu getMnuSettings() {
		return mnu = new Menu("_Settings");
	}

	private static Menu getMnuHelp() {
		mnu = new Menu("_Help");
		mnu.getItems().addAll(getMnuItmAbout());
		return mnu;
	}

	/***************** MenuItems *****************/

	private static MenuItem getMnItmNewGame() {
		mnuItm = new MenuItem("New Game");
		
		mnuItm.setOnAction((ActionEvent e) -> {
			currentQuestion = 0;
			Controls.getNextQnBtn().setVisible(true); //forces the visibility to be true since I set it false at 
													  //in the Results class so every time NewGame is selected its visible
			FileUtils.setQAArray("C://TriviaTime/ComputerTrivia_Java100.trivia", numObjects);
			BorderPane pane = updateCenterPane();
			pane.setBottom(getNextQuestionPane());
			
			
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmExit() {
		mnuItm = new MenuItem("_Exit");
		mnuItm.setOnAction(e -> {
			Platform.exit();
		});
		return mnuItm;
	}

	private static MenuItem getMnuItmAbout() {

		mnuItm = new MenuItem("About");
		mnuItm.setOnAction((ActionEvent e) -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("About");
			alert.setHeaderText("About Trivia Time");
			alert.setContentText("Author: Khalid Hafid");
			alert.showAndWait();
		});
		return mnuItm;
	}

	public static void setStage(Stage s) {
		stage = s;
	}

	public static Stage getStage() {
		return stage;
	}

	public static HBox getNextQuestionPane() {

		nextQ.setOnAction((ActionEvent e) -> {
			currentQuestion++;
			if (currentQuestion < numObjects) {// moves on to the next Q as long as it doesn't exceed the # of Q
				updateCenterPane();
			} else { // if exceeded result pane shows up
				BorderPane pane = (BorderPane) stage.getScene().getRoot();
				QA[] qaAr = FileUtils.getQAArray();
				pane.setCenter(Results.createResultPane(qaAr));
					
			}
		});

		HBox hbox = new HBox(nextQ);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);
		hbox.setPadding(new Insets(50, 50, 50, 50));
		hbox.setStyle("-fx-font: 20 Garamond;");
		return hbox;
	}
	
	public static Button getNextQnBtn() {
		return nextQ;
	}
	private static BorderPane updateCenterPane() { // needed this to cast the pane on the stage so it finally showed up
		BorderPane pane = (BorderPane) stage.getScene().getRoot();
		QA[] qaAr = FileUtils.getQAArray(); 
		QA currentQn = qaAr[currentQuestion]; 
		QAPane qaPane = new QAPane(currentQn);
		pane.setCenter(qaPane.getQAPane());
		
		return pane;
	}

}