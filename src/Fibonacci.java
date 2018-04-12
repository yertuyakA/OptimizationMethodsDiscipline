import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    static final double e = 2.7183;
    public static void main(String[] args) {

        //0<=u<=1
        double a = 0;
        double b = 1;
        double lambda;
        double mu;
        //double[] j = new double[10];
        double jmu;
        double jlambda;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи дельта: ");
        double delta = scanner.nextDouble();
        double gamma = 0.618;
        int k = 3;
        int n = 3;
        List<Integer> f = new ArrayList<>();
        f.add(0, 1);
        f.add(1, 1);
        f.add(2, 2);

        while(f.get(n-1) <= ((b-a)/delta)){
            n++;
            f.add(k, f.get(k-2) + f.get(k-1));
            k++;
        }
        //while(f.get(n-1)>((b-a)/delta));

        for (int c : f) {
            System.out.print(c + " ");
        }


        System.out.println("n: "+n);
        double di = (b-a)/f.get(n-1);
        System.out.print("di : "+di);

        lambda = a + (f.get(n-3))*di;
        mu = a+ (f.get(n-2))*di;

        for (int i = n-2; i >= 2; i--) {

            jmu = function(mu);
            jlambda = function(lambda);
            if(jlambda < jmu){
                b = mu;
                mu = lambda;
              //  lambda = a+((f.get(i-2)/f.get(i))*(b-a));
                lambda = a+(f.get(i-2))* (b-a)/f.get(i);
            }else{
                a =lambda;
                lambda = mu;
            //    mu = a+(f.get(i-1)/f.get(i))*(b-a);
                mu = a+(f.get(i-1))*(b-a)/f.get(i);;
            }
            System.out.println("lambda: "+lambda + "" +
                    " " + "jmu: "+jmu);
            System.out.println("mu: "+mu + " " +
                    ""+"jmu: "+jmu);
            System.out.println("a: "+a);
            System.out.println("b: " +b);
        }


        System.out.println(a+" - a");
        System.out.println(b+" - b");
    }


    public static double function(double u){
        double result = Math.pow(u, 2) + Math.pow(e, -u);
        return result;
    }
}
