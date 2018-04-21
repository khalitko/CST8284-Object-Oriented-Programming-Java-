/**
 * File name: TriviaTimeLaunch.java
 * Author: modified by Khalid Hafid, ***-***-***
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: This main entry point to application where application is launched
 */
package cst8284.triviatime;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/** 
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id: 20170620-1800
 * @see TriviaTimeLaunch
 * @see  <a href="https://docs.oracle.com/javase/8/javafx/api/javafx/animation/package-summary.html">Package javafx.animation</a>
 * @see  <a href="https://docs.oracle.com/javafx/2/animations/basics.htm">Creating Transitions and Timeline Animation in JavaFX </a>
 * @see  <a href="https://docs.oracle.com/javase/8/javafx/visual-effects-tutorial/basics.htm#BEIIJJJB">JavaFX: Transformations, Animations, and Visual Effects</a>
 * @see  <a href="https://docs.oracle.com/javafx/2/api/javafx/scene/effect/package-summary.html">Package javafx.scene.effect</a>
 */

public class TriviaTimeLaunch extends Application {
	/**  @Copyright Dave Houtman 2018.  For use in Winter 2018 - CST8284 classes only */
	
	/**
	 * The root pane of the application
	 */
	private static BorderPane rootPane;
	
	/**
	 * @param primaryStage - the primary stage of application
	 */
	@Override
	public void start(Stage primaryStage){	
	   // Display Splash Screen
	   setRootPane("Welcome to Trivial Time");
	   getRootPane().setTop(Controls.getMenuBar(primaryStage));
	   Scene scene =  new Scene(getRootPane(), 1024, 512);
	   primaryStage.setTitle("Trivia Time");
	   primaryStage.setScene(scene);
	   primaryStage.show();	
	}
	
	/**
	 * @param splashString - initialized root pane and sets the splash text
	 */
	public static void setRootPane(String splashString) {
		rootPane= new BorderPane();
		rootPane.setStyle("-fx-font-size: 16");
		Text text = new Text(splashString);
		Effect glow = new Glow(1.0);
		text.setFill(Color.CHOCOLATE);
		text.setStyle("-fx-font: 70px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		text.setEffect(glow);
		

		
		/**
		 * Animates the title with a fade, translate, scale transition and parallelizes them.
		 * @param text
		 */
		FadeTransition fadeTransition = 
	            new FadeTransition(Duration.millis(3000), text);
	        fadeTransition.setFromValue(1.0f);
	        fadeTransition.setToValue(0.3f);
	        fadeTransition.setCycleCount(2);
	        fadeTransition.setAutoReverse(true);
	        TranslateTransition translateTransition =
	            new TranslateTransition(Duration.millis(2000), text);
	        translateTransition.setFromX(0);
	        translateTransition.setCycleCount(2);
	        translateTransition.setAutoReverse(true);
	        RotateTransition rotateTransition = 
	            new RotateTransition(Duration.millis(3000), text);
	        rotateTransition.setByAngle(360);
	        rotateTransition.setCycleCount(2);
	        rotateTransition.setAutoReverse(true);
	        ScaleTransition scaleTransition = 
	            new ScaleTransition(Duration.millis(4000), text);
	        scaleTransition.setToX(2f);
	        scaleTransition.setToY(2f);
	        scaleTransition.setCycleCount(2);
	        scaleTransition.setAutoReverse(true);
	        ParallelTransition parallelTransition;
	        parallelTransition = new ParallelTransition();
	        parallelTransition.getChildren().addAll(
	                fadeTransition,
	                translateTransition,
	                rotateTransition,
	                scaleTransition
	        );
	        parallelTransition.setCycleCount(1);
	        parallelTransition.play();
		
		rootPane.setCenter(text);
	}
	
	/**
	 * @return BorderPane - returns the root pane
	 */
	public static BorderPane getRootPane() {return rootPane;}

	/**
	 * main method
	 * @param args - command line args
	 */
	public static void main(String[] args){
		Application.launch(args);
	}
	
}
