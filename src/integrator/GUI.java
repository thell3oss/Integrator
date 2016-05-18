package integrator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

public class GUI extends GBFrame
{
    private JTextField fxnInput = addTextField("", 1, 2, 2, 1);
    private JTextField lowerLimitInput = addTextField("", 2, 2, 1, 1);
    private JTextField upperLimitInput = addTextField("", 3, 2, 1, 1);
    private IntegerField initNumberOfIntervals = addIntegerField(1, 4, 2, 1, 1);
    private IntegerField finalNumberOfIntervals = addIntegerField(2, 5, 2, 1, 1);
    
    private ButtonGroup approximationSelector = new ButtonGroup();
    private JRadioButton lrs = addRadioButton("Left Riemann Sum", 2, 3, 1, 1);
    private JRadioButton mrs = addRadioButton("Middle Riemann Sum", 3, 3, 1, 1);
    private JRadioButton rrs = addRadioButton("Right Riemann Sum", 4, 3, 1, 1);
    private JRadioButton tRule = addRadioButton("Trapezoidal Rule", 5, 3, 1, 1);
    private JRadioButton sRule = addRadioButton("Simpson's Rule", 6, 3, 1, 1);
    private JRadioButton sThreeEightRule = addRadioButton("Simpson's 3/8 Rule", 7, 3, 1, 1);
    private JRadioButton boolesRule = addRadioButton("Boole's Rule", 8, 3, 1, 1);
    
    private JButton calculate = addButton("CALCULATE", 9, 1, 1, 1);
    
    private JList table = addList(10, 1, 1, 1);
    
    public GUI()
    {
        setTitle("Integrator");
        
        addLabel("Enter the function to be integrated: ", 1, 1, 1, 1);
        addLabel("Lower limit: ", 2, 1, 1, 1);
        addLabel("Upper limit: ", 3, 1, 1, 1);
        addLabel("Initial amount of intervals: ", 4, 1, 1, 1);
        addLabel("Final amount of intervals: ", 5, 1, 1, 1);
        
        approximationSelector.add(lrs);
        approximationSelector.add(mrs);
        approximationSelector.add(rrs);
        approximationSelector.add(tRule);
        approximationSelector.add(sRule);
        approximationSelector.add(sThreeEightRule);
        approximationSelector.add(boolesRule);
        
        setSize(600, 600);
        setVisible(true);
    }
    
    private void respond()
    {
        Function fx = new Function(fxnInput.getText());
        int n1 = initNumberOfIntervals.getNumber();
        int n2 = finalNumberOfIntervals.getNumber();
        double a = new Function(lowerLimitInput.getText()).evaluate(1);
        double b = new Function(upperLimitInput.getText()).evaluate(1);
        // Sanity Checks
        if (fx.equals(""))
        {
            showMessage("You must enter a function.");
            return;
        }
        
        if (n2 < n1)
        {
        	showMessage("Final amount of subintervals must be less than the initial number of subintervals.");
        	return;
        }
        
        if (n1 <= 0 || n2 <= 0)
        {
            showMessage("The initial and final amount of subintervals must be positive.");
            return;
        }
        
        DefaultListModel<String> tableContents = new DefaultListModel<String>();
        if (lrs.isSelected())
        {
            for (int i = n1; i <= n2; i ++)
            {
                tableContents.addElement(i + "\t\t|" + fx.LRS(a, b, i));
            }
        }
        else if (mrs.isSelected())
        {
            for (int i = n1; i <= n2; i ++)
            {
                tableContents.addElement(i + "\t\t|" + fx.MRS(a, b, i));
            }
        }
        else if (rrs.isSelected())
        {
            for (int i = n1; i <= n2; i ++)
            {
                tableContents.addElement(i + "\t\t|" + fx.RRS(a, b, i));
            }
        }
        else if (tRule.isSelected())
        {
            for (int i = n1; i <= n2; i ++)
            {
                tableContents.addElement(i + "\t\t|" + fx.trapezoidalSum(a, b, i));
            }
        }
        else if (sRule.isSelected())
        {
            if (n1 % 2 == 1 || n2 % 2 == 1)
            {
               showMessage("The number of intervals must be a multiple of two.");
               return;
            }
            for (int i = n1; i <= n2; i ++)
            {
                if (i % 2 == 1)
                {
                    continue;
                }
                tableContents.addElement(i + "\t\t|" + fx.simpsonsRule(a, b, i));
            }
        }
        else if (sThreeEightRule.isSelected())
        {
            if (n1 % 3 != 0 || n2 % 3 != 0)
            {
               showMessage("The number of intervals must be a multiple of three.");
               return;
            }

            for (int i = n1; i <= n2; i += 3)
            {
                tableContents.addElement(i + "\t\t|" + fx.simpsonsThreeEightsRule(a, b, i));
            }
        }
        
        else if (boolesRule.isSelected())
        {
            if (n1 % 4 != 0 || n2 % 4 != 0)
            {
               showMessage("The number of intervals must be a multiple of four.");
               return;
            }

            for (int i = n1; i <= n2; i += 4)
            {
                tableContents.addElement(i + "\t\t|" + fx.boolesRule(a, b, i));
            }
        }
        
        else
        {
            showMessage("You must select an approximation method.");
            return;
        }
        table.setModel(tableContents);  
        
        revalidate();
        repaint();
    }
    
    private void showMessage(String text)
    {
    	JOptionPane.showMessageDialog(this, text);
    }
    
    public void buttonClicked(JButton b)
    {
        if (b == calculate)
        {
            respond();
        }
    }
}