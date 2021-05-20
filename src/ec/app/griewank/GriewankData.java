package ec.app.griewank;
import ec.gp.*;
@SuppressWarnings("serial")
public class GriewankData extends GPData {
	@Override
	public void copyTo(final GPData gpd) {
		GriewankData griewankData = (GriewankData) gpd;
		griewankData.x  = x;
	}

	public float x;

}