# Integrator

`Integrator.jar` performs [Riemann sums](https://en.wikipedia.org/wiki/Riemann_sum) and other numerical integration techniques. It was written by Aaron Kofsky and I as a final project for our 2016 calculus class, during my junior year of high school.

## The driver program

When a user runs `Integrator.jar`, they are presented with a GUI that allows them to enter in a mathematical function and then radio buttons to select a numerical integration technique of their choice. The user also enters an "Initial amount of intervals" and a "Final amount of intervals". After the user clicks "CALCULATE", a scrollable table of the results of approximating the specified integral with the selected technique are displayed, with the first entry in the table using "Initial amount of intervals" for the approximation and the last entry in the table using "Final amount of intervals". Typically, one expects that the accuracy of the integral improves further down the table, since more intervals corresponds to a better approximation.

!()[src/integrator/Integrator.PNG]

## The `Function' class

The class `Function` represents a mathematical function such as $f(x) = x^2$. For example, $f(x) = x^2$ would be represented by instantiating `f = new Function("x^2")`. Once a `Function` object has been created, one can call its `double evaluate(double x)` method to evaluate it at the input `x`. More interestingly, one can call the following methods on any function instance:

- `double LRS(double start, double end, int numberOfIntervals)` returns the result of performing a left Riemann sum
- `double MRS(double start, double end, int numberOfIntervals)` returns the result of performing a middle Riemann sum
- `double RRS(double start, double end, int numberOfIntervals)` returns the result of performing a right Riemann sum

`Function` also allows for different (non-Riemann sum) numerical integration techniques:

- `double trapezoidalSum(double start, double end, int numberOfIntervals)` returns the result of using the [trapezoidal rule](https://en.wikipedia.org/wiki/Trapezoidal_rule)
- `double simpsonsRule(double start, double end, int numberOfIntervals)` returns the result of using [Simpson's rule](https://en.wikipedia.org/wiki/Simpson%27s_rule)
- `double simpsonsThreeEightsRule(double start, double end, int numberOfIntervals)` returns the result of using [Simpson's (3/8)ths rule](https://en.wikipedia.org/wiki/Simpson%27s_rule)
- `double boolesRule(double start, double end, int numberOfIntervals)` returns the result of using [Boole's rule](https://en.wikipedia.org/wiki/Boole%27s_rule)


## The `GUI` class

The `GUI` class is a wrapper around `BreezySwing.GBFrame` that is customized for accepting user input regarding functions.
