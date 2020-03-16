/*
Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 
*/

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        int j = 0;
        for(int i=0; i<n-1; i++) {
            if(!a.get(i).equals(a.get(i+1))) {
                a.set(j++, a.get(i));
            }
        }
        a.set(j++, a.get(n-1));
        return j;
    }
}
