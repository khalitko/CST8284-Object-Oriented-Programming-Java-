package cst8284.lab6;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.text.Text;

public class LoadWordsAsStringBuilder extends LoadWords {
private StringBuilder longStrBldr= new StringBuilder();
	
@Override
	public Text getFileContents(File f) {
		try(Scanner fileIn = new Scanner (f);){
			Counters.resetCtr();
			while (fileIn.hasNext()) {
				longStrBldr.append(fileIn.next()+"\n");
				Counters.getNextCtr();
			}
			fileIn.close();
			
			

		} catch (FileNotFoundException e) {

		}

		return new Text(longStrBldr.toString());
		

	}

}