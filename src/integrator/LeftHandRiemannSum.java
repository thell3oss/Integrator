package integrator;

public class LeftHandRiemannSum {
	private double start;
	private double end;
	private int numberOfIntervals;

	// Below is a lambda function and represents f(x).
	// Syntax should be:
	// Function function = (x) -> {return x*x*x/3};
	// Replace x*x*x/3 with your own functions.
	private Function function;

	public LeftHandRiemannSum() { }

	public LeftHandRiemannSum(double start, double end, int numberOfIntervals, Function function) {
		this.start = start;
		this.end = end;
		this.numberOfIntervals = numberOfIntervals;
		this.function = function;
	}

	public double Integrate(){
		return Integrate(start, end, numberOfIntervals, function);
	}

	public double Integrate(double start, double end, int numberOfIntervals) {
		return Integrate(start, end, numberOfIntervals, function);
	}

	public double Integrate(double start, double end, int numberOfIntervals, Function function) {
		double deltaX = (end - start)/numberOfIntervals;
		double total = 0;
		for (double x = start; x < end; x = x + deltaX) {
			total += function.function(x) * deltaX;
		}
		return total;
	}
}
