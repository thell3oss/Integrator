 

public class Main {

    public static void main(String[] args) {
        Function cubic = new Function("x^3");
    
        
        
        
        LeftHandRiemannSum integrator = new LeftHandRiemannSum();
        
        
        // Example of integration with a different number of intervals..
        for (int i = 1; i < 100000; i += 1) {
            double result = integrator.Integrate(-3, 2, i, cubic);
            System.out.println("nu  mber of intervals: " + i + " | value: " + (result));
        }
        // The integral of x^3 from -3 to 2 is exactly -16.25
    }
}
