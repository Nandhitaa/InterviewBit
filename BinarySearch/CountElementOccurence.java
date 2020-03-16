/*
Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.
*/

import java.util.List;

public class CountElementOccurence {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    private int findFirst(List<Integer> A, int B) {
        int low = 0;
        int high = A.size()-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(A.get(mid)==B && (mid == 0 || B > A.get(mid-1))) {
                return mid;
            }
            else if(B > A.get(mid)) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
    private int findLast(List<Integer> A, int B, int start) {
        int low = start;
        int high = A.size()-1;
        while(low<=high) {
            int mid = (low + high) / 2;
            if(A.get(mid)==B && (mid == A.size()-1 || B < A.get(mid+1))) {
                return mid;
            }
            else if(B < A.get(mid)) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int findCount(final List<Integer> A, int B) {
        int first = findFirst(A, B);
        if(first == -1) return 0;
        int last = findLast(A, B, first);
        return last-first+1;
    }
}
