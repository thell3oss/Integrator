package integrator;

public interface Function {
	/***
	 * Wrapper for a function of x. Essentially just a f(x) interface.
	 * @param Takes a double.
	 * @return Returns the value of f(x).
	 */
	double value(double x);
}
