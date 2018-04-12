public class GradientDescent {
    public static void main(String[] args) {
        //        double[] u0 = {0,0};
        double[] u0 = {1,2};
        //double[] u0 = {4, 9};
        double jU = function(u0);
        double[] jDU = JDerFunction(u0); // = new double[2];
        double[] u1 = new double[2];
       double check = 0;
       double eps = 0.001;
       double alpha = 1;
       int y = 0;
        jDU = JDerFunction(u0);
        check = Math.pow(Math.pow(  jDU[0], 2)+Math.pow(jDU[1], 2), 0.5);
       while (Math.abs(check)>eps){

            u1[0] = u0[0] - alpha * jDU[0];
            u1[1] = u0[1] - alpha * jDU[1];
            double jU1 = function(u1);
            if(jU > jU1) {
                u0[0] = u1[0];

                u0[1] = u1[1];
                jDU = JDerFunction(u0);
                jU = jU1;
                check = Math.pow(Math.pow(jDU[0], 2)+Math.pow(jDU[1], 2), 0.5);
                alpha = 1;
            } else{
                alpha = alpha/2;
            }
       }
        jU = function(u0);
        System.out.print("u: "+u0[0] + "                           "+u0[1]);
        System.out.println();
        System.out.println("j: "+jU);
        System.out.print("J Der: "+ jDU[0]+"                        "+jDU[1]);

    }

    public static double function(double x[]){
       return Math.pow(x[0], 2) + 10 * Math.pow(x[1],2) - 4 * x[0] - 4*x[1];
    }
    public static double[] JDerFunction(double x[]){
        double[] result = {2*x[0] - 4, 20*x[1] - 4};
        return result;
    }
}
