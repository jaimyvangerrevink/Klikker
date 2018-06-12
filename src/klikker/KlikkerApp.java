package klikker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import javafx.scene.text.Font;

public class KlikkerApp extends JFrame{    


	public static void main( String args[] ) {

		JFrame frame = new KlikkerApp();     
		frame.setSize(470,720);
//		frame.setSize(720,720);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );    
		frame.setTitle("Klikker"); 
		frame.setContentPane( new KlikkerAppPanel() );     
		frame.setVisible( true ); 

	} 
}


}