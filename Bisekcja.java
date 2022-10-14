package com.company;

public class Bisekcja {

    public static double f(double x)
    {
        return Math.pow(x,2) + x -5;
    }


    public static double bisection(double a,double b,double e)
    {
        double xsr=a;


        if(f(a) * f(b) < 0)
        {
            while(Math.abs(f(xsr))>=e)
            {
                xsr = (a+b)/2;

                if(f(xsr) == 0.0)
                    break;
                else if(f(xsr) * f(a) < 0)
                    b = xsr;
                else
                    a = xsr;
            }
        }

        else
        {
            System.out.println("Warunek konieczny niespełniony");
            return -123214210;
        }
        return xsr;
    }

    public static void main(String[] args) {
        double a=1,b=2,e = 0.05;
        System.out.println(bisection(a,b,e));
    }
}
