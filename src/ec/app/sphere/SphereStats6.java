package ec.app.sphere;

import ec.*;
import ec.gp.*;
import ec.simple.*;

@SuppressWarnings("serial")
public class SphereStats6 extends SimpleStatistics {
  @Override
  public void finalStatistics(final EvolutionState state, final int result) {
    super.finalStatistics(state,result);

    if (doFinal) {
      System.out.print("[ ");
      GPData       input = new SphereData();
      GPIndividual ind   = (GPIndividual)best_of_run[0];
      for (int t=0; t<SphereProb6.DIM; t++) {
        ind.trees[t].child.eval(state, 0, input, null, ind, null);
        float x = ((SphereData)input).x;
        x = Math.max(x, -1f);
        x = Math.min(x, 1f);
        System.out.format("%.8f ", x);
      }
      System.out.println("]");
    }
  }
}
