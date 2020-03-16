/*
Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
PROBLEM APPROACH:

Note: If you know the number of times the array is rotated, then this problem becomes trivial. If the number of rotation is x, then minimum element is A[x].
*/

import java.util.List;

public class RotatedArray {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        int low = 0;
        int high = a.size()-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(mid<high && a.get(mid) > a.get(mid+1)) {
                return a.get(mid+1);
            }
            else if(mid>low && a.get(mid)<a.get(mid-1)) {
                return a.get(mid);
            }
            else if(a.get(low) < a.get(mid)) {
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return a.get(0);
    }
}
