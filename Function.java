
import org.nfunk.jep.JEP;
/**
 * Write a description of class Function here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Function
{
	private static final double EPSILON = .0000000001;
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
        for (double x = start; Math.abs(x - end) > EPSILON; x += deltaX) //|x - end| > EPSILON is essentially equivalent to x < end
        {
        	total += this.evaluate(x) * deltaX;
            //System.out.println("x: " + x + "\t" + "total: " + total);
        }
        return total;
    }
    
    public double MRS(double start, double end, int numberOfIntervals)
    {
        double deltaX = (end - start) / numberOfIntervals;
        return LRS(start + (deltaX / 2), end + (deltaX / 2), numberOfIntervals);
    }
    
    public double RRS(double start, double end, int numberOfIntervals)
    {
        double deltaX = (end - start) / numberOfIntervals;
        return LRS(start + deltaX, end + deltaX, numberOfIntervals);
    }
    
    public double trapezoidalSum(double start, double end, int numberOfIntervals)
    {
        double deltaX = (end - start) / numberOfIntervals;
        double total = 0;
        for (double x = start; Math.abs(x - end) > EPSILON; x += deltaX)
        {
            total += (this.evaluate(x) + this.evaluate(x + deltaX)) * (deltaX / 2);
        }
        return total;
    }
    
   public double simpsonsRule(double start, double end, int numberOfIntervals)
    {
        if (numberOfIntervals % 2 == 1)
        {
            throw new IllegalArgumentException("Simpsons's Rule does not accept an odd number of intervals!");
        }
        
        double deltaX = (end - start) / numberOfIntervals;
        double total = 0;
        
        int i = 0;
        for (double x = start; Math.abs(x - end) > EPSILON; x += 2 * deltaX, i ++) //x is incremented by 2 because the right endpoint of the middlemost parabolas is the left endoint of other middle parabolas
        {
            double xStar = x;
            double left = this.evaluate(xStar);
            double mid = this.evaluate(xStar + deltaX);
            double right = this.evaluate(xStar + 2 * deltaX);
            total += left + (4 * mid) + right;
        }
        
        return total * (deltaX / 3);
    }
}