package ec.app.sphere;

import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;

@SuppressWarnings("serial")
public class SphereProb2 extends GPProblem implements SimpleProblemForm { 
  @Override
  public void evaluate(final EvolutionState state, 
      final Individual ind,
      final int subpopulation,
      final int threadnum) {
    if (!ind.evaluated) { // don't bother reevaluating
      float fit  = 0f;
      int   hits = 0;
      for (int t=0; t<DIM; t++) {
        ((GPIndividual)ind).trees[t].child.eval
        (state, threadnum, input, stack,
            ((GPIndividual)ind), this);
        float x = ((SphereData)input).x;
        x = Math.max(x, -1f);
        x = Math.min(x, 1f);
        if (x == 0f)
          hits++;
        fit += x*x;
      }

      // the fitness better be KozaFitness!
      KozaFitness f = ((KozaFitness)ind.fitness);
      f.setStandardizedFitness(state, (double)(fit));
      f.hits        = hits;
      ind.evaluated = true;
    }
  }
  
  public static final int DIM = 2;
}
