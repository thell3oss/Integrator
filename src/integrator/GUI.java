package integrator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
	public GUI() {
		 setTitle("Integrator");
		 setSize(300, 200);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 // Create labels which ask for the function and interval to use.
		 String fxn;
		 double a, b;
		 int n;
		 
	    JLabel label = NewLabel("What function?");
	    createLayout(label);

	     
	}
	
	private JLabel NewLabel(String labelName) {
	     JLabel label = new JLabel(labelName);
	     Font serif = new Font("Serif", Font.PLAIN, 14);
	     label.setFont(serif);
	     label.setForeground(new Color(50, 50, 25));
	     return label;
	}
	
    private void createLayout(JComponent... arg) {
        // I don't actually know what this does.
    	// I'm assuming it's formatting but I copy+pasted it from
    	// a tutorial because I don't know how to use Java Swing yet.
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);        

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        
    }   
}
