package HausaufgabenJMenu;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddSongDialog  extends JDialog{
	private Song song;

public AddSongDialog(){ // GUI Dialog
	
	Box box = Box.createVerticalBox();
	JPanel top = new JPanel();
	JTextField nameField = new JTextField(10);
	top.add(new JLabel("Enter Song Title"));
	top.add(nameField);

	JPanel center = new JPanel();
	JFormattedTextField lengthField = new JFormattedTextField(0);
	lengthField.setColumns(10);
	center.add(new JLabel("Enter Duration"));
	center.add(lengthField);
	
	
	JButton okButton = new JButton("OK");
	okButton.addActionListener(e->{
		
		String name = nameField.getText();
		int length = (int)lengthField.getValue();
		this.song = new Song(name, length);
		dispose();
		
	});

	setContentPane(box);
	box.add(top);
	box.add(center);
	box.add(okButton);
	
	setModal(true);
	pack();
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	setVisible(true);
	
}

public Song getSong() {
	
	return song;
	}
}