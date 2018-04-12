import java.util.Scanner;

public class GoldenSection {
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
        System.out.println("Введи эпсилон: ");
        double epsilon = scanner.nextDouble();
        double gamma = 0.618;

        lambda = a + ((1- gamma)*(b-a));
        mu = a+ (gamma * (b-a));
        System.out.println("lambda: " + lambda);
        System.out.println("mu: " + mu);

        if(epsilon>0 ) {
            System.out.println("Сorrect!");
        }else{
            System.out.println("delta > 0");
            epsilon = scanner.nextDouble();
        }
        do {
            jmu = function(mu);
            jlambda = function(lambda);
           if(jlambda <= jmu){
               b = mu;
               mu = lambda;
               lambda = a+((1-gamma)*(b-a));
           }else if(jlambda > jmu){
               a =lambda;
               lambda = mu;
               mu = a+(gamma*(b-a));
           }
            System.out.println("lambda: "+lambda + "" +
                    " " + "jmu: "+jmu);
            System.out.println("mu: "+mu + " " +
                    ""+"jmu: "+jmu);
            System.out.println("a: "+a);
            System.out.println("b: " +b);
        }while(Math.abs(b-a)>epsilon);

        System.out.println(a+" - a");
        System.out.println(b+" - b");
    }


    public static double function(double u){
        double result = Math.pow(u, 2) + Math.pow(e, -u);
        return result;
    }
}
