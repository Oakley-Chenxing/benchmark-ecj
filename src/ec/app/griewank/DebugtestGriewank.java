package ec.app.griewank;

public class DebugtestGriewank {
	public static void main(String[] args) {
	    float[] rep = new float[] { 1.414f, 0.800f };
	    float   gri = griewank(rep);
	    System.out.println("gri: "+gri);
	  }
	 public static float griewank(float[] rep) {
		 //griewank code reference:
		 //http://www.sfu.ca/~ssurjano/griewank.html
		 float sum = 0.0f;
         float d = 1.00f;
		   for (int i=1; i<rep.length; i++) {
			   float temp1 = rep[i]*rep[i];
			   float temp2 = (float) (Math.PI * (Math.cos(rep[i]/Math.sqrt(i))));
			   sum += (1/4000)*temp1 - (temp2)+ d;
	 }
			return sum;
}
	 public static final int DIM = 2; 

}
