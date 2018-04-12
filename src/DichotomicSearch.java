import java.util.Scanner;

public class DichotomicSearch {
    static final double e = 2.7183;
    public static void main(String[] args) {

        //0<=u<=1
        double a = 0;
        double b = 1;
        double lambda;
        double mu;
        double[] j = new double[10];
        double jmu;
        double jlambda;



        Scanner scanner = new Scanner(System.in);
        double delta = scanner.nextDouble();
        double epsilon = scanner.nextDouble();
        if(delta > 0 && epsilon>0 && epsilon > 2 * delta) {
            System.out.println("Сorrect!");
        }else{
            System.out.println("delta > 0 && epsilon>0 && epsilon > 2 * delta");
            delta = scanner.nextDouble();
            epsilon = scanner.nextDouble();
        }
        do{
            lambda = ((a+b)/2) - delta;
            mu =((a+b)/2) + delta;
            jmu = function(mu) ;
            jlambda = function(lambda);
            if(jmu < jlambda){
                a = lambda;
            }else if(jmu > jlambda){
                b = mu;
            }
            System.out.println(a+" - a");
            System.out.println(b+" - b");
        }while(Math.abs(b-a)>epsilon);

        System.out.println(a+" - a");
        System.out.println(b+" - b");
    }


    public static double function(double u){
        double result = Math.pow(u, 2) + Math.pow(e, -u);
        return result;
    }

}
