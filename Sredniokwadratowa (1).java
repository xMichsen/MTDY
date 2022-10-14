public class Sredniokwadratowa {

    //przyklad 18
    public static double[] gaussianElimination(double mat[][])
    {
        int N = mat[0].length-1;

        int singular_flag = forwardElim(mat);

        if (singular_flag != -1)
        {
            System.out.println("Singular Matrix.");

            if (mat[singular_flag][N] != 0)
                System.out.print("Inconsistent System.");
            else
                System.out.print(
                        "May have infinitely many solutions.");
        }

        double[] x = backSub(mat);
        return x;
    }

    public static void swap_row(double mat[][], int i, int j)
    {
        int N = mat[0].length-1;
        for (int k = 0; k <= N; k++)
        {
            double temp = mat[i][k];
            mat[i][k] = mat[j][k];
            mat[j][k] = temp;
        }
    }

    public static void print(double mat[][])
    {
        int N = mat[0].length-1;
        for (int i = 0; i < N; i++, System.out.println())
            for (int j = 0; j <= N; j++)
                System.out.print(mat[i][j]);
        System.out.println();
    }

    public static int forwardElim(double mat[][])
    {
        int N = mat[0].length-1;
        for (int k = 0; k < N; k++)
        {

            int i_max = k;
            int v_max = (int)mat[i_max][k];


            for (int i = k + 1; i < N; i++)
                if (Math.abs(mat[i][k]) > v_max)
                {
                    v_max = (int)mat[i][k];
                    i_max = i;
                }

            if (mat[k][i_max] == 0)
                return k;

            if (i_max != k)
                swap_row(mat, k, i_max);

            for (int i = k + 1; i < N; i++)
            {
                double f = mat[i][k] / mat[k][k];
                for (int j = k + 1; j <= N; j++)
                    mat[i][j] -= mat[k][j] * f;
                mat[i][k] = 0;
            }
        }
        return -1;
    }

    public static double[] backSub(double mat[][])
    {
        int N = mat[0].length-1;
        double x[] = new double[N];
        for (int i = N - 1; i >= 0; i--)
        {
            x[i] = mat[i][N];
            for (int j = i + 1; j < N; j++)
            {
                x[i] -= mat[i][j] * x[j];
            }
            x[i] = x[i] / mat[i][i];
        }

        return x;
    }

    public static double wzor_x(int n,int i,double a,double b)
    {
        double i2 = (double)i;
        double n2 = (double)n;
        return ((i2/n2) * (b-a)) + a;
    }

    public static double t(int n,int i,double a,double b)
    {
        return (wzor_x(n,i+1,a,b) + wzor_x(n,i,a,b))/2;
    }

    public static double h(int n,int i,double a,double b)
    {
        return (wzor_x(n,i+1,a,b) - wzor_x(n,i,a,b))/2;
    }

    public static double Simpson(int n,double a,double b,int ii,int j)
    {
        double wynik = 0;
        for (int i = 0; i < n; i++) {
            wynik += (h(n,i,a,b)/3) * (funkcja(wzor_x(n,i,a,b),ii,j) + (4*funkcja(t(n,i,a,b),ii,j)) + funkcja(wzor_x(n,i+1,a,b),ii,j));
        }
        return wynik;
    }

    public static double Simpson_x(int n,double a,double b,int ii)
    {
        double wynik = 0;
        for (int i = 0; i < n; i++) {
            wynik += (h(n,i,a,b)/3) * (funkcja2(wzor_x(n,i,a,b),ii) + (4*funkcja2(t(n,i,a,b),ii)) + funkcja2(wzor_x(n,i+1,a,b),ii));
        }
        return wynik;
    }

    public static double funkcja2(double x,int i)
    {
        return fi(i,x) * f(x);
    }

    //18)
    public static double f(double x)
    {
        return Math.sqrt(3 + 7 * Math.pow(x,2));
    }

    public static double fi(int i,double x)
    {
        if(i == 0)
            return 1;
        else
            return Math.pow(x,i);
    }

    public static double funkcja(double x,int i,int j)
    {
        return fi(i,x) * fi(j,x);
    }

    public static double[][] aprox_sredniokwadratowa(int n,double a,double b)
    {
        double[][] macierz = new double[n+1][n+2];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+2; j++) {
                if(j < n+1)
                    macierz[i][j] = Simpson(20,a,b,i,j);
                else
                    macierz[i][j] = Simpson_x(20,a,b,i);
            }
        }

        return macierz;
    }

    public static double W(double x,double a,double b,int n)
    {
        double suma = 0;
        double[] wynik = gaussianElimination(aprox_sredniokwadratowa(n,a,b));
        for (int i = 0; i <= n; i++) {
            suma += wynik[i] * Math.pow(x,i);
        }
        return suma;
    }


    public static void main(String[] args) {
        double a = -1;
        double b = 1;
        int n = 2;
        double x = -0.25;
        System.out.println(W(x,a,b,n));
        // wynik = 1.8686453834045527
    }
}
