package integrator;

public class SimpsonsRule extends GenericIntegrator {
	/*
	 * Simpson's Rule works by taking the integral of
	 */

    public SimpsonsRule() {
        super();
    }
    
    public SimpsonsRule(double start, double end, int numberOfIntervals, Function function){
        super(start, end, numberOfIntervals, function);
		if (numberOfIntervals % 2 == 1) {
			throw new RuntimeException("Simpson's Rule requires that the number of intervals be even.");
		}
    }
	public double specificSum(double x, Function function, double deltaX) {
		return (    function.evaluate(x) +
				2 * function.evaluate(x + deltaX) + 
				    function.evaluate(x + 2 * deltaX)) * deltaX / 3;
	}
	
	@Override
	public double Integrate(double start, double end, int numberOfIntervals, Function function) {
		if (numberOfIntervals % 2 == 1) {
			// Is this a good idea?
			throw new RuntimeException("Simpson's Rule requires that the number of intervals be even.");			
		}
		
		double deltaX = (end - start)/numberOfIntervals;
		double total = 0;
		//x_0 and x_n
		total += function.evaluate(start) + function.evaluate(end);
		//x_1 through x_n-1
		for (double x = start + deltaX; x < end - deltaX; x += 2 * deltaX) {
			// 4*f(x_1) + 2*f(x_2) + 4*f(x_3) + 2*f(x_4)...
			total += 4* function.evaluate(x) +
					2* function.evaluate(x + deltaX);
		}
		// Remember that deltaX / 3 encloses the whole thing.
		return total * deltaX / 3;
	}
}
