/**
 * File name: ResultsPane.java
 * Author: modified by Khalid Hafid, 040-566-282
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: The final result of the QA is displayed using this pane
 */
package cst8284.triviatime;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/** 
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id: 20170620-1800
 * @see ResultsPane
 */
public class ResultsPane {
	/**
	 * @return ScrollPane- the results pane
	 */
	public static ScrollPane getResults() {
	    VBox results = new VBox();
	    results.setMinWidth(300);
	    results.setStyle("-fx-font: 16px Garamond; -fx-stroke: black; -fx-stroke-width: 1;");
	    
	    /**
	     * calculate correct answers and marks
	     */
	    int questionNum = 1, correctAns = 0;
		for (QA qa: FileUtils.getQAArrayList()) { 
		   results.getChildren().add(new Text("Question " + questionNum++ + 
			  ".  " + (qa.isCorrect()?"Right":"Wrong")));		
		   correctAns += qa.isCorrect()?1:0;
		}
		
		Label marks = new Label();
		marks.setText("   Results: " + 
		correctAns + "/" + FileUtils.getQAArrayList().size());
		results.getChildren().add(marks);
		results.setPadding(new Insets(100, 0, 0, 450));
		marks.setFont(new Font("Garamond", 20));
		
		
		ScrollPane spResults = new ScrollPane();
		spResults.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
	
		spResults.setCenterShape(true);
		spResults.setContent(results);
		return spResults;
	}
}
