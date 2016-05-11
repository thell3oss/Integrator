import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		String fxn;
		double a, b;
		int n;
		
		System.out.println("Enter f(x)");
		fxn = input.nextLine();
		System.out.println("Enter a");
		a = input.nextDouble();
		System.out.println("Enter b");
		b = input.nextDouble();
		System.out.println("Enter n");
		n = input.nextInt();
		
		Function f = new Function(fxn);
		System.out.println(f.LRS(a, b, n));
	}
}
