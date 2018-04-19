/**
 * File name: QAPane.java
 * Author: modified by Khalid Hafid, 040-566-282
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: This is the question answer pane where question, options, this is my answer button
 * are hosted
 */
package cst8284.triviatime;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/** 
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id: 20170620-1800
 * @see QAPane
 */
public class QAPane {

	/**
	 * The radio button array for options
	 */
   private RadioButton[] rbAr;
   /**
    * The final qa pane
    */
   private static VBox qaPane;
   /**
    * That is my answer button
    */
   private static Button thatsMyAnsBtn;
   /**
    * Next qn button
    */
   private static Button btnNext;
 
   /**
    * Constructor
    * @param qa - the QA object will initilize the radio button array
    * and add components to qa pane
    */
   public QAPane(QA qa) {
	   
	   HBox questionBox = new HBox(); 
	   questionBox.getChildren().add(new Label(qa.getQuestion()));
	   
	   VBox explanationBox = new VBox(); 
	   explanationBox.setPrefHeight(100);
	   explanationBox.setAlignment(Pos.CENTER);
	   
	   questionBox.setPadding(new Insets(75, 0, 0, 0));
	   questionBox.setAlignment(Pos.CENTER);
	   
	   thatsMyAnsBtn= new Button("That's my answer");
	   btnNext = new Button("  Next Question   ");
		
	   qaPane = new VBox();
	   qaPane.getChildren().addAll(
			questionBox, 
			getAnswerPane(qa.getAnswers()), 
			explanationBox, 
			getThatsMyAnswerBox(qa, explanationBox),
			getNextQuestionBox());
	   setQAPane(qaPane);
   }
   
   /**
    * Return the button box
    * @param qa
    * @param explanationBox
    * @return HBox - that is my answer button inside a box
    */
   private HBox getThatsMyAnswerBox (QA qa, VBox explanationBox) {
	   
	   HBox thatsMyAnsBox = new HBox();
	   
	   thatsMyAnsBtn.setOnAction((e)->{
		   if (getRadioButtonSelected() < 0) {
			  Alert alert = new Alert(AlertType.WARNING, "Must choose an answer first", ButtonType.OK);
		      alert.showAndWait();
		   }
		   else {
			  qa.setResult(isAnswerCorrect(qa));
		      explanationBox.getChildren().add(new Label(qa.getExplanation()));
		      explanationBox.getChildren().add(new Label(qa.getDifficulty()+""));
		      explanationBox.getChildren().add(new Label(qa.getCategory()));
		      thatsMyAnsBtn.setDisable(true);
		      btnNext.setDisable(false);
		   }
	   });
	   thatsMyAnsBox.getChildren().add(thatsMyAnsBtn);
	   thatsMyAnsBox.setAlignment(Pos.CENTER);
	   return thatsMyAnsBox;
    }
   
   /**
    * Returns the next qn button box
    * @return HBox
    */
	private HBox getNextQuestionBox() {
		
	   HBox hbxNextQuestion = new HBox(); hbxNextQuestion.setPrefHeight(200);
	   hbxNextQuestion.setAlignment(Pos.CENTER_RIGHT);
	   hbxNextQuestion.getChildren().add(btnNext); 
	   
	   QA qa = Controls.getNextQA();
	   if (qa != null){ // Still questions to load?
	      btnNext.setDisable(true);
	      btnNext.setOnAction((e)->{    
	         QAPane qaPane = new QAPane(qa);
		     TriviaTimeLaunch.getRootPane().setCenter(qaPane.getQAPane());
		     thatsMyAnsBtn.setDisable(false);	  
	      });   
	   }
	   else { //final question
		  btnNext.setText("Check Results");
		  btnNext.setOnAction((e) -> 
			  TriviaTimeLaunch.getRootPane().setCenter(ResultsPane.getResults())
		  ); 
	   } 
	   return hbxNextQuestion;
	}
	
	/**
	 * The answer pane is created with possible options
	 * @param answerStrAr
	 * @return VBox
	 */
   private VBox getAnswerPane(String[] answerStrAr){	   
	  VBox answerBox = new VBox();
	  answerBox.setPadding(new Insets(0, 0, 0, 350));
	  rbAr = new RadioButton[answerStrAr.length];
      int rbCtr = 0; final ToggleGroup tg = new ToggleGroup();
      for (String ans: answerStrAr){
         rbAr[rbCtr] = new RadioButton(ans);
         rbAr[rbCtr].setToggleGroup(tg);
         answerBox.getChildren().add(rbAr[rbCtr++]);
      } 
      return answerBox;
   }
	
   /**
    * returns the index of radio button selected
    * @return
    */
   private int getRadioButtonSelected(){
      int btnCtr = 1;  
      if (rbAr != null)
         for (RadioButton rb: rbAr){
            if (rb.isSelected()) break;
            btnCtr++;
         }
      return (btnCtr > rbAr.length)? -1: btnCtr;
   }
   
   /**
    * returns true if right answer
    * @param qa
    * @return boolean
    */
   private boolean isAnswerCorrect(QA qa) {
	   return (qa.getCorrectAnswerNumber() == getRadioButtonSelected());
   }
   
   /**
    * sets the QA pane
    * @param vb
    */
   private void setQAPane(VBox vb) {QAPane.qaPane = vb;}
   /**
    *  returns the qa pane
    * @return VBox
    */
   public VBox getQAPane() {return qaPane;}
   
}
