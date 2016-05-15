package integrator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
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

		Container container = getContentPane();

		
		// FIELDS AND FIELD LABELS
		//Set up container + groups
		JPanel field_panel = new JPanel();
		GroupLayout field_layout = new GroupLayout(field_panel);
		field_panel.setLayout(field_layout);        	        

		SequentialGroup hGroup = field_layout.createSequentialGroup();        
		ParallelGroup vGroup = field_layout.createParallelGroup();
		
		// Create text areas which ask for the function and interval to use.
		JLabel function_label = new JLabel("What function?");
		JTextField function_field = new JTextField(16);
		
		JLabel interval_label = new JLabel("What interval? (Format is [a,b])");
		JTextField interval_field = new JTextField(4);
		
		JLabel subinterval_label = new JLabel("How many subintervals?");
		JTextField subinterval_field = new JTextField(4);
		
		// Add the text areas
		hGroup.addGroup(field_layout.createSequentialGroup()
				.addGroup(field_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(function_label)
						.addComponent(interval_label)
						.addComponent(subinterval_label))
				.addGroup(field_layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(function_field, 12, 150, 200)
						.addComponent(interval_field, 12, 60, 80)
						.addComponent(subinterval_field, 12, 20, 30))
				);
		
		vGroup.addGroup(field_layout.createSequentialGroup()
				.addGroup(field_layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(function_label)
						.addComponent(function_field))
				.addGroup(field_layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(interval_label)
						.addComponent(interval_field))
				.addGroup(field_layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(subinterval_label)
						.addComponent(subinterval_field))
				);
		field_layout.setHorizontalGroup(hGroup);
		field_layout.setVerticalGroup(vGroup);
		
		// BUTTON AND GRAPH
		JPanel button_panel = new JPanel();
		button_panel.setLayout(new FlowLayout());
		
		JButton calculate_button = new JButton("Calculate");
		button_panel.add(calculate_button);
		
		//Add all the panels
		JPanel window_pane = new JPanel();
		window_pane.setLayout(new FlowLayout());
		window_pane.add(field_panel);
		window_pane.add(button_panel);
		container.add(window_pane);

	}
}
