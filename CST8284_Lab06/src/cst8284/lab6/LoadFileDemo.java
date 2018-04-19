package cst8284.lab6;

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class LoadFileDemo extends Application {
	
	private Stage stage;
        
	@Override
	public void start(Stage pStage) {	
		setStage(pStage);
		
		BorderPane rootPane = new BorderPane();
		rootPane.setLeft(getWordListPane("StringBuilder", new LoadWordsAsStringBuilder()));
		rootPane.setRight(getWordListPane("String", new LoadWordsAsString()));
		
		getStage().setScene(new Scene(rootPane));
		getStage().setTitle("Welcome to WordDump, a Scrollable List of Almost 80,000 Words");
		getStage().show();	
	}
	
	private VBox getWordListPane(String btnLabel, LoadWords textString) {
		
		ScrollPane spWords = new ScrollPane();
		spWords.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		spWords.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		spWords.setPrefSize(280, 320);
		
				
		TextArea txtAreaFileInfo = new TextArea();
		txtAreaFileInfo.setMaxWidth(280);
		txtAreaFileInfo.setPrefRowCount(8);
		
				
		Button btnLoadWords = new Button("Load WordList Using "+btnLabel);
		btnLoadWords.setMinWidth(spWords.getWidth());

		btnLoadWords.setOnAction(e -> {
			
						double loadTime = getLoadTime(textString, spWords);
						String diagnostics = FileInfos.getFileInfo(FileInfos.getFileHandle(), loadTime); 
						txtAreaFileInfo.clear();  // clear textarea of previous information
						txtAreaFileInfo.setText(diagnostics);

		});
 
	
		
		
		VBox vbxWordList = new VBox();
		
		vbxWordList.getChildren().addAll(spWords,btnLoadWords,txtAreaFileInfo);
		return vbxWordList;
				
	}
	
	private double getLoadTime(LoadWords inputString, ScrollPane outputNode) {
		//clear the ScrollPane of any text currently loaded
		outputNode.setContent(null);
		
		// get a handle to the file containing the word list
		File f = FileInfos.getFileHandle(getStage());
		
		// get the current time, load the word list, and return the elapsed time
		if (FileInfos.isFileReadable(f)) {
			long startTime = System.currentTimeMillis();
			outputNode.setContent(inputString.getFileContents(f)); 
			return (System.currentTimeMillis()-startTime)/1000.0;
		}
		return(-1);	
	}

	private void setStage(Stage s) {stage = s;}
	public Stage getStage() {return stage;}
	
	public static void main(String[] args) {
		Application.launch(args);
	}		
}