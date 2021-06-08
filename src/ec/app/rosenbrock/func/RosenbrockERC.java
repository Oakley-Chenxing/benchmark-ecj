package ec.app.rosenbrock.func;
/**
 * @author Chenxing Li
 * @email lichenxingbeijing@163.com
 */
import ec.*;
import ec.gp.*;
import ec.util.*;
import ec.app.rosenbrock.*;

@SuppressWarnings("serial")
public class RosenbrockERC extends ERC {
	public float value;

	// making sure that we don't have any children is already
	// done in ERC.checkConstraints(), so we don't need to implement that.

	// this will produce numbers from [0.0, 10.0)
	@Override
	public void resetNode(final EvolutionState state, final int thread) {
		value = state.random[thread].nextFloat() * (float) 10.0;
	}

	 @Override
	public int nodeHashCode() {
		// a reasonable hash code
		return this.getClass().hashCode() + Float.floatToIntBits(value);
	}

	@Override
	public boolean nodeEquals(final GPNode node) {
		// check first to see if we're the same kind of ERC -- 
		// won't work for subclasses; in that case you'll need
		// to change this to isAssignableTo(...)
		if (this.getClass() != node.getClass()) return false;
		// now check to see if the ERCs hold the same value
		return (((RosenbrockERC)node).value == value);
	}

	 @Override
	public String encode() {
		return Code.encode(value);
	}

	@Override
	public boolean decode(DecodeReturn dret) {
		// store the position and the string in case they
		// get modified by Code.java
		int    pos  = dret.pos;
		String data = dret.data;

		// decode
		Code.decode(dret);

		if (dret.type != DecodeReturn.T_FLOAT) { // uh oh!
	    // restore the position and the string; it was an error
	    dret.data = data;
	    dret.pos  = pos;
	    return false;
		}

		// store the data
		value = (float) dret.d;
		return true;
	}

	@Override
	public String name() {
		return ""; // I'm the only ERC class, this is fine
	}
	
	@Override
	public String toStringForHumans() {
		return "" + value;
	}
 
	@Override
	public void eval(final EvolutionState state,
									 final int thread,
									 final GPData input,
									 final ADFStack stack,
									 final GPIndividual individual,
									 final Problem problem) {
		((RosenbrockData)(input)).x = value;
	}
}
