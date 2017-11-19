package HausaufgabenJMenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextSaver extends JPanel{
	
	JTextArea tx1 = new JTextArea(20 ,50);
	JFileChooser chooser = new JFileChooser();
	File file;
	
	public TextSaver(){ // GUI des Panels

		JButton button = new JButton("Open");
		JButton button1 = new JButton("Save");
		
		add(button);
		add(button1);
		add(tx1);
		add(new JScrollPane(tx1));
				
		button.addActionListener(new ActionListener(){ // Funktionalität der Buttons
			public void actionPerformed(ActionEvent e){
			
				LoadFile();	
				}
		});
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				SaveFile();
				}
		});
	}
	
	public void LoadFile(){ // Load-Funktion für Textdateien
		
		int state = chooser.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION){
			
			file = chooser.getSelectedFile();
		}
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String s =  in.readLine();
			while(s!=null){
				tx1.append(s);
				s = in.readLine();
				in.close(); 
			}
		}
		catch (Exception e){
			
		}
	}

	public void SaveFile(){ // Safe-Funktion für die Textarea
		
		int state = chooser.showSaveDialog(null);
		if (state == JFileChooser.APPROVE_OPTION){
			
			file = chooser.getSelectedFile();
			
		}
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String text = tx1.getText();
			FileWriter fw = new FileWriter(file);
			
			while(text!=null){
				bw.write(text);
				bw.newLine();
				bw.close();			
			}	
		}
		
		catch(Exception e){
			
		}
	}
}