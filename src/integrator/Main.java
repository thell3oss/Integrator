package integrator;

public class Main {

	public static void main(String[] args) {
		Function cubic = (x) -> {
			return x*x*x;
		};
		
		DeltaSum leftHand = (x, function, deltaX) -> {
			return function.value(x) * deltaX;
		};
		
		LeftHandRiemannSum integrator = new LeftHandRiemannSum();
		GenericIntegrator integrator2 = new GenericIntegrator();		
		
		
		// Example of integration with a different number of intervals..
		for (int i = 1; i < 1000; i += 1) {
			double result = integrator.Integrate(-3, 2, i, cubic);
			double result2 = integrator2.Integrate(-3, 2, i, cubic, leftHand);
			System.out.println("number of intervals: " + i + " | value: " + (result - result2));
		}
		// The integral of x^3 from -3 to 2 is exactly -16.25
		
	}
}
