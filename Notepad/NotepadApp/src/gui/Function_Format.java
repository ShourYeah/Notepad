package gui;

import java.awt.Font;

public class Function_Format {
GUI gui;
Font arial, comicSansMS, timesNewRoman;
String selectedFont;

public Function_Format(GUI gui) {
	this.gui= gui;
	
	
}

public void wordWrap() {
	if(gui.wordWrapOn==false) {
		gui.wordWrapOn= true; //by default it is fault in GUI.java
		gui.textArea.setLineWrap(true); //make word wrap happen
		gui.textArea.setWrapStyleWord(true); //so that line break do not happen in the middle of a word
		gui.iWrap.setText("Word Wrap: On");
	}
	// in case the wordWrap is already on:
	else if(gui.wordWrapOn==true) {
		gui.wordWrapOn= false; 
		gui.textArea.setLineWrap(false); 
		gui.textArea.setWrapStyleWord(false);
		gui.iWrap.setText("Word Wrap: Off");
	}
}

public void createFont(int fontSize) {
    arial = new Font("Arial", Font.PLAIN, fontSize); //we want font side to be taken from user in the option
    comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
    timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
    
    setFont(selectedFont);
}

public void setFont(String font) {
	
	selectedFont= font;
	switch(selectedFont) {
	case "Arial" : 
		gui.textArea.setFont(arial);
		break;
	case "Comic Sans MS" : 
		gui.textArea.setFont(comicSansMS);
		break;
	case "Times New Roman" : 
		gui.textArea.setFont(timesNewRoman);
		break;
	}
	
}


}
