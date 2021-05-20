package ec.app.sphere;

import ec.gp.*;

@SuppressWarnings("serial")
public class SphereData extends GPData {
  @Override
	public void copyTo(final GPData gpd) {
		SphereData sphereData = (SphereData) gpd;
		sphereData.x  = x;
	}

	public float x;
}
