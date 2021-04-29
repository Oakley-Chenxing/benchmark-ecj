package ec.app.sphere;

import ec.*;
import ec.gp.*;
import ec.gp.koza.*;
import ec.simple.*;
import ec.util.*;

@SuppressWarnings("serial")
public class SphereProb extends GPProblem implements SimpleProblemForm {
  @Override
  public void setup(final EvolutionState state,
                    final Parameter base) {
    // very important, remember this
    super.setup(state, base);

    // not using any default base -- it's not safe
  }
  
  @Override
  public void evaluate(final EvolutionState state, 
      final Individual ind,
      final int subpopulation,
      final int threadnum) {
    if (!ind.evaluated) { // don't bother reevaluating
      int fit = 0;

      // the fitness better be KozaFitness!
      KozaFitness f = ((KozaFitness)ind.fitness);
      f.setStandardizedFitness(state, (double)(fit));
      f.hits        = 0;
      ind.evaluated = true;
    }
  }
}
