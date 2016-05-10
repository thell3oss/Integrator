package integrator;

public class Main {

	public static void main(String[] args) {
		Function cubic = (x) -> {
			return x*x*x;
		};
		
		LeftHandRiemannSum integrator = new LeftHandRiemannSum();
		
		// Example of integration with a different number of intervals..
		for (int i = 1; i < 10000000; i += 1) {
			double result = integrator.Integrate(-3, 2, i, cubic);
			System.out.println("number of intervals: " + i + " | value: " + result);
		}
		// The integral of x^3 from -3 to 2 is exactly -16.25
		
	}
}
