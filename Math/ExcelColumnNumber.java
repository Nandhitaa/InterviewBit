/*
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    B -> 2
    C -> 3
    ...
    
    Z -> 26
    AA -> 27
    AB -> 28 
*/

public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int sum = 0;
        for(int i=A.length()-1; i>=0; i--) {
            int pow = A.length()-1-i;
            int digit = A.charAt(i)-'A'+1;
            sum += digit * (Math.pow(26, pow));
        }
        return sum;
    }
}
