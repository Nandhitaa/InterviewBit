/*
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
*/

import java.util.HashSet;

public class ColorfulNumber {
    public int colorful(int A) {
        String s = String.valueOf(A);
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<s.length(); i++) {
            int k=i;
            for(int j=i; j<s.length(); j++) {
                if(i==j) {
                    k=(s.charAt(i) - '0');
                    if(set.contains(s.charAt(i) - '0')) {
                        return 0;
                    }
                    set.add(s.charAt(i) - '0');
                }
                else {
                    k *= (s.charAt(j) - '0');
                    if(set.contains(k)) {
                        return 0;
                    }
                    set.add(k);
                }
            }
        }
        return 1;
    }
}
