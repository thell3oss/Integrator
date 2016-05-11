import org.nfunk.jep.JEP;
/**
 * Write a description of class Function here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Function
{
    private String function;
    private JEP parser;
    
    public Function(String function)
    {
        this.function = function;
        
        parser = new JEP();
        parser.addStandardFunctions();
        parser.addStandardConstants();
    }
    
    public double evaluate(double x)
    {
        parser.addVariable("x", x);
        parser.parseExpression(function);
        return parser.getValue();
    }
    
    
    public double LRS(double start, double end, int numberOfIntervals)
    {
		double deltaX = (end - start) / numberOfIntervals;
		double total = 0;
		for (double x = start; x < end; x += deltaX) {
			total += this.evaluate(x) * deltaX;
		}
		return total;
	}
    
    public double MMS(double start, double end, int numberOfIntervals)
    {
    	double deltaX = (end - start) / numberOfIntervals;
    	return MMS(start + (deltaX / 2), end, numberOfIntervals);
	}
    
    public double RRS(double start, double end, int numberOfIntervals)
    {
    	double deltaX = (end - start) / numberOfIntervals;
    	return MMS(start + deltaX / 2, end, numberOfIntervals);
	}
    
    public double TrapezoidalSum(double start, double end, int numberOfIntervals)
    {
    	double deltaX = (end - start) / numberOfIntervals;
		double total = 0;
		for (double x = start; x < end; x += deltaX)
		{
			total += this.evaluate(x) + this.evaluate(x + deltaX) * deltaX;
		}
		return total;
    }
}
