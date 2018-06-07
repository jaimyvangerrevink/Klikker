package klikker;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Winkelview extends JPanel{

	JLabel UpgradeTitel;
	
	private JPanel KoopKnop;

	public void createPanel2(){
		KoopKnop = new JPanel();
		KoopKnop.setLayout( new FlowLayout() );

	JLabel UpgradeTitel = new JLabel("Upgrade naam");
		
		KoopKnop.add( new JButton( "Koop" ) );
	}


}
