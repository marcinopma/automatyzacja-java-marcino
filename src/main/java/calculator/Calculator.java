package calculator;

import org.junit.Test;


public class Calculator {
   // Add
    // Subtrack
    // Divide/
    // Multiply

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static double add(double a, double b){
        return a+b;  //ta metoda zwraca sumę dwóch parametrów
    }

    public static double subtract(double a, double b){
        return a-b;
    }

    public static double divide(double a, double b){
        if(a == 0 && b == 0){
            return 0.0;
        }else{
            return a/b;
        }


    }

    public static double multiply(double a, double b){
        return a*b;
    }



}
