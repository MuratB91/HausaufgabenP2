package HausaufgabenJMenu;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorSliderRGB extends JPanel{ // Initialisieren der Slider und des Canvas
	
	 	DrawingCanvas canvas = new DrawingCanvas();
		JSlider sliderR = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		JSlider sliderG = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		JSlider sliderB = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		
	    int redValue, greenValue, blueValue; // int-werte für die Übertragung initialisieren

	public ColorSliderRGB() { // Interface für den Color Slider
	
		JLabel redlabel = new JLabel("Red");
		JLabel greenlabel = new JLabel("Green");
		JLabel bluelabel = new JLabel("Blue");
		
		add(redlabel);
	    add(sliderR);  
	    add(greenlabel);
	    add(sliderG);   
	    add(bluelabel);
	    add(sliderB);
	    add(canvas);
	
	    sliderR.addChangeListener(new ChangeListener() { // ChangeListener für den Slider, der durch displayRGBColor(); auf dem Canvas direkt malt
	        public void stateChanged(ChangeEvent event) {
	        	
	        	int value = sliderR.getValue(); // Wert von slider auf ein int übertragen
	        		if (value == value) {
	        		
	        		redValue = value;
	        		displayRGBColor(); // Würde ohne zwar Wert ändern, aber nicht Canvas aktualisieren
	        	}
	        }
	
	    });
	    
	    sliderG.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent event) {
	        	
	        	int value = sliderG.getValue();
	        	
	        	if (value == value) {
	        		
	        		greenValue = value;
	        		displayRGBColor();
	        	}
	        }
		
	    });
	    
	    sliderB.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent event) {
	        	
	        	int value = sliderB.getValue();
	        	
	        	if (value == value) {
	        		
	        		blueValue = value;
	        		displayRGBColor();
	        	}	        	
	        }	
	
	    });
}
	  class DrawingCanvas extends Canvas {
		    Color color;

		    public DrawingCanvas() { // Canvas erstellen zum Malen und auf schwarz initialisiert
		      setSize(350, 350);
		      color = new Color(0, 0, 0);
		      setBackgroundColor();
		    }

		    public void setBackgroundColor() { // hier die Werte (0-255) die dann als Farbe dargestellt werden
		      color = new Color(redValue, greenValue, blueValue);
		      setBackground(color);
		    }
		  }
	  		public void displayRGBColor() {  // Er würde die Werte ändern, aber nicht den Hintergrund aktualisieren, daher rufe ich diese Methode stetig im ChangeListener auf
		      canvas.setBackgroundColor();
	  		}

}