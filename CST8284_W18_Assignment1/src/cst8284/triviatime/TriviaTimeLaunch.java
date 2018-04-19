package cst8284.triviatime;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TriviaTimeLaunch extends Application {
	/**
	 * @Copyright Dave Houtman 2018. For use in Winter 2018 - CST8284 classes only
	 */

	private static BorderPane rootPane;

	@Override
	public void start(Stage primaryStage) {

		setRootPane("Welcome to Trivial Time");
		getRootPane().setTop(Controls.getMenuBar(primaryStage));
		Scene scene = new Scene(getRootPane(), 1024, 512);
		primaryStage.setTitle("Trivia Time");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void setRootPane(String logo) {

		Text text = new Text();
		text.setText(logo);
		text.setFill(Color.SLATEGRAY);
		text.setFont(Font.font(null, FontWeight.BOLD, 70));
		text.setTextAlignment(TextAlignment.CENTER);
		rootPane = new BorderPane(text);

	}

	public static BorderPane getRootPane() {
		return rootPane;
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}