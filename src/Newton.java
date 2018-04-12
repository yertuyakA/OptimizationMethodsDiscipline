import java.util.Scanner;

public class Newton {
    static final double e = 2.7183;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //double u = scan.nextDouble();
        double epsilon = scan.nextDouble();
        double u1 = 0;
        double u0 = scan.nextDouble();


      do {
          //u0 = u1;
          u1 = u0 - (derivativeOfFunction(u0)/secondDerivativeOfFunction(u0));
          u0 = u1;
      } while(Math.abs(derivativeOfFunction(u1))>epsilon);
        System.out.println(" Uk : "+u1);
        System.out.println(derivativeOfFunction(u1));
    }

    public static double function(double u){
        double result = Math.pow(u, 2) + Math.pow(e, -u);
        return result;
    }
    public static double derivativeOfFunction(double u){
        double result = 2 * u - Math.pow(e, -u);
        return result;
    }
    public static double secondDerivativeOfFunction(double u){
        double result  = 2 + Math.pow(e, -u);
        return result;
    }


}
