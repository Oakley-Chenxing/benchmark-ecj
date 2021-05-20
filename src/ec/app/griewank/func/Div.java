package ec.app.griewank.func;

import ec.*;
import ec.gp.*;
import ec.app.griewank.*;


@SuppressWarnings("serial")
public class Div extends GPNode {
  @Override
  public String toString() {
    return "%";
  }

  @Override
  public int expectedChildren() {
    return 2;
  }

  @Override
  public void eval(final EvolutionState state,
      final int thread,
      final GPData input,
      final ADFStack stack,
      final GPIndividual individual,
      final Problem problem) {
    GriewankData rd = (GriewankData)input;
    // evaluate children[1] first to determine if the denominator is 0
    children[1].eval(state, thread, input, stack, individual, problem);
    if (rd.x == 0.0f)
      // the answer is 1.0 since the denominator was 0.0
      rd.x = 1.0f;
    else {
      float result = rd.x;      
      children[0].eval(state, thread, input, stack, individual, problem);
      rd.x = rd.x / result;
    }
  }
}
