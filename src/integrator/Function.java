package integrator;
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
        double x = start;
        for (int i = 0; i < numberOfIntervals; i++)
        {
        	total += this.evaluate(x) * deltaX;
        	x += deltaX;
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
        double x = start;
        for (int i = 0; i < numberOfIntervals; i++)
        {
            total += (this.evaluate(x) + this.evaluate(x + deltaX));
            x += deltaX;
        }
        return total * (deltaX / 2);
    }
    
   public double simpsonsRule(double start, double end, int numberOfIntervals)
    {
        if (numberOfIntervals % 2 == 1)
        {
            throw new IllegalArgumentException("Simpsons's Rule does not accept an odd number of intervals!");
        }
        
        double deltaX = (end - start) / numberOfIntervals;
        double total = 0;
        double x = start;
        for (int i = 0; i < numberOfIntervals; i += 2)
        {
            double left = this.evaluate(x);
            double mid = this.evaluate(x + deltaX);
            double right = this.evaluate(x + 2 * deltaX);
            total += left + (4 * mid) + right;
            x += 2 * deltaX;
        }
        
        return total * (deltaX / 3);
    }
   
   public double simpsonsThreeEightsRule(double start, double end, int numberOfIntervals)
   {
       if (numberOfIntervals % 3 != 0)
       {
           throw new IllegalArgumentException("The number of intervals must be a multiple of three");
       }
       
       double deltaX = (end - start) / numberOfIntervals;
       double total = 0;
       double x = start;
       for (int i = 0; i < numberOfIntervals; i += 3)
       {
    	   // Yes, I know these are bad names.
           double x1 = this.evaluate(x);
           double x2 = this.evaluate(x + deltaX);
           double x3 = this.evaluate(x + 2 * deltaX);
           double x4 = this.evaluate(x + 3 * deltaX);
           total += x1 + (3 * x2) + (3 * x3) + x4;
           x += 3 * deltaX;
       }
       
       return total * (deltaX * 3 / 8);
   }
   
   public double boolesRule(double start, double end, int numberOfIntervals)
   {
       if (numberOfIntervals % 4 != 0)
       {
           throw new IllegalArgumentException("The number of intervals must be a multiple of four");
       }
       
       double deltaX = (end - start) / numberOfIntervals;
       double total = 0;
       double x = start;
       for (int i = 0; i < numberOfIntervals; i += 4)
       {
           double x1 = this.evaluate(x);
           double x2 = this.evaluate(x + deltaX);
           double x3 = this.evaluate(x + 2 * deltaX);
           double x4 = this.evaluate(x + 3 * deltaX);
           double x5 = this.evaluate(x + 4 * deltaX);
           total += (7 * x1) + (32 * x2) + (12 * x3) + (32 * x4) + (7 * x5);
           x += 4 * deltaX;
       }
       
       return total * (deltaX * 2 / 45);
   }
}