package ec.app.schaffer;
/**
 * @author Chenxing Li
 * @email lichenxingbeijing@163.com
 */
import ec.gp.*;
@SuppressWarnings("serial")
public class SchafferData extends GPData {
	@Override
	public void copyTo(final GPData gpd) {
		SchafferData schafferData = (SchafferData) gpd;
		schafferData.x  = x;
	}

	public float x;

}

