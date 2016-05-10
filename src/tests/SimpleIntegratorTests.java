package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import integrator.Function;
import integrator.LeftHandRiemannSum;
import integrator.RightHandRiemannSum;
import integrator.TrapezoidalSum;


public class SimpleIntegratorTests {
	private static final double EPSILON = 0.01;

	@Test
	public void cubicIntergral() {
		//All three integrals should be reasonably close to -16.25
		
		Function cubic = new Function("x^3");
		LeftHandRiemannSum leftHand = new LeftHandRiemannSum(-3 ,2, 10000, cubic);
		RightHandRiemannSum rightHand = new RightHandRiemannSum(-3 ,2, 10000, cubic);
		TrapezoidalSum trapezoid = new TrapezoidalSum(-3 ,2, 10000, cubic);
		
		assertEquals(leftHand.Integrate(), -16.25, EPSILON);
		assertEquals(rightHand.Integrate(), -16.25, EPSILON);
		assertEquals(trapezoid.Integrate(), -16.25, EPSILON);
	}
}
