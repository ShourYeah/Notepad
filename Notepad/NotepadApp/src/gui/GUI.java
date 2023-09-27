package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

//concepts of file handling and Java Swing
public class GUI implements ActionListener {

	JFrame window; // JFrame as window

	// Text Area
	JTextArea textArea; // Adding text area
	JScrollPane scrollPane;// Adding Scroll Pane
	boolean wordWrapOn = false;  //default is off

	// Top Menu Bar
	JMenuBar menuBar;// Adding menu Bar
	JMenu menuFile, menuEdit, menuFormat, menuColor;

	// File Menu
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	
	//Edit Menu
	JMenuItem iUndo, iRedo;

	// Format Menu
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
	
	//Color Menu
	JMenuItem iColor1, iColor2, iColor3;

	Function_File file = new Function_File(this); // this due to using access of Function_File.java
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this);
	Function_Edit edit = new Function_Edit(this);
	
	UndoManager um = new UndoManager();

	public static void main(String[] args) {

		new GUI();
	}

	public GUI() {
		createWindow(); // calling createWindow
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		
		format.selectedFont = "Arial"; //default font
		format.createFont(16); //default size
		format.wordWrap(); // caught in testing for giving null pointer exception 
		color.changeColor("White");
		window.setVisible(true);

	}

	public void createWindow() {
		window = new JFrame("Notepad"); // Top Bar display
		window.setSize(800, 600); // default window size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close the window properly

	}

	public void createTextArea() {
		textArea = new JTextArea();
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
		    public void undoableEditHappened(UndoableEditEvent e) {
		        um.addEdit(e.getEdit());
		    }
		});

		
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane); // added scrollpane in window
		
	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar); // Top menu bar addition

		menuFile = new JMenu("File"); // Add file option
		menuBar.add(menuFile);

		menuEdit = new JMenu("Edit"); // Add edit option
		menuBar.add(menuEdit);

		menuFormat = new JMenu("Format"); // Add format option
		menuBar.add(menuFormat);

		menuColor = new JMenu("Color"); // Add color option
		menuBar.add(menuColor);
	}

	public void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew); // Adding New to menu

		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);

		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);

		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);

		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);

	}
	public void createEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	
	

	public void createFormatMenu() {
   		iWrap = new JMenuItem("Word Wrap: Off");
   		iWrap.addActionListener(this);
   		iWrap.setActionCommand("Word Wrap");
   		menuFormat.add(iWrap);
   		
   		menuFont= new JMenu("Font");
   		menuFormat.add(menuFont);
   		
   		iFontArial = new JMenuItem("Arial");
   		iFontArial.addActionListener(this);
   		iFontArial.setActionCommand("Arial");
   		menuFont.add(iFontArial);
   		
   		iFontCSMS = new JMenuItem("Comic Sans MS");
   		iFontCSMS.addActionListener(this);
   		iFontCSMS.setActionCommand("Comic Sans MS");
   		menuFont.add(iFontCSMS);
   		
   		iFontTNR = new JMenuItem("Times New Roman");
   		iFontTNR.addActionListener(this);
   		iFontTNR.setActionCommand("Times New Roman");
   		menuFont.add(iFontTNR);
   		
   		menuFontSize = new JMenu("Font Size");
   		menuFormat.add(menuFontSize);
   		
   		iFontSize8 = new JMenuItem("8");
   		iFontSize8.addActionListener(this);
   		iFontSize8.setActionCommand("size8");
   		menuFontSize.add(iFontSize8);
   		
   		
   		iFontSize12 = new JMenuItem("12");
   		iFontSize12.addActionListener(this);
   		iFontSize12.setActionCommand("size12");
   		menuFontSize.add(iFontSize12);
   		
   		
   		iFontSize16 = new JMenuItem("16");
   		iFontSize16.addActionListener(this);
   		iFontSize16.setActionCommand("size16");
   		menuFontSize.add(iFontSize16);
   		
   		iFontSize20 = new JMenuItem("20");
   		iFontSize20.addActionListener(this);
   		iFontSize20.setActionCommand("size20");
   		menuFontSize.add(iFontSize20); 
   		
   		iFontSize24 = new JMenuItem("24");
   		iFontSize24.addActionListener(this);
   		iFontSize24.setActionCommand("size24");
   		menuFontSize.add(iFontSize24);
   		
   		iFontSize28 = new JMenuItem("28");
   		iFontSize28.addActionListener(this);
   		iFontSize28.setActionCommand("size28");
   		menuFontSize.add(iFontSize28);
   		
   		
   	}
	
	public void createColorMenu() {
		
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		

		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		

		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		switch (command) {
		case "New":
			file.newFile();
			break;
		case "Open":
			file.open();
			break;
		case "Save":
			file.save();
			break;
		case "SaveAs":
			file.saveAs();
			break;
		case "Exit":
			file.exit();
			break;
			
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
			
		case "Word Wrap":
			format.wordWrap();
			break;
			
		case "Arial":
			format.setFont(command); // can use Arial instead of command, but its all the same thing
			break;
		case "Comic Sans MS":
			format.setFont(command); 
			break;
		case "Times New Roman":
			format.setFont(command); // can use Arial instead of command, but its all the same thing
			break;
			
		case "Size8":
			format.createFont(8);  //using font from createFont method in Function_Format.java
			break;
		case "Size12":
			format.createFont(12);  
			break;
		case "Size16":
			format.createFont(16);  
			break;
		case "Size20":
			format.createFont(20);  
			break;
		case "Size24":
			format.createFont(24);  
			break;
		case "Size28":
			format.createFont(28);  
			break;
			
		case "White": color.changeColor(command); break;
		case "Black": color.changeColor(command); break;
		case "Blue": color.changeColor(command); break;

	
		}
	}

}