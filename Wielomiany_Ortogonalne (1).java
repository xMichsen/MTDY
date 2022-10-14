public class Wielomiany_Ortogonalne {



    //18)
    public static double f(double x)
    {
        return Math.sqrt(3 + 7 * Math.pow(x,2));
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



    public static double Simpson_lambda(int n,double a,double b,int ii)
    {
        double wynik = 0;
        for (int i = 0; i < n; i++) {
            wynik += (h(n,i,a,b)/3) * (f_lambda(wzor_x(n,i,a,b),ii) + (4*f_lambda(t(n,i,a,b),ii)) + f_lambda(wzor_x(n,i+1,a,b),ii));
        }
        return wynik;
    }

    public static double Simpson_C(int n,double a,double b,int ii)
    {
        double wynik = 0;
        for (int i = 0; i < n; i++) {
            wynik += (h(n,i,a,b)/3) * (f_C(wzor_x(n,i,a,b),ii) + (4*f_C(t(n,i,a,b),ii)) + f_C(wzor_x(n,i+1,a,b),ii));
        }
        return wynik;
    }

    public static double f_lambda(double x,int i)
    {
        return Math.pow(fi(i,x),2);
    }

    public static double f_C(double x,int i)
    {
        return fi(i,x) * f(x);
    }

    public static double fi(int i,double x)
    {
        if(i == 0)
            return 1;
        else if(i == 1)
            return x;
        else if(i == 2)
            return (3 * Math.pow(x,2) - 1)/2;
        else if(i == 3)
            return (5 * Math.pow(x,3) - 3*x)/2;
        else if(i == 4)
            return (35 * Math.pow(x,4) - 30*Math.pow(x,2) + 3)/8;
        else if(i == 5)
            return (63 * Math.pow(x,5) - 70*Math.pow(x,3) + 15*x)/8;
        else if(i == 6)
            return (231 * Math.pow(x,6) - 315*Math.pow(x,4) + 105*Math.pow(x,2) - 5)/16;
        else if(i == 7)
            return (429 * Math.pow(x,7) - 693*Math.pow(x,5) + 315*Math.pow(x,3) - 35*x)/16;
        else if(i == 8)
            return (6435 * Math.pow(x,8) - 12012*Math.pow(x,6) + 6930*Math.pow(x,4) - 1260*Math.pow(x,2) + 35)/128;
        else if(i == 9)
            return (12155 * Math.pow(x,9) - 25740*Math.pow(x,7) +
                    18018*Math.pow(x,5) - 4620*Math.pow(x,3) + 315 * x)/128;
        else if(i == 10)
            return (46189 * Math.pow(x,10) - 109395*Math.pow(x,8) +
                    90090*Math.pow(x,6) - 30030*Math.pow(x,4) + 3465 * Math.pow(x,2) - 63)/128;
        else return 0;
    }

    public static double g(double a,double b,int n,double x)
    {
        double suma = 0;
        for (int i = 0; i <= n; i++) {
            suma += (1/Simpson_lambda(20,a,b,i) * Simpson_C(20,a,b,i)) * fi(i,x);
        }
        return suma;
    }

    public static void main(String[] args) {
        double a = -1;
        double b = 1;
        int n = 2;
        double x = -0.25;
        System.out.println("g(x) = " + g(a,b,n,x)); //wynik = 1.8686453834045533
        System.out.println("f(x) = " + f(x)); //wynik = 1.8540496217739157
    }
}