package cst8284.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.text.Text;

public class LoadWordsAsString extends LoadWords{
	private String longStr;
	
	public void setLongStr(String str) {
		longStr=str;
	}
	
	public String getLongStr() {
		return longStr;
	}
	
	@Override
	public Text getFileContents(File f) {
		try(Scanner fileIn = new Scanner (f);){
			Counters.resetCtr();
			String myString= "";
			while (fileIn.hasNext()) {
				myString+=(fileIn.next()+"\n");
				Counters.getNextCtr();
			}
			fileIn.close();
			setLongStr(myString);
			

		} catch (FileNotFoundException e) {

		}

		return new Text(getLongStr());

	}


}