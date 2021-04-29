package ec.app.sphere.func;

import ec.*;
import ec.gp.*;
import ec.app.sphere.*;

@SuppressWarnings("serial")
public class Mul extends GPNode {
  @Override
  public String toString() {
    return "*";
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
    children[0].eval(state, thread, input, stack, individual, problem);
    float result = sd.x;
    children[1].eval(state, thread, input, stack, individual, problem); 
    sd.x = result * sd.x;
  }
}
