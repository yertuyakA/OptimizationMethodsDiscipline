import java.util.Scanner;

public class Bisection {
    static final double e = 2.7183;
    public static void main(String[] args) {

        //0<=u<=1
        double a = 0;
        double b = 1;
        double lambda;
        //double mu;
        //double[] j = new double[10];
        double jmu;
        double jlambda;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи дельту: ");
        double epsilon = scanner.nextDouble();
        //double gamma = 0.618;


        //    System.out.print(c + " ");
        do {
            lambda = (a+b)/2;
            System.out.println(derivativeOfFunction(lambda));
            if (derivativeOfFunction(lambda) > 0) {
                b = lambda;
            } else if (derivativeOfFunction(lambda) < 0) {
                a = lambda;
            }
            if(Math.abs(derivativeOfFunction(lambda))<epsilon){
                System.out.println(derivativeOfFunction(lambda));
                break;
            }
            System.out.println("a : "+a);
            System.out.println("b : "+b);
        }while (Math.abs(b-a)>epsilon);

        System.out.println(a+" - a");
        System.out.println(b+" - b");
    }


    public static double function(double u){
        double result = Math.pow(u, 2) + Math.pow(e, -u);
        return result;
    }
    public static double derivativeOfFunction(double u){
        double result = 2 * u - Math.pow(e, -u);
        return result;
    }
}
