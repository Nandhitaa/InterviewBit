/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*/

import java.util.ArrayList;
import java.util.Collections;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int start = 0;
        for(int i=0; i<A.size(); i++) {
            if(A.get(i)!=0) {
                start = i;
                break;
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int sum = ((A.get(A.size()-1) + 1) % 10 );
        int carry = (A.get(A.size()-1) + 1) / 10;
        ans.add(sum);
        for(int i=A.size()-2; i>=start; i--) {
            sum = (A.get(i) + carry) % 10 ;
            carry = (A.get(i) + carry) / 10;
            ans.add(sum);
        }
        if(carry !=0) { 
            ans.add(carry);
        }
        Collections.reverse(ans);
        return ans;
    }
}
