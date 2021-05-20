package ec.app.rosenbrock;

import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;

@SuppressWarnings("serial")
public class RosenbrockPro6 extends GPProblem implements SimpleProblemForm { 
  @Override
  public void evaluate(final EvolutionState state, 
	      final Individual ind,
	      final int subpopulation,
	      final int threadnum) {
	    if (!ind.evaluated) { // don't bother reevaluating

	      float[] rep  = new float[DIM];
	      for (int t=0; t<DIM; t++) {
	        ((GPIndividual)ind).trees[t].child.eval
	        (state, threadnum, input, stack,
	            ((GPIndividual)ind), this);
	        float x = ((RosenbrockData)input).x;
	        x       = Math.max(x, -10f);
	        x       = Math.min(x, 10f);
	        rep[t]  = x;
	      }
	      
	      float   fit  = 0f;
	      int     hits = 0;
	      for (int t=0; t<DIM-1; t++) {
	        if (Math.abs(rep[t]-1.0f) <= 1e-8f)
	          hits++;
	        float temp1 = (rep[t] * rep[t]) - rep[t + 1];
	        float temp2 = rep[t] - 1.0f;
	        fit += (100.0 * temp1 * temp1) + (temp2 * temp2);
	      }

	      // the fitness better be KozaFitness!
	      KozaFitness f = ((KozaFitness)ind.fitness);
	      f.setStandardizedFitness(state, (double)(fit));
	      f.hits        = hits;
	      ind.evaluated = true;
	    }
	  }
	  
	  public static final int DIM = 6;
	}
