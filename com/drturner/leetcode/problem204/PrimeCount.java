package com.drturner.leetcode.problem204;

import java.util.ArrayList;

/**
 * ClassName: PrimeCount
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/11
 * Version: 1.0
 */
public class PrimeCount {
    ArrayList<Integer> primes=new ArrayList<>();
    private boolean isPrime(int num){
        if (num%2==0) return false;
        for (int j=0;j<primes.size()&&primes.get(j)*primes.get(j)<=num;j++){
            if (num%primes.get(j)==0) return false;
        }
        return true;
    }
    public int countPrimesNaive(int n) {
        if (n<=2) return 0;
        if (n==3) return 1;
        int count=1;
        primes.add(2);
        for (int i=3;i<n;i+=2){
            if (isPrime(i)) primes.add(i);
           // if (isPrime(i)) count++;
        }
        return primes.size();
    }
    public int countPrimes(int n) {
        if (n<=2) return 0;
        if (n==3) return 1;
        int[] dp=new int[n+1];
        dp[1]=0;
        dp[2]=0;
        dp[3]=1;
        for (int i=4;i<=n;i++){
            dp[i]=isPrime(i)?dp[i-1]+1:dp[i-1];
        }
        return dp[n];
     //   if (isPrime(n)) return countPrimes(n-1)+1;
     //   else return countPrimes(n-1);
    }
    public static void main(String[] args) {
        PrimeCount primeCount = new PrimeCount();
        int num = primeCount.countPrimesNaive(499979);
        System.out.println(num);


    }
}
