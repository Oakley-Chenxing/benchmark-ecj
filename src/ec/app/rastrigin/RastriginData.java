package ec.app.rastrigin;
/**
 * @author Chenxing Li
 * @email lichenxingbeijing@163.com
 */
import ec.gp.*;
@SuppressWarnings("serial")
public class RastriginData extends GPData {
	@Override
	public void copyTo(final GPData gpd) {
		RastriginData rastriginData = (RastriginData) gpd;
		rastriginData.x  = x;
	}

	public float x;

}