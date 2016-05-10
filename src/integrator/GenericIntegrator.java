package integrator;

public class GenericIntegrator {
	private double start;
	private double end;
	private int numberOfIntervals;

	// Below is a lambda function and represents f(x).
	// Syntax should be:
	// Function function = (x) -> {return x*x*x/3};
	// Replace x*x*x/3 with your own functions.
	Function function;
	// This is the function used to sum your 
	// partial sums. For example. Left hand Riemann Summation should be
	// deltaSum = (x, function) -> {return function(x) * deltaX}
	DeltaSum deltaSum;
	
	GenericIntegrator() { }

	GenericIntegrator(double start, double end, int numberOfIntervals, Function function, DeltaSum deltaSum) {
		this.start = start;
		this.end = end;
		this.numberOfIntervals = numberOfIntervals;
		this.function = function;
		this.deltaSum = deltaSum;
	}

	double Integrate(){
		return Integrate(start, end, numberOfIntervals, function, deltaSum);
	}

	double Integrate(double start, double end, int numberOfIntervals) {
		return Integrate(start, end, numberOfIntervals, function, deltaSum);
	}

	double Integrate(double start, double end, int numberOfIntervals, Function function, DeltaSum deltaSum) {
		double deltaX = (end - start)/numberOfIntervals;
		double total = 0;
		for (double x = start; x < end; x = x + deltaX) {
			total += deltaSum.sum(x, function, deltaX);
		}
		return total;
	}
}
