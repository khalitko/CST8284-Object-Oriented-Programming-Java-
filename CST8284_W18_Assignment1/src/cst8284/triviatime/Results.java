package cst8284.triviatime;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Results {
	
	public static VBox createResultPane(QA[] qaAr) {
		VBox resultBox = new VBox();
				
		 int questionNum = 1, correctAns = 0;
			for (QA qa: FileUtils.getQAArray()) { 
			   resultBox.getChildren().add(new Text("  " + questionNum++ + 
				  ".  " + (qa.isCorrect()?"Right":"Wrong")));		
			   correctAns += qa.isCorrect()?1:0;
			}
		Controls.getNextQnBtn().setVisible(false);// I set it visible in the result pane since its useless
		Label pointslabel = new Label();
		pointslabel.setText("Results:" + 
				correctAns + "/" + FileUtils.getQAArray().length);
		resultBox.getChildren().add(pointslabel);
		resultBox.setAlignment(Pos.CENTER);
		pointslabel.setFont(new Font("Garamond", 14));
		return resultBox;
	}
	


}