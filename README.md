# Particle-swarm-optimization
Particle Swarm Optimization in Java.

Implemented The Particle Swarm Optimization algorithm in Java in  3 variants: Base variant, Inertia Weight and Constriction Factor.
Experimental Results were obtained using 3 topologies: FullGraph, Ring and 4Neighbors.
As objective function, 4 different functions were tested: Rosenbrock, Rastrigin, Sphere and Grienwank.
All of the functions minimum is achieved in 0, thereby the error obtained will be the value of the closest particle to this minimum.

Problem Statement:

Consider the functions: Sphere, Rosenbrock, Rastrigin, Griewank. You can easily find details about these functions on the Internet (formulas, global optima). We study these functions for n = 2 (the argument of each function will be a value in R x R).

For each function you must use:

- 3 topologies: full graph, ring, 4 - neighbours
- 3 pairs (fi1, fi2), chosen by you
- 3 variants of Particle Swarm Optimization (PSO): main algorithm, inertia weight (w), constriction factor (hi).

For 'inertia weight' and 'constriction factor' you must study papers on the Internet in order to find the best parameters to use (w and hi).

A simulation experiment is defined by a topology, a pair (fi1, fi2) and a PSO variant. A simulation experiment has the form:
    for i = 1 ... 10 ( if the running time is too high you can use 3 instead of 10)
        apply a PSO variant (with a topology and a pair (fi1, fi2))
The result of the simulation experiment must be the best solution (from the 10 solutions obtained during the experiment) and the value of the objective function in that solution (point).
Remarks:
    - For each application of a PSO variant (from the 10 of an experiment) you will use as stopping criterion the maximum number of iterations. For all the functions, the maximum number of iterations is 500 (if the running time is too high, you can use 100 or 50 instead of 500).
    - The population dimension will be chosen by you in the range 20-50 (the same dimension for all the functions).

For each function you must perform 27 simulation experiments (3 x 3 x 3).

For each function you must create a comparative table that will contain the 27 solutions found by the simulation experiments. For each simulation experiment you must put in the table: the solution (the point), the value of the objective function in that point and the error (= abs(function value - optimal value)). Represent with 'bold' the best solution(s) obtained in the table (point, function value, error).

The 4 tables will be put in a .pdf file.
Last modified: Tuesday, 8 November 2016, 12:36 AM

