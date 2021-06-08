package ec.app.rosenbrock;
/**
 * @author Chenxing Li
 * @email lichenxingbeijing@163.com
 */
import ec.gp.*;

@SuppressWarnings("serial")
public class RosenbrockData extends GPData {
  @Override
	public void copyTo(final GPData gpd) {
		RosenbrockData rosenbrockData = (RosenbrockData) gpd;
		rosenbrockData.x  = x;
	}

	public float x;
}
