package ec.app.sphere.func;

import ec.*;
import ec.gp.*;
import ec.app.sphere.*;

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
    SphereData sd = (SphereData)input;
    // evaluate children[1] first to determine if the denominator is 0
    children[1].eval(state, thread, input, stack, individual, problem);
    if (sd.x == 0.0f)
      // the answer is 1.0 since the denominator was 0.0
      sd.x = 1.0f;
    else {
      float result = sd.x;      
      children[0].eval(state, thread, input, stack, individual, problem);
      sd.x = sd.x / result;
    }
  }
}
