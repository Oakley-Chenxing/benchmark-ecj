package ec.app.rastrigin;
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