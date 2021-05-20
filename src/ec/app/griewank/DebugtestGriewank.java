package ec.app.griewank;

public class DebugtestGriewank {
	public static void main(String[] args) {
	    double[] rep = new double[] { 0.500, 0.100 };
	    double   ras = rastrigin(rep);
	    System.out.println("ras: "+ras);
	  }
	 public static double rastrigin(double[] rep) {
		 //griewank code developed from
		 //https://
		 double sum = 0.0;

		   for (int i=0; i<rep.length; i++) {
		    // double temp1 = Math.cos(2.0 * Math.PI * rep[i]);
		     //double temp2 =  rep[i] * rep[i];
		    // sum += (-10.0 * temp1 ) + temp2 + 10;
	 }
			return sum;
}
	 public static final int DIM = 2; 

}
