package integrator;

public interface DeltaSum {
	/***
	 * Wrapper for a delta sum of x.
	 * @param Takes a function and a double value.
	 * @return Returns a partial sum.
	 */
	double sum(double x, Function func, double deltaX);
}
