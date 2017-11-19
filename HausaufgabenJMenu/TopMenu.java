package HausaufgabenJMenu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem; 

public class TopMenu{ // Initialisieren der "Panels"
	
	JFrame f = new JFrame("Main Menu");
	ColorSliderRGB colorPanel = new ColorSliderRGB();
	SongList songPanel = new SongList();
	TextSaver textPanel = new TextSaver();
	public static int framesizex = 700;
	public static int framesizey = 500;
	
	public TopMenu()
	{
		gui();
	}
	
	public void gui () { // Interface gestalten

	JMenuBar mb = new JMenuBar();
	
	JMenu colorslider = new JMenu("ColorSlider");
	mb.add(colorslider);
	
	JMenu songlist = new JMenu("SongList");
	mb.add(songlist);
	
	JMenu textsaver = new JMenu("TextSaver");
	mb.add(textsaver);
	
	JMenuItem open1 = new JMenuItem("Start ColorSlider");
	colorslider.add(open1);

	JMenuItem open2 = new JMenuItem("Start SongList");
	songlist.add(open2);
	
	JMenuItem open3 = new JMenuItem("Start TextSaver");
	textsaver.add(open3);
	
	f.setJMenuBar(mb);

	
		open1.addActionListener(e -> { // Funktionalität der Buttons im JMenu
	
			f.remove(songPanel);
			f.remove(textPanel);
			f.revalidate();
			f.repaint();
			f.add(colorPanel, BorderLayout.SOUTH);				
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(framesizex , framesizey);
			f.pack();
			f.setVisible(true);
	});
		
		open2.addActionListener(e -> {
			
			f.remove(colorPanel);
			f.remove(textPanel);
			f.revalidate();
			f.repaint();
			f.add(songPanel, BorderLayout.SOUTH);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(framesizex , framesizey);
			f.setVisible(true);
	});
		
		open3.addActionListener(e -> {
			
			f.remove(colorPanel);
			f.remove(songPanel);
			f.revalidate();
			f.repaint();
			f.add(textPanel, BorderLayout.NORTH);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(framesizex , framesizey);
			f.setVisible(true);
	});
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(framesizex , framesizey);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new TopMenu();	
	}
}