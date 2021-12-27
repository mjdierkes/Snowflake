package com.masondierkes;

import java.util.Stack;

public class RecursionProblems {

    public double sumReciprocals(int n){
        if(n == 1)
            return 1;
        return 1.0/n + sumReciprocals(n - 1);
    }

    public int productOfEvens(int n){
        if(n == 1)
            return 2;
        return 2 * n + productOfEvens(n - 1);
    }

    public String conversion(int num, int base){
        System.out.println(num + "/" + base + " == " + num/base + " remainder " + num%base);
        if(num == 0)
            return "";
        return conversion(num/base, base) + (num%base);
    }

    public int matchingDigits(int a, int b){
        if(a < 10 || b < 10)
            return (a % 10 == b % 10 ) ? 1 : 0;
        return ((a % 10 == b % 10 ) ? 1 : 0) + matchingDigits(a/10, b/10);
    }

    public void doubleUp(Stack<Integer> nums){
        if(nums.size() == 0)
            return;
        int num = nums.pop();
        doubleUp(nums);
        nums.push(num); nums.push(num);
    }

    public void printThis(int n){
        if(n <= 2){
            if(n % 2 != 0)
                System.out.print("*");
            else
                System.out.print("**");
        }
        else{
            System.out.print("<");
            printThis(n - 2);
            System.out.print(">");
        }
    }

    public void printNums2(int n){
        if(n <= 2){
            if(n % 2 != 0)
                System.out.print("1");
            else
                System.out.print("1 1");
        }
        else {
            System.out.print((n + 1) / 2);
            System.out.print(" ");
            printNums2(n - 2);
            System.out.print(" ");
            System.out.print((n + 1) / 2);
        }
    }

}
