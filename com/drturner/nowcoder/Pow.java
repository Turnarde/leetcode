package com.drturner.nowcoder;

/**
 * ClassName: Pow
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class Pow {
    private double PowerSub(double base, int exponent){
        if (exponent==0) return 1;
        double res=base;
        for (int i=1;i<exponent;i++){
            res*=base;
        }
        return res;
    }
    public double Power(double base, int exponent) {
        if (exponent==0) return 1;
        else if (base==0) return 0;
        return exponent>0?PowerSub(base,exponent):(1/PowerSub(base, -exponent));
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        double power = pow.Power(-5.0, 1);
        System.out.println(power);
    }
}
