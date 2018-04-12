

public class NewtonTwo {
    public static void main(String[] args) {
        double uZero[] = {-1, 1 , -1};
     //   double uZero[] = {2,1,1};
        double epsilon = 0.001;
        double[] u = {0,0,0};
        double[][] reverseJSD = functionOnReverseMatrice(functionOnSecondDerivative());
        double[] jDerivative;
        double check[]= {0,0,0};
        double checking = 0;
       // double h[] = new double[3];

        do{
            jDerivative = functionOnFirstDerivative(uZero);

            double[] mulMatrices = mul(reverseJSD, jDerivative);
            for (int i = 0; i < 3; i++) {
                u[i] = uZero[i] - mulMatrices[i];
            }

            for (int i = 0; i < 3; i++) {
                uZero[i] = u[i];
            }

            check = functionOnFirstDerivative(uZero);
            checking = Math.pow(Math.pow(check[0],2)+Math.pow(check[1], 2)+Math.pow(check[2],2), 0.5);
            double[] output = functionOnFirstDerivative(u);

            System.out.println();
        }while (Math.abs(checking)>epsilon);

        System.out.print("u: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(u[i]+"  ");
        }
        System.out.print("J: ");
        double[] output = functionOnFirstDerivative(u);
        for (int i = 0; i < 3; i++) {
            System.out.print(output[i]+"  ");
        }
    }




    public static double function(double[] u){
        return Math.pow((2 * u[0] + u[1] + u[2]), 2) + Math.pow((u[0] + u[1] - u[2]),2) +Math.pow((u[0] - u[1] + 3 * u[2]),2);
    }

    public static double[] functionOnFirstDerivative(double[] u){
      /// double [][] jConst = {{12, 4, 8},{4,6,-6}, {8, -6, 22}};
//       double j[] = findJDerivative(jConst, u);
       double[]j = {12*u[0]+4*u[1]-2*u[2]+3,4*u[0] + 10*u[1] + 6*u[2] - 2,-2*u[0] + 6*u[1] + 8*u[2]+1};

       // double[] j = mul(jConst, u);
        return j;
    }

    public static double[][] functionOnSecondDerivative(){
      //  double[][] j = {{12, 4, 8},{4,6,-6},{8, -6, 22}};
       double[][] j = {{12, 4, -2},{4,10,6},{-2, 6,8}};
        return j;
    }

    public static double[][] functionOnReverseMatrice(double[][] matrice){
        int n = matrice.length;
        double[][] l = new double[n][n];

        for(int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                l[i][j] = 0.0;
            }
        }
        for (int k = 0; k<n; k++){

            for(int i = 0; i<n; i++) {
                l[i][i] = 1;
            }
            for(int i = k+1; i<n; i++){    //n-1
                l[i][k] = matrice[i][k]/matrice[k][k];
            }


            for(int i = k+1; i<n; i++){
                double factor = matrice[i][k]/matrice[k][k];
                for (int j = k; j < n ; j++) {
                    matrice[i][j] = matrice[i][j] - factor*matrice[k][j];
                }
            }
        }
        double[] b1 = {1,0,0};
        double[] b2 = {0,1,0};
        double[] b3 = {0,0,1};


        double d1[] = findElementsOfMatrice(l, b1);
        double d2[] = findElementsOfMatrice(l, b2);
        double d3[] = findElementsOfMatrice(l, b3);

        double x1[] = findElementsOfMatrice(matrice, d1);
        double x2[] = findElementsOfMatrice(matrice, d2);
        double x3[] = findElementsOfMatrice(matrice, d3);
       // x2 = new double[]{-4.25, 6.25, 3.25};
        x2 = new double[]{-0,167,0.348, -0.303};

        double[][] aMinus = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                aMinus[i][j] = 0.0;
            }
        }

        for (int i = 0; i < n; i++) {
            aMinus[i][1] = x2[i];
            aMinus[i][0] = x1[i];
            aMinus[i][2] = x3[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(aMinus[i][j] + "    ");
            }
            System.out.println();
        }


        return l;
    }



    public static double[] findElementsOfMatrice(double[][] matrice, double[] b){
        int n = b.length;
        double[] x = new double[n];

        for (int k = 0; k<n; k++){

            for(int i = k+1; i<n; i++){
                double factor = matrice[i][k]/matrice[k][k];
                for (int j = k; j < n ; j++) {
                    matrice[i][j] = matrice[i][j] - factor*matrice[k][j];
                }
                b[i] = b[i] - factor*b[k];
            }
        }

        double sum;
        x[n-1] = b[n-1]/matrice[n-1][n-1];
        for (int i = n-1; i >= 0; i--) {
            sum = b[i];
            for (int j = i+1; j <n; j++) {
                sum = sum - matrice[i][j]*x[j];
            }
            x[i] =sum/matrice[i][i];
        }
        return x;
    }

    public static double[] mul(double[][] a, double[] b){

       double result[] = new double[b.length];
       double sum = 0;
        for (int i = 0; i <b.length; i++) {
            sum = 0;
            for (int j = 0; j < b.length; j++) {
                sum += a[i][j] * b[j];
            }
            result[i] = sum;
        }
        return result;
    }
}
