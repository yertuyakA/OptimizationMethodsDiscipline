package SIW;

public class SteepestDescentTwo {
    static final double e = 2.7183;

    public static void main(String[] args) {
        double u0[] = {1,1};
        double jfunc[] = functionDerivative(u0);
        double a = 0;
        double b = 1;
        double lambda;
        double gamma = 0.618;
        double mu;
        double jmu;
        double jlambda;
        double u1[] = new double[2];

        lambda = a + ((1- gamma)*(b-a));
        mu = a+ (gamma * (b-a));
        double epsilon = 0.001;


            double[][] func = {{u0[0] - mu * jfunc[0], u0[1] - mu * jfunc[1]},
                    {u0[0] - lambda * jfunc[0], u0[1] - lambda * jfunc[1]}};

//        double jf = function(func);

            do {
                func[0] = new double[]{u0[0] - mu * jfunc[0], u0[1] - mu * jfunc[1]};
                func[1] = new double[]{u0[0] - lambda * jfunc[0], u0[1] - lambda * jfunc[1]};
                jmu = function(func[0]);
                jlambda = function(func[1]);
                if (jlambda <= jmu) {
                    b = mu;
                    mu = lambda;
                    lambda = a + ((1 - gamma) * (b - a));
                } else if (jlambda > jmu) {
                    a = lambda;
                    lambda = mu;
                    mu = a + (gamma * (b - a));
                }
            } while (Math.abs(b - a) > epsilon);
            double c = (a + b) / 2;
            double alpha = 0;
            if (a < b && a < c) {
                alpha = a;
            } else if (c < b && c < a) {
                alpha = c;
            } else if (b < a && b < c) {
                alpha = b;
            }
            System.out.println(alpha);

        do{
            double[] jDer = functionDerivative(u0);
            u1[0] = u0[0] - alpha * jDer[0];
            u1[1] = u0[1] - alpha * jDer[1];
            u0[0] = u1[0];
            u0[1] = u1[0];

            System.out.println(Math.pow(Math.pow(u0[0],2) + Math.pow(u0[1],2),0.5));

        }while((Math.pow(Math.pow(u0[0],2) + Math.pow(u0[1],2),0.5)) > epsilon);

        System.out.println(u0[0] + " "+u0[1]);
        System.out.println(function(u0));
    }

    public static double function(double[] x){
        return 3 * Math.pow(x[0],2) + x[0] * x[1] + Math.pow(x[1],2) + (-4.5) * x[0] + (-3.5) * x[1];
    }



    public static double[] functionDerivative(double[] x){
        double[] y = {6*x[0] + x[1] - 4.5, 2 * x[1] + x[0] -3.5};
        return y;
    }
    public static double jDerAb(double[] x){
        double a =Math.pow(Math.pow(x[0],2) + Math.pow(x[1],2),0.5);
        return a;
    }
}
