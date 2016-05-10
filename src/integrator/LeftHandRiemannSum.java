package integrator;

public class LeftHandRiemannSum extends GenericIntegrator {
	// f(x) * Δx 
	static DeltaSum leftHand = (x, function, deltaX) -> {
		return function.value(x) * deltaX;
	};
	
	LeftHandRiemannSum() {
		super();
	}
	
	LeftHandRiemannSum(double start, double end, int numberOfIntervals, Function function) {
		super(start, end, numberOfIntervals, function, leftHand);
	}
	
	public double Integrate(double start, double end, int numberOfIntervals, Function function) {
		return super.Integrate(start, end, numberOfIntervals, function, leftHand);
	}
}
