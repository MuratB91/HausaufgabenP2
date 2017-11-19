package HausaufgabenJMenu;

public class Song {  // Schreibt die Werte aus dem Dialog in die JList
	
private String name;
private int length;


public Song(String name, int length){
	
	super();
	this.name = name;
	this.length = length;
	

}

public String getName() {
	
	return name;
}

public int getlength() {
	
	return length;
}

@Override
public String toString() {
	
	return name +" : " + length;
}



}