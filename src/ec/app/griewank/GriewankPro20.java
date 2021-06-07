package ec.app.griewank;

import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;

@SuppressWarnings("serial")
public class GriewankPro20 extends GPProblem implements SimpleProblemForm { 
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
	        float x = ((GriewankData)input).x;
	        x       = Math.max(x, -10f);
	        x       = Math.min(x, 10f);
	        rep[t]  = x;
	      }
	      float   fit  = 0.0f;
	      float   sum = 0.0f;
	      float   prod = 1.0f;
	      int     hits = 0;
	      for (int t=0; t<DIM; t++) {
	        if (Math.abs(rep[t]) <= 1e-8f)
	          hits++;
	        float temp1 = (rep[t] * rep[t]);
	        sum += temp1;
	        float temp2 = (float) (Math.cos(rep[t]/Math.sqrt(t + 1)));
	        prod *= temp2;
	        fit += (1/4000)*sum - prod + 1.0f;
	      }

	      // the fitness better be KozaFitness!
	      KozaFitness f = ((KozaFitness)ind.fitness);
	      f.setStandardizedFitness(state, (double)(fit));
	      f.hits        = hits;
	      ind.evaluated = true;
	    }
	  }
	  
	  public static final int DIM = 20;
	}

