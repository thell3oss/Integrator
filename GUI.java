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
    private JTextField fxnInput = addTextField("", 1, 2, 1, 1);
    private JTextField lowerLimitInput = addTextField("", 2, 2, 1, 1);
    private JTextField upperLimitInput = addTextField("", 3, 2, 1, 1);
    private IntegerField initNumberOfIntervals = addIntegerField(1, 4, 2, 1, 1);
    private IntegerField finalNumberOfIntervals = addIntegerField(2, 5, 2, 1, 1);
    
    private ButtonGroup approximationSelector = new ButtonGroup();
    private JRadioButton lrs = addRadioButton("Left Riemann Sum", 1, 3, 1, 1);
    private JRadioButton mrs = addRadioButton("Middle Riemann Sum", 2, 3, 1, 1);
    private JRadioButton rrs = addRadioButton("Right Riemann Sum", 3, 3, 1, 1);
    private JRadioButton tRule = addRadioButton("Trapezoidal Rule", 4, 3, 1, 1);
    private JRadioButton sRule = addRadioButton("Simpson's Rule", 5, 3, 1, 1);
    
    private JButton calculate = addButton("CALCULATE", 6, 1, 1, 1);
    
    private JLabel loadingIndicator = addLabel("", 7, 1, 1, 1);
    private JList table = addList(8, 1, 1, 1);
    
    public GUI()
    {
        setTitle("Integrator");
        
        addLabel("Enter the function to be integrated: ", 1, 1, 1, 1);
        addLabel("lower limit: ", 2, 1, 1, 1);
        addLabel("upper limit: ", 3, 1, 1, 1);
        addLabel("initial amount of intervals: ", 4, 1, 1, 1);
        addLabel("final amount of intervals: ", 5, 1, 1, 1);
        
        approximationSelector.add(lrs);
        approximationSelector.add(mrs);
        approximationSelector.add(rrs);
        approximationSelector.add(tRule);
        approximationSelector.add(sRule);
        
        setSize(600, 600);
        setVisible(true);
    }
    
    private void respond()
    {
        Function fx = new Function(fxnInput.getText());
        int n1 = initNumberOfIntervals.getNumber(), n2 = finalNumberOfIntervals.getNumber();
        double a = new Function(lowerLimitInput.getText()).evaluate(1), b = new Function(upperLimitInput.getText()).evaluate(1);
        
        if (fx.equals(""))
        {
            showMessage("You must enter a function.");
        }
        
        if (n1 < 0)
        {
            showMessage("The initial amount of subintervals cannot be negative.");
            return;
        }
        if (n1 == 0)
        {
            showMessage("The initial amount of subintervals cannot be 0.");
            return;
        }
        if (n2 < 0)
        {
            showMessage("The final amount of subintervals cannot be negative.");
            return;
        }
        if (n2 == 0)
        {
            showMessage("The initial amount of subintervals cannot be 0.");
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
            if (n1 % 2 == 1)
            {
               showMessage("The inital amount of subintervals cannot be odd when using Simpson's Rule!");
               return;
            }
            if (n2 % 2 == 1)
            {
               showMessage("The final amount of subintervals cannot be odd when using Simpson's Rule!");
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
        else
        {
            showMessage("You must select an approximation method.");
        }
        table.setModel(tableContents);  
        
        revalidate();
        repaint();
    }
    
    private void showMessage(String text)
    {
        new JOptionPane().showMessageDialog(this, text);
    }
    
    public void buttonClicked(JButton b)
    {
        if (b == calculate)
        {
            respond();
        }
    }
}