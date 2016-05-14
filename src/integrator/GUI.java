package integrator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
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
		
		// Create text areas which ask for the function and interval to use.
		JLabel function_label = new JLabel("What function?");
		JTextField function_field = new JTextField(16);
		
		JLabel interval_label = new JLabel("What interval? (Format is [a,b])");
		JTextField interval_field = new JTextField(4);
		
		JLabel subinterval_label = new JLabel("How many subintervals?");
		JTextField subinterval_field = new JTextField(4);
		
		
		// Add the text areas
		hGroup.addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(function_label)
						.addComponent(interval_label)
						.addComponent(subinterval_label))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(function_field, 100, 150, 200)
						.addComponent(interval_field, 40, 60, 80)
						.addComponent(subinterval_field, 16, 20, 30))
				);
		
		vGroup.addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(function_label)
						.addComponent(function_field))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(interval_label)
						.addComponent(interval_field))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(subinterval_label)
						.addComponent(subinterval_field))
				);
		// Finally, set the layout to have the groups we have.
		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);


	}

	private JPanel NewLabel(String labelName, int width, int height) {
		JPanel panel = new JPanel(); 

		JTextField textPane = new JTextField();
		textPane.setPreferredSize(new Dimension(width, height));


		JLabel label = new JLabel(labelName);

		label.setLabelFor(textPane);
		Font serif = new Font("Serif", Font.PLAIN, 14);
		label.setFont(serif);
		label.setForeground(new Color(50, 50, 25));

		panel.add(label);
		panel.add(textPane);


		return panel;
	}
}
