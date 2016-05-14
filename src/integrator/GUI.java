package integrator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class GUI extends JFrame{
	public GUI() {
		 setTitle("Integrator");
		 setSize(600, 500);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);

		 //Set up container + groups
		 Container pane = getContentPane();

		 GroupLayout layout = new GroupLayout(pane);
		 pane.setLayout(layout);        	        

		 SequentialGroup hGroup = layout.createSequentialGroup();        
		 ParallelGroup vGroup = layout.createParallelGroup();
		 
		 // Create labels which ask for the function and interval to use.
		 JPanel function_label = NewLabel("What function?");
		 JPanel interval_label = NewLabel("What interval?");
		 JPanel subinterval_label = NewLabel("How many subintervals?");
		 
		 hGroup
		 	.addComponent(function_label)
		 	.addComponent(interval_label)
		 	.addComponent(subinterval_label);
		 vGroup
		 	.addComponent(function_label)
		 	.addComponent(interval_label)
		 	.addComponent(subinterval_label);
		 
		 // Finally, set the layout to have the groups we have.
		 layout.setHorizontalGroup(hGroup);
		 layout.setVerticalGroup(vGroup);
	}
	
	private JPanel NewLabel(String labelName) {
	     JPanel panel = new JPanel(); 
		
	     JTextField textPane = new JTextField();
	     textPane.setPreferredSize(new Dimension(70, 20));
	     
	     
	     JLabel label = new JLabel(labelName);
	     
	     label.setLabelFor(textPane);
	     Font serif = new Font("Serif", Font.PLAIN, 14);
	     label.setFont(serif);
	     label.setForeground(new Color(50, 50, 25));
	     
	     panel.add(textPane);
	     panel.add(label);
	     
	     return panel;
	}   
}
