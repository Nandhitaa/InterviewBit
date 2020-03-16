/*
Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version

 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations. 


Input Format

The only argument given is integer A.
Output Format

Return a string denoting roman numeral version of A.
Constraints

1 <= A <= 3999
For Example

Input 1:
    A = 5
Output 1:
    "V"

Input 2:
    A = 14
Output 2:
    "XIV"

*/

public class IntegerToRoman {
    // private void build(char c, int n, StringBuilder s) {
    //     for(int i=0; i<n; i++) {
    //         s.append(c);
    //     }
    // }
    public String intToRoman(int A) {
        String m[] = {"", "M", "MM", "MMM"}; 
        String c[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
        String x[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; 
        String i[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return m[(A/1000)] + c[(A%1000)/100] + x[(A%100)/10] + i[(A%10)];
        
        // StringBuilder s = new StringBuilder();
        // while(A!=0) {
        //     if(A>=1000) {
        //         build('M', A/1000, s);
        //         A = A%1000;
        //     }
        //     else if(A>=500) {
        //         if(A<900) {
        //             build('D', A/500, s);
        //             A=A%500;
        //         }
        //         else {
        //             s.append("CM");
        //             A=A%100;
        //         }
        //     }
        //     else if(A>=100) {
        //         if(A<400) {
        //             build('C', A/100, s);
        //         }
        //         else {
        //             s.append("CD");
        //         }
        //         A=A%100;
        //     }
        //     else if(A>=50) {
        //         if(A<90) {
        //             build('L', A/50, s);
        //             A=A%50;
        //         }
        //         else{
        //             s.append("XC");
        //             A=A%10;
        //         }
        //     }
        //     else if(A>=10) {
        //         if(A<40) {
        //             build('X', A/10, s);
        //         }
        //         else {
        //             s.append("XL");
        //         }
        //         A=A%10;
        //     }
        //     else if(A>=5) {
        //         if(A<9) {
        //             build('V', A/5, s);
        //             A=A%5;
        //         }
        //         else {
        //             s.append("IX");
        //             A=0;
        //         }
        //     }
        //     else if(A>=1) {
        //         if(A<4) {
        //             build('I', A, s);
        //             A=0;
        //         }
        //         else {
        //             s.append("IV");
        //             A=0;
        //         }
                
        //     }
        // }
        // return s.toString();
    }
}
