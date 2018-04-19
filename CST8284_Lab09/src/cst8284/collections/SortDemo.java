package cst8284.collections;

import javafx.application.Application;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SortDemo extends Application {

	private static Stage pStage;

	// Note: Only of use if you are attempting Bonus B:
	private static final char[] scrabbleValues = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4,
			8, 4, 10 }; // value of each letter in the game Scrabble, i.e. 'a'=1, 'b'=3, etc.

	
	@Override
	public void start(Stage primaryStage) {

		pStage = primaryStage;
		ObservableList<String> obsList = FXCollections.observableList(getFileContents());
		ListView<String> outputList = new ListView<String>(obsList);
		outputList.setPrefWidth(200);

		BorderPane scenePane = new BorderPane();
		scenePane.setLeft(outputList);

		Button btnAlpha = new Button("Alphabetical Order");
		btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	Collections.sort(obsList);
		    }
		});
		

		Button btnWordLength = new Button("     Word Length    ");
		btnWordLength.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	SortListByContentLength sortListByContentLength= new SortListByContentLength();
		    	Collections.sort(obsList,sortListByContentLength);
		    }
		});

		// Bonus A TODO: write the EventHandler that sorts the word length as a
		// single line of code containing two lambda expressions. The first
		// responds to the ActionEvent() and provides the code to override
		// the handle() method, while the second overrides Comparable<Stings>'s
		// compare() method. As is often the case where lambda expressions are
		// used to execute only a single line of code, you should not need to
		// create any additional methods or classes to perform the sort().

				
		// Bonus B TODO: Add a button and methods/classes that sort the
		// observableList by Scrabble value

		Button btnReverse = new Button("   Reverse Order    ");
		btnReverse.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	Collections.reverse(obsList);
		    }
		});

		VBox vb = new VBox();
		vb.getChildren().addAll(btnAlpha, btnWordLength, btnReverse);
		scenePane.setRight(vb);

		Scene scene = new Scene(scenePane, 640, 480);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome to WordSort");
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private ArrayList<String> getFileContents() {
		ArrayList<String> wordList = new ArrayList<>();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("C:\\Users\\khalitko\\Google Drive\\Winter Semester\\CST8284 Programming\\CST8284_Lab09"));
		fileChooser.setTitle("Select a wordlist file");
		File file = fileChooser.showOpenDialog(pStage);
		if (file != null) {
			try {
				// converts selected file to inputstream object
				InputStream fileInputStream = new FileInputStream(file);//to read a stream of raw bytes such as image, characters! etc.
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
				// read the content of the file line by line
				// use BufferedReader to provide efficient reading characters, lines, arrays
				// https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html
				// https://docs.oracle.com/javase/7/docs/api/java/io/InputStreamReader.html
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					wordList.add(line);
				}
				bufferedReader.close();
			} catch (IOException e) {
			}

		}
		return wordList;
	}

	//Custom Comparator class for sorting word by length
	public class SortListByContentLength implements Comparator<String>{

	    @Override
	    public int compare(String item1, String item2) {
	    return item1.length() - item2.length();
	    }
	    
	}
}
