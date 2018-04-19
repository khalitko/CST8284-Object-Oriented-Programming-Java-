package cst8284.triviatime;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class QAPane {
	RadioButton[] rbAr;
	private VBox qaPane;
	private VBox answerBox;
	private Label actualAnswerLabel;
	private String[] answers;
	private ToggleGroup group;
	private Button answerSubmitButton;

	public QAPane(QA qa) {
		qaPane = new VBox();
		this.answers = qa.getAnswers();
		this.actualAnswerLabel = new Label();
		this.answerSubmitButton = new Button("That's my answer");
		answerSubmitButton.setDisable(true);
		Label questionLbl = new Label(qa.getQuestion());

		qaPane.setAlignment(Pos.CENTER);
		questionLbl.setPrefHeight(50);
		answerSubmitButton.setStyle("-fx-font: 20 Garamond; -fx-base: #f4f4ff;");
		actualAnswerLabel.setStyle("-fx-font: 18 Garamond; -fx-base: #f4f4ff;");
		questionLbl.setStyle("-fx-font: 20 Garamond; -fx-base: #f4f4ff;");

		this.answerSubmitButton.setOnAction((ActionEvent e) -> { // displays both conclusion and enables nextQ
			this.updateUserAnswer(qa); 
			Controls.getNextQnBtn().setDisable(false);

		});

		qaPane.getChildren().addAll(questionLbl, //correctly ordering the children for it's parent
									getAnswerPane(this.answers), 
									actualAnswerLabel, 
									answerSubmitButton);
									Controls.getNextQnBtn().setDisable(true);

	}

	public VBox getAnswerPane(String[] ansStrAr) {
		group = new ToggleGroup(); // used toggle to reference all the buttons as one unit and only can be clicked at a time

		answerBox = new VBox();
		rbAr = new RadioButton[answers.length];
		for (int i = 0; i < answers.length; i++) {
			rbAr[i] = new RadioButton(ansStrAr[i]);
			rbAr[i].setFont(new Font("Garamond", 16));
			answerBox.getChildren().add(rbAr[i]);
			rbAr[i].setToggleGroup(group);
			
			final int as = i;
			rbAr[i].setOnAction(new EventHandler<ActionEvent>() { // disables submit button until an answer is chosen
		         @Override 
		         public void handle(ActionEvent arg0) {
					if (rbAr[as].isSelected()) {
						answerSubmitButton.setDisable(false);
					}
				}
			});

		}
		answerBox.setPadding(new Insets(0, 0, 0, 322));

		return answerBox;
	}

	public int getRadioButtonSelected() { 
		int btnCtr = 1;					  
		if (rbAr != null) {
			for (RadioButton rb : rbAr) {
				if (rb.isSelected())
					break;
				btnCtr++;
			}
		}
		return (btnCtr > answers.length) ? -1 : btnCtr;
	}

	private void updateUserAnswer(QA qa) {

		if (getRadioButtonSelected() == qa.getCorrectAnswerNumber()) { // outputs right or wrong w\ explanation 
			qa.setResult(true);										   //in green and red respectively
			actualAnswerLabel.setText("Right!");
			actualAnswerLabel.setTextFill(Color.web("#00a10d"));
		} else {
			qa.setResult(false);
			actualAnswerLabel.setText("Wrong! " + qa.getExplanation());
			actualAnswerLabel.setTextFill(Color.web("#a20000"));
		}

	}

	private void setQAPane(VBox vb) {
		this.qaPane = vb;
	}

	public VBox getQAPane() {
		return qaPane;
	}
}