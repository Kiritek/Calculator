package com.company;

public class Calculator {


    public double DoAddition(double a,double b) {
        return a + b;
    }
    public double DoSubtraction(double a,double b){
        return a-b;
    }
    public double DoDivision(double a,double b){
        return a/b;
    }
    public double DoMultiplication(double a,double b){
        return a*b;
    }
    public double DoExponentiation(double a,double b){
        return Math.pow(a,b);
    }

}
