/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result. 
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]
*/

import java.util.ArrayList;

public class MergeTwoSortedListsII {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int j=0;
        int i=0;
        int aSize = a.size();
        int bSize = b.size();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(i<aSize) {
            if(j<bSize && b.get(j)<a.get(i)) {
                ans.add(b.get(j));
                j++;
            }
            else {
                ans.add(a.get(i));
                i++;
            }
        }
        for(int k=j; k<bSize; k++) {
            ans.add(b.get(k));
        }
        a.clear();
        a.addAll(ans);
    }
}
