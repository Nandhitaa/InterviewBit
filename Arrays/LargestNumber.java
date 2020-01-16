/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        if(A.size() == 0) {
            return String.valueOf(0);
        }
        if(Collections.max(A) == 0 ) {
            return String.valueOf(0);
        }
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer x , Integer y) {
                String xy = x.toString() + y.toString();
                String yx = y.toString() + x.toString();
                return xy.compareTo(yx);
            }
        });
        StringBuffer s = new StringBuffer();
        for(int i=A.size()-1; i>=0; i--) {
            s.append(A.get(i));
        }
        return s.toString();
    }
}
