package HausaufgabenJMenu;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SongList extends JPanel {
	
	private Song song;
	private String name;
	private int length;
	private DefaultListModel<Song> listModel;
	
	public SongList () { // GUI  // Wird leider nicht angezeigt
		
		listModel = new DefaultListModel<>();
		JList<Song> list = new JList<>(listModel);
		
		Box right = Box.createVerticalBox();
		JButton add = new JButton("Add");
		
		add.addActionListener(e->{
			
			addNewSong();
		});

		right.add(add);
		
		add(list, BorderLayout.WEST);
		add(right, BorderLayout.EAST);

		setSize(300,500);
		setVisible(true);
	}
	
	public void addNewSong(){ // Dialog-Fenster Funktionalität
		
		AddSongDialog dialog = new AddSongDialog();
		Song song = dialog.getSong();
		if(song!=null) {
		this.listModel.addElement(song);
		}
	}
}
