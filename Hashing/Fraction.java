/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"
*/

import java.util.HashMap;

public class Fraction {
    public String fractionToDecimal(int A, int B) {
        long A1 = (long) A;
        long B1 = (long) B;
        if(A1==0 || B1==0) return "0";
        int sign = 1;
        if((A1<0) ^ (B1<0)) {
            sign = -1;
        }
        A1 = Math.abs(A1);
        B1 = Math.abs(B1);
        StringBuilder res = new StringBuilder();
        long quotient = (A1/B1);
        if(sign == -1) {
            res.append("-");
        }
        res.append(quotient);
        long remainder = (A1%B1);
        if(remainder == 0) {
            return res.toString();
        }
        res.append(".");
        boolean repeat = false;
        int index = 0;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(remainder!=0 && !repeat) {
            if(map.containsKey(remainder)) {
                repeat = true;
                index = map.get(remainder);
            }
            else {
                map.put(remainder, res.length());
                remainder = (remainder * 10);
                res.append(remainder/B1);
                remainder %= B1;
            }
        }
        String s = res.toString();
        if(repeat) {
            s = "";
            s += res.toString().substring(0,index);
            s += "(";
            s += res.toString().substring(index,res.length());
            s += ")";
        }
        return s;
    }
}
