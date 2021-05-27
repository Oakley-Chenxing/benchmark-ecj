package ec.app.schaffer;

public class DebugtestSchaffer {
	public static void main(String[] args) {
	    float[] rep = new float[] { 5.80f, 8.25f };
	    float   sch = schaffer(rep);
	    System.out.println("sch: "+sch);
	  }
	 public static float schaffer(float[] rep) {
		 // schaffer function reference:
		 // https://www.sfu.ca/~ssurjano/schaffer2.html
		 float sum = 0.0f;
         float d = 0.50f;
		   for (int i= 1; i<rep.length; i++) {
			   float temp1 = (float) ((Math.sin(rep[i] * rep[i])-(rep[i+1] * rep[i+1]))*(Math.sin(rep[i] * rep[i])-(rep[i+1] * rep[i+1])));
			   float temp2 = (float) (1.0f + (0.001f*((rep[i] * rep[i])+(rep[i+1] * rep[i+1]))));
			   sum += d + (temp1 - d) / (temp2 * temp2);
	 }
			return sum;
}
	 public static final int DIM = 2; 

}
