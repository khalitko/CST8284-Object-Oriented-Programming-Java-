/**
 * File name: QARequirements.java
 * Author: modified by Khalid Hafid, ***-***-***
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: This is the abstract class for QA
 */
package cst8284.triviatime;

import java.io.Serializable;
/** 
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id: 20170620-1800
 * @see java.io
 */
public abstract class QARequirements implements Serializable {
	
	public static final long serialVersionUID = 1L;
	public abstract String getQuestion();
	public abstract void setQuestion(String question);
	
	public abstract String[] getAnswers();
	public abstract void setAnswers(String[] answers);
	
	public abstract String getExplanation();
	public abstract void setExplanation(String question);
	
	public abstract String getCategory();
	public abstract void setCategory(String category);
	
	public abstract int getDifficulty();
	public abstract void setDifficulty(int difficulty);
	
	public abstract int getPoints();
	public abstract void setPoints(int points);
	
	public abstract int getCorrectAnswerNumber();
	public abstract void setCorrectAnswerNumber(int correctAnswer);
	
	public abstract boolean isCorrect();
	public abstract void setResult(boolean b);

}
