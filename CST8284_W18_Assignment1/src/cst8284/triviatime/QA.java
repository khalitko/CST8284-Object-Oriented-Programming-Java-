package cst8284.triviatime;

public class QA extends QARequirements {

	
	private String question, category, explanation;
	private int correctAnswer, points, difficulty;
	private String[] answers;
	private boolean result;

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String[] getAnswers() {
		return answers;
	}

	@Override
	public void setAnswers(String[] answers) {
		this.answers = new String[answers.length];
		for (int i = 0; i < answers.length; i++)
			this.answers[i] = answers[i];

	}

	@Override
	public String getExplanation() {
		return explanation;
	}

	@Override
	public void setExplanation(String question) {
		this.explanation = question;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;

	}

	@Override
	public int getDifficulty() {
		return difficulty;
	}

	@Override
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int getCorrectAnswerNumber() {
		return correctAnswer;
	}

	@Override
	public void setCorrectAnswerNumber(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public boolean isCorrect() {
		return result;
	}

	@Override
	public void setResult(boolean b) {
		result = b;
	}

	public QA(String q, String[] a, String catG, String exp, int difficulty, int points, int correctAnswer) {
		setQuestion(q);
		setAnswers(a);
		setCategory(catG);
		setExplanation(exp);
		setDifficulty(difficulty);
		setPoints(points);
		setCorrectAnswerNumber(correctAnswer);

	}

}
