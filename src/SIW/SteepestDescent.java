package SIW;

public class SteepestDescent {

    static final double e = 2.7183;

    public static void main(String[] args) {
    double u0[] = {0,1};
//        minFunc();
    double jfunc[] = functionDerivative(u0);
    double a = 0;
    double b = 1;
    double lambda = (a+b)/2;
    double[] func = {u0[0] - lambda * jfunc[0], u0[1] - lambda * jfunc[1]};
    double jf = function(func);
    double[] l = new double[2];
     double[] lambdas = new double[2];
    double epsilon = 0.001;
        do {
            lambda = (a+b)/2;
            lambdas[0] = lambda;  //= {lambda, lambda};
            lambdas[1] = lambda;  //= {lambda, lambda};
           l = functionDerivative(lambdas);
//            System.out.println(functionDerivative(lambda,));
            if (l[0] > 0 && l[1] > 0) {
                b = lambda;
            } else if (l[0] < 0 && l[1] < 0) {
                a = lambda;
            }
            if(Math.abs(l[0])<epsilon && Math.abs(l[1])<epsilon){
                System.out.println("BREAK");
                break;
            }
            System.out.println("a : "+a);
            System.out.println("b : "+b);
        }while (Math.abs(b-a)>epsilon);


    }

    public static double function(double[] x){
        return 3 * Math.pow(x[0],2) + x[0] * x[1] + Math.pow(x[1],2) + (-4.5) * x[0] + (-3.5) * x[1];
    }



    public static double[] functionDerivative(double[] x){
        double[] y = {6*x[0] + x[1] - 4.5, 2 * x[1] + x[0] -3.5};
        return y;
    }
    public double jDerAb(double[] x){
        double a =Math.pow(Math.pow(x[0],2) + Math.pow(x[1],2),0.5);
        return a;
    }
}
