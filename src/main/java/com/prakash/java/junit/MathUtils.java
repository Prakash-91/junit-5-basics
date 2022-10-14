package com.prakash.java.junit;


public class MathUtils {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double computeCircleArea(int radius) {
        return Math.PI * radius * radius;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int addThree(int a, int b, int c) {
        int sum = a + b + c ;
        System.out.println("Sum is : "+sum);
        return sum;
    }
}
