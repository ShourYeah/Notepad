package gui;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	GUI gui; //recieve gui class as gui
	String fileName;
	String fileAddress;
	
	 public Function_File(GUI gui) {
		 
		 this.gui =gui; //now we can access everything from GUI class from here
		 
	 }
	 
	 public void newFile() {
		 gui.textArea.setText(""); //when new file is created it gives empty text area
		 gui.window.setTitle("New");
		 fileName= null; // this and below line makes sure when you create a new file their name and address already do nor exist and are only chosen by user
		 fileAddress= null;
	 }
	 
	 public void open() {
		 
		 FileDialog fd= new FileDialog(gui.window, "Open", FileDialog.LOAD); //here Open represents what to display at the top of the file explorer
		 fd.setVisible(true);
		 
		 if(fd.getFile()!=null) {
			 fileName = fd.getFile(); //with this line you can get the file name of the file you clicked
			 fileAddress = fd.getDirectory(); //Gets the file address of the file
			 gui.window.setTitle(fileName); //helps to get the same title on the header of the file you choose
			 
			 }
		 
		 try {
			 BufferedReader br = new BufferedReader(new FileReader(fileAddress+ fileName)); //we need an address to read a file
			 gui.textArea.setText("");
			 String line = null;
			 
			 while((line = br.readLine())!=null) {
				 gui.textArea.append(line + "\n");
			 }
			 br.close();
		 } catch(Exception e) {
			 System.out.println("FILE NOT OPENED!!!");
		 }
		 
     
		 
	 }
	 
	 public void save() {
		 
		 if(fileName == null ) {
			 saveAs(); // using saveAs because this file is not existing yet.
			 
		 }
		 
		 else {
			 try {
				 FileWriter fw = new FileWriter(fileAddress +fileName);
				 fw.write(gui.textArea.getText());
				 gui.window.setTitle(fileName); //set the new filename on the window
				 fw.close();
				 
			 } catch(Exception e) {
				 
				 System.out.println("SOMETHING WENT WRONG!!!");
			 }
		 }
		 
	 }
	 
	 public void saveAs(){
		 FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
		 fd.setVisible(true);
		 
		 if(fd.getFile()!=null) {
			 fileName = fd.getFile();
			 fileAddress = fd.getDirectory();
			 gui.window.setTitle(fileName); //set the new filename on the window
		 }
		 try {
			 FileWriter fw = new FileWriter(fileAddress +fileName);
			 fw.write(gui.textArea.getText());
			 fw.close();
		 } catch(Exception e){
			 System.out.println("File Not Saved");
		 }
		 
	 }
	 
	 public void exit() {
		 System.exit(0);
	 }
}
