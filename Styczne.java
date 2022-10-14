package com.company;

public class Styczne {

    public static double f(double x)
    {
        return Math.pow(x,2) + x -5;
    }

    public static double fprim(double x)
    {
        return 2*x + 1;
    }

    public static double fprimprim(double x)
    {
        return 2;
    }

    public static double styczne(double a,double b,double e)
    {
        if(f(a) * f(b) < 0)
        {
            System.out.println("warunek konieczny niespełniony");
            return -1;
        }

        if(fprim(a) * fprim(b) < 0 || fprimprim(a) * fprimprim(b) <0)
        {
            System.out.println("warunki zbieżności nie są spełnione");
            return -2;
        }

        if()
    }

    public static void main(String[] args) {
        double a=1,b=2,e = 0.05;

    }
}
