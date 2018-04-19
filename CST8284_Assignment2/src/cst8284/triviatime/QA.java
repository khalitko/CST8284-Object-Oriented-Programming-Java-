/**
 * File name: QA.java
 * Author: modified by Khalid Hafid, 040-566-282
 * Course: CST8284 – OOP 
 * Assignment: 2
 * Date: 18/4/2018
 * Lab Professor: RAYMOND PETERKIN
 * Purpose: This file contains the fields of a question
 */

package cst8284.triviatime;

/**
 * @author Khalid Hafid
 * @version 1.0
 * @since JDK: 1.8.0_161, Eclipse IDE Version: Oxygen Release (4.7.0), Build id: 20170620-1800
 * @see QA
 */
@SuppressWarnings("serial")
public class QA extends QARequirements {

	/**
	 * question, the category to which it belong to, explanation of question
	 */
	private String question, category, explanation;
	/**
	 * The correct answer of question, points and difficulty of question
	 */
	private int correctAnswer, points, difficulty;
	/**
	 * list of possible answers
	 */
	private String[] answers;
	/**
	 * is the answer correct
	 */
	private boolean result;
	
	/**
	 * Returns String - the question
	 */
	public String getQuestion(){return question;}

	/**
	 * @param question - the question to set
	 */
	public void setQuestion(String question){this.question = question;}
	/**
	 * Returns String[] - the answers
	 */
	public String[] getAnswers(){return answers;}
	/**
	 * @param answers - the answers for the question
	 */
	public void setAnswers(String[] answers){
		this.answers = answers;
//		this.answers = new String[answers.length];
//		for (int i=0; i < answers.length; i++) this.answers[i]=answers[i];
	}
	
	/**
	 * Returns String - the explanation
	 */
	public String getExplanation() {return explanation;}
	/**
	 * @param explanation - the explanation to set
	 */
	public void setExplanation(String explanation) {this.explanation = explanation;}
	
	/**
	 * Returns String - the category
	 */
	public String getCategory(){return category;}
	/**
	 * @param category - the category to set
	 */
	public void setCategory(String category){this.category = category;}
	
	/**
	 * Returns int - the difficulty of question
	 */
	public int getDifficulty(){return difficulty;}
	/**
	 * @param difficulty - the difficulty to set
	 */
	public void setDifficulty(int difficulty){this.difficulty = difficulty;}
	
	/**
	 * Returns int - points
	 */
	public int getPoints(){return points;}
	/**
	 * @param points - the points for question
	 */
	public void setPoints(int points){this.points = points;}
	
	/**
	 * Returns int - the correct answer number
	 */
	public int getCorrectAnswerNumber(){return correctAnswer;}
	/**
	 * @param correctAnswer - the answer number to set
	 */
	public void setCorrectAnswerNumber(int correctAnswer){this.correctAnswer = correctAnswer;}
	
	/**
	 * @param b - the result to set
	 */
	public void setResult(boolean b){result = b;}
	/**
	 * Returns boolean - is correct answer
	 */
	public boolean isCorrect(){return result;}
	
	public QA(String q, String[] a, String category, String explanation, int diff, int points, int correctAnswer){
		setQuestion(q);
		setAnswers(a);
		setCategory(category);
		setExplanation(explanation);
		setDifficulty(diff);
		setPoints(points);
		setCorrectAnswerNumber(correctAnswer);
	}
	
	
}
