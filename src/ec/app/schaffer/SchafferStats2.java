package ec.app.schaffer;
/**
 * @author Chenxing Li
 * @email lichenxingbeijing@163.com
 */
import ec.*;
import ec.gp.*;
import ec.simple.*;

@SuppressWarnings("serial")
public class SchafferStats2 extends SimpleStatistics {
  @Override
  public void finalStatistics(final EvolutionState state, final int result) {
    super.finalStatistics(state,result);

    if (doFinal) {
      System.out.print("[ ");
      GPData       input = new SchafferData();
      GPIndividual ind   = (GPIndividual)best_of_run[0];
      for (int t=0; t<SchafferPro2.DIM; t++) {
        ind.trees[t].child.eval(state, 0, input, null, ind, null);
        float x = ((SchafferData)input).x;
        x = Math.max(x, -1f);
        x = Math.min(x, 1f);
        System.out.format("%.8f ", x);
      }
      System.out.println("]");
    }
  }
}