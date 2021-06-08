package ec.app.schaffer;
/**
 * @author Chenxing Li
 * @email lichenxingbeijing@163.com
 */
import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;

@SuppressWarnings("serial")
public class SchafferPro20 extends GPProblem implements SimpleProblemForm { 
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
	        float x = ((SchafferData)input).x;
	        x       = Math.max(x, -10f);
	        x       = Math.min(x, 10f);
	        rep[t]  = x;
	      }
	      
	      float   fit  = 0f;
	      int     hits = 0;
	      for (int t=0; t<DIM; t++) {
	        if (Math.abs(rep[t]) <= 1e-8f)
	          hits++;
	        float d = 0.50f;
	        float temp1 = (float) ((Math.sin(rep[t] * rep[t])-(rep[t+1] * rep[t+1]))*(Math.sin(rep[t] * rep[t])-(rep[t+1] * rep[t+1])));
	        float temp2 = (float) (1.0f + (0.001f*((rep[t] * rep[t])+(rep[t+1] * rep[t+1]))));
	        fit += d + (temp1 - d) / (temp2 * temp2);
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